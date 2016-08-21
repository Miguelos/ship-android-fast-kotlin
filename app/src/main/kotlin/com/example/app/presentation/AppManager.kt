package com.example.app.presentation

import android.os.Build
import android.os.StrictMode
import com.example.app.BuildConfig
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.squareup.leakcanary.LeakCanary
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppManager
@Inject
constructor(
        private val application: AndroidApplication,
        private val imagePipelineConfig: ImagePipelineConfig
) {
    companion object {

        private val DEBUG = "debug"
        private val STAGE = "stage"
        private val RELEASE = "release"

        private fun enableStrictMode() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().penaltyDeathOnNetwork().build())
            }
        }
    }

    fun init() {

        initLeakCanary()
        initFresco()

        when (BuildConfig.BUILD_TYPE) {
            DEBUG -> {
                enableStrictMode()
            }
            STAGE -> {
                enableStrictMode()
            }
            RELEASE -> {

            }
            else -> {

            }
        }
    }

    private fun initLeakCanary() {
        LeakCanary.install(application)
    }

    private fun initFresco() {
        Fresco.initialize(application, imagePipelineConfig)
    }
}