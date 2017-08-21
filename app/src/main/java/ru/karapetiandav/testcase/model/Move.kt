package ru.karapetiandav.testcase.model

import android.os.Parcel
import android.os.Parcelable

class Move(
        val name: String,
        val fromPlace: String,
        val toPlace: String,
        val estimateTime: TimeInterval) {

    companion object {
        val TYPE = "Move"
        val MOVE_EXTRA_NAME = "name"
        val MOVE_FROM_PLACE = "from_place"
        val MOVE_TO_PLACE = "to_place"
        val MOVE_ESTIMATE_TIME = "estimate_time"
    }
}

class TimeInterval() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    fun getDateInterval(): String = "Должно быть сколько осталось до вылета"

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TimeInterval> {
        override fun createFromParcel(parcel: Parcel): TimeInterval {
            return TimeInterval(parcel)
        }

        override fun newArray(size: Int): Array<TimeInterval?> {
            return arrayOfNulls(size)
        }
    }
}
