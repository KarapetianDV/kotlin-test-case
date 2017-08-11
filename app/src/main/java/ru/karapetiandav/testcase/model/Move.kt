package ru.karapetiandav.testcase.model

import java.util.*

class Move(name: String, fromPlace: String, toPlace: String, estimateTime: TimeInterval) {
    var name: String? = name
    var fromPlace: String? = fromPlace
    var toPlace: String? = toPlace
    var estimateTime: TimeInterval? = null

    companion object {
        val MOVE_EXTRA_NAME = "name"
        val MOVE_FROM_PLACE = "from_place"
        val MOVE_TO_PLACE = "to_place"
        val MOVE_ESTIMATE_TIME = "estimate_time"
    }
}

class TimeInterval() {

    fun getDateDiff(date: Date, date2: Date): String {
        var long: Long = date2.time - date.time
        var result: Date = Date(long)

        return ("" + result.hours + ":" + result.minutes)
    }
}
