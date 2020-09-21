package com.async.labs.iss.fragments.home.service.model

import android.os.Parcel
import android.os.Parcelable

data class HomeItemAbout(
    val title: String?,
    val description: String?,
    val subtitle: List<Subtitle>?,
    val youtubeLink: String?,
    val youtubeId: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Subtitle),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeTypedList(subtitle)
        parcel.writeString(youtubeLink)
        parcel.writeString(youtubeId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HomeItemAbout> {
        override fun createFromParcel(parcel: Parcel): HomeItemAbout {
            return HomeItemAbout(parcel)
        }

        override fun newArray(size: Int): Array<HomeItemAbout?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String =
        "\nTitle: $title\nDescription:$description\nSubtitle:$subtitle\nYoutube Link: $youtubeLink\nYoutube Id:$youtubeId\n"
}