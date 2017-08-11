package ru.karapetiandav.testcase.model

import java.util.*

data class Notice(val nameIn: String, val date: Date, val gateIn: String) {
    var name: String = nameIn
    var flightDate: Date? = date
    var gate: String? = gateIn

    companion object {
        val NOTICE_EXTRA_NAME: String = "notice_name"
        val NOTICE_EXTRA_FLIGHTDATE: String = "flight_date"
        val NOTICE_EXTRA_GATE: String = "gate"
    }
}