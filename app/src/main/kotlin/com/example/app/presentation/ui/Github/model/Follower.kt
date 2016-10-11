package com.example.app.presentation.ui.github.model

import android.os.Parcel
import android.os.Parcelable

data class Follower(

        val id: Int = 0,

        val avatar_url: String,

        val login: String
) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Follower> = object : Parcelable.Creator<Follower> {
            override fun createFromParcel(source: Parcel): Follower = Follower(source)
            override fun newArray(size: Int): Array<Follower?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readInt(), source.readString(), source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(id)
        dest?.writeString(avatar_url)
        dest?.writeString(login)
    }
}