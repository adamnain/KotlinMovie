package com.nrohmen.kotlinmovie.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by root on 11/15/17.
 */
class Movie(
        @SerializedName("poster_path") val posterPath: String,
        val id: String,
        val title: String) : Parcelable {


    companion object {
        @Suppress("unused")
        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(posterPath)
        dest?.writeString(title)
    }

    fun getPosterUrl(): String
    {
        return "http://image.tmdb.org/t/p/w342$posterPath"
    }
}
