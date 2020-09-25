package com.async.labs.iss.fragments.home.service.model

import android.os.Parcel
import android.os.Parcelable

data class HomeWikipediaItems(
    val _id: String?,
    val title: String?,
    val description: String?,
    val subtitle: List<Subtitles>?,
    val youtubeLink: String?,
    val youtubeId: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Subtitles),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeTypedList(subtitle)
        parcel.writeString(youtubeLink)
        parcel.writeString(youtubeId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HomeWikipediaItems> {
        override fun createFromParcel(parcel: Parcel): HomeWikipediaItems {
            return HomeWikipediaItems(parcel)
        }

        override fun newArray(size: Int): Array<HomeWikipediaItems?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String =
        "\nTitle: $title\nDescription:$description\nSubtitle:$subtitle\nYoutube Link: $youtubeLink\nYoutube Id:$youtubeId\n"
}