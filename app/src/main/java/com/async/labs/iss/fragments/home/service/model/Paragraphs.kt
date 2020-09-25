package com.async.labs.iss.fragments.home.service.model

import android.os.Parcel
import android.os.Parcelable

data class Paragraphs(val paragraph: String?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(paragraph)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Paragraphs> {
        override fun createFromParcel(parcel: Parcel): Paragraphs {
            return Paragraphs(parcel)
        }

        override fun newArray(size: Int): Array<Paragraphs?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String = "\n\t $paragraph"
}