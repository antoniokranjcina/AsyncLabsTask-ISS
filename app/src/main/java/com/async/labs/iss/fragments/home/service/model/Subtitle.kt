package com.async.labs.iss.fragments.home.service.model

import android.os.Parcel
import android.os.Parcelable

data class Subtitle(val title: String?, val paragraphs: List<Paragraphs>?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArrayList(Paragraphs)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeTypedList(paragraphs)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Subtitle> {
        override fun createFromParcel(parcel: Parcel): Subtitle {
            return Subtitle(parcel)
        }

        override fun newArray(size: Int): Array<Subtitle?> {
            return arrayOfNulls(size)
        }
    }
}