package ru.karapetiandav.testcase.model

import java.util.*

class Event(val name: String,
            val startTime: Date,
            val endTime: Date) {

    companion object {
        val TYPE = "Event"
        val EVENT_NAME = "name"
        val START_TIME = "start_time"
        val END_TIME = "end_time"
    }
}