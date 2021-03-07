package com.example.androiddevchallenge.ui.home.pets

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class Pet(
    val id: Int = 0,
    val name: String = "",
    val breed: String = "",
    val gender: String = "",
    val age: Int = 0,
    val weight: Int = 0,
    val owner: String = "",
    val description: String = "",
    val isFavourite: Boolean = false,
    val distance: Double = 0.0,
    val images: ArrayList<String> = arrayListOf("")
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble(),
        parcel.createStringArrayList() as ArrayList<String>
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(breed)
        parcel.writeString(gender)
        parcel.writeInt(age)
        parcel.writeInt(weight)
        parcel.writeString(owner)
        parcel.writeString(description)
        parcel.writeByte(if (isFavourite) 1 else 0)
        parcel.writeDouble(distance)
        parcel.writeStringList(images)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pet> {
        override fun createFromParcel(parcel: Parcel): Pet {
            return Pet(parcel)
        }

        override fun newArray(size: Int): Array<Pet?> {
            return arrayOfNulls(size)
        }
    }
}