package ru.karapetiandav.testcase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ru.karapetiandav.testcase.adapters.RecyclerAdapter
import ru.karapetiandav.testcase.model.Event
import ru.karapetiandav.testcase.model.Move
import ru.karapetiandav.testcase.model.Notice
import ru.karapetiandav.testcase.model.TimeInterval
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        val list: MutableList<Any> = mutableListOf()
        for (i in 0..recyclerLength()) {
            list.add(Notice("Notice #" + i, Date(), "#" + i))
            list.add(Move("Move #" + i, "Moscow", "Saint Petersburg", TimeInterval()))
            list.add(Event("Event #" + i, Date(), Date()))
        }
        val adapter: RecyclerAdapter = RecyclerAdapter(list)
        recyclerView.adapter = adapter
    }

    private fun initRecyclerView() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun recyclerLength(): Int {
        val random: Random = Random()
        return random.nextInt(33)
    }
}
