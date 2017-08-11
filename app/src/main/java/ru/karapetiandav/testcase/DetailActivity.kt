package ru.karapetiandav.testcase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import ru.karapetiandav.testcase.model.Event
import ru.karapetiandav.testcase.model.Move
import ru.karapetiandav.testcase.model.Notice
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {

    private val TAG: String = "D/DetailActivity"

    private lateinit var title: TextView
    private lateinit var detail: TextView
    private lateinit var detail2: TextView
    private lateinit var detail3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_activity)

        title = findViewById(R.id.title)
        detail = findViewById(R.id.detail)
        detail2 = findViewById(R.id.detail2)
        detail3 = findViewById(R.id.detail3)

        when (intent.getStringExtra("type")) {
            "Notice" -> {
                title.text = intent.getStringExtra(Notice.NOTICE_EXTRA_NAME)
                detail.text = "Gate " + intent.getStringExtra(Notice.NOTICE_EXTRA_GATE)
                detail2.text = "Flight date " + formatDate(intent.getLongExtra(Notice.NOTICE_EXTRA_FLIGHTDATE, Date().time))
            }
            "Move" -> {
                title.text = intent.getStringExtra(Move.MOVE_EXTRA_NAME)
                detail.text = "From place " + intent.getStringExtra(Move.MOVE_FROM_PLACE)
                detail2.text = "To place " + intent.getStringExtra(Move.MOVE_TO_PLACE)
                detail3.text = "Estimated time " + intent.getStringExtra(Move.MOVE_ESTIMATE_TIME)
            }
            "Event" -> {
                title.text = intent.getStringExtra(Event.EVENT_NAME)
                detail.text = "Start time " + formatDate(intent.getLongExtra(Event.START_TIME, 0))
                detail2.text = "End time " + formatDate(intent.getLongExtra(Event.END_TIME, 0))
            }
        }
    }

    fun formatDate(long: Long): String {
        val format: SimpleDateFormat = SimpleDateFormat("dd MMM YYYY, hh:ss")
        return format.format(Date(long))
    }

}
