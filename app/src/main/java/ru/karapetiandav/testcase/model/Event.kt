package ru.karapetiandav.testcase.model

import java.util.*

class Event(name: String, startTime: Date, endTime: Date) {
    var name: String? = name
    var startTime: Date? = startTime
    var endTime: Date? = endTime

    companion object {
        val EVENT_NAME = "name"
        val START_TIME = "start_time"
        val END_TIME = "end_time"
    }
}