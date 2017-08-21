package ru.karapetiandav.testcase.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.karapetiandav.testcase.DetailActivity
import ru.karapetiandav.testcase.R
import ru.karapetiandav.testcase.model.Event
import ru.karapetiandav.testcase.model.Move
import ru.karapetiandav.testcase.model.Notice
import ru.karapetiandav.testcase.model.TimeInterval

class RecyclerAdapter(private val items: List<Any>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val TAG: String = "D/RecyclerAdapter"

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent?.context).inflate(R.layout.recycler_view_item, parent, false)
        val vh = ViewHolder(v)

        vh.itemView.setOnClickListener({
            createIntent(parent, vh)
        })

        return vh
    }

    private fun createIntent(parent: ViewGroup?, vh: ViewHolder) {
        val intent = Intent(parent!!.context, DetailActivity::class.java)

        when (items[vh.adapterPosition]) {
            is Notice -> {
                val notice: Notice = items[vh.adapterPosition] as Notice
                intent.putExtra(RecyclerAdapter.TYPE, Notice.TYPE)
                intent.putExtra(Notice.NOTICE_EXTRA_NAME, notice.name)
                intent.putExtra(Notice.NOTICE_EXTRA_FLIGHTDATE, notice.date)
                intent.putExtra(Notice.NOTICE_EXTRA_GATE, notice.gate)
            }
            is Move -> {
                val move: Move = items[vh.adapterPosition] as Move
                intent.putExtra(RecyclerAdapter.TYPE, Move.TYPE)
                intent.putExtra(Move.MOVE_EXTRA_NAME, move.name)
                intent.putExtra(Move.MOVE_FROM_PLACE, move.fromPlace)
                intent.putExtra(Move.MOVE_TO_PLACE, move.toPlace)
                intent.putExtra(Move.MOVE_ESTIMATE_TIME, TimeInterval())
            }
            is Event -> {
                val event: Event = items[vh.adapterPosition] as Event
                intent.putExtra(RecyclerAdapter.TYPE, Event.TYPE)
                intent.putExtra(Event.EVENT_NAME, event.name)
                intent.putExtra(Event.START_TIME, event.startTime)
                intent.putExtra(Event.END_TIME, event.endTime)
            }
        }

        parent.context.startActivity(intent)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        when (items[position]) {
            is Notice -> {
                val notice: Notice = items[position] as Notice
                holder?.itemTitle?.text = notice.name
            }
            is Move -> {
                val move: Move = items[position] as Move
                holder?.itemTitle?.text = move.name
            }
            is Event -> {
                val event: Event = items[position] as Event
                holder?.itemTitle?.text = event.name
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
    }

    companion object {
        val TYPE = "type"
    }
}