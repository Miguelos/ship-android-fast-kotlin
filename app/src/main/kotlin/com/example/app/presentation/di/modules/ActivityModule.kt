package com.example.app.presentation.di.modules

import android.app.Activity
import com.example.app.presentation.di.scopes.PerActivity
import dagger.Module
import dagger.Provides

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
class ActivityModule(private val activity: Activity) {

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    internal fun provideActivity(): Activity {
        return this.activity
    }
}
