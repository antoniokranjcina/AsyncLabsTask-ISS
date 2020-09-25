package com.async.labs.iss.fragments.home.service.model

import android.os.Parcel
import android.os.Parcelable

data class Subtitles(
    val titleSub: String?,
    val paragraphs: List<Paragraphs>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArrayList(Paragraphs)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titleSub)
        parcel.writeTypedList(paragraphs)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Subtitles> {
        override fun createFromParcel(parcel: Parcel): Subtitles {
            return Subtitles(parcel)
        }

        override fun newArray(size: Int): Array<Subtitles?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String = "\n\tTitle: $titleSub\n\tParagraphs: $paragraphs"
}