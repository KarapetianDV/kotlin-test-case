package ru.karapetiandav.testcase.model

import org.joda.time.DateTime

data class Notice(
        val name: String,
        val date: DateTime,
        val gate: String) {

    companion object {
        val TYPE = "Notice"
        val NOTICE_EXTRA_NAME: String = "notice_name"
        val NOTICE_EXTRA_FLIGHTDATE: String = "flight_date"
        val NOTICE_EXTRA_GATE: String = "gate"
    }
}