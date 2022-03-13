package com.example.anproject2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anproject2.R
import com.example.anproject2.model.Event
import com.example.anproject2.model.EventSingleton

class EventAdapter(
    private val eventList: MutableList<Event> = EventSingleton.myEventList,
    private var mListener : OnItemClickListener
    ) : RecyclerView.Adapter<EventViewHolder>() {

    fun updateEventData(event: Event) {
        eventList.add(0, event)
        notifyItemInserted(eventList.indexOf(event))
    }

    fun getEventData(position: Int): Event {
        val title: String = eventList[position].title
        val desc: String = eventList[position].category
        val date: String = eventList[position].date

        return Event(title, desc, date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_layout, parent, false)
        return EventViewHolder(eventView, mListener)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        eventList.sortBy { it.date }
        val event = eventList[position]

        holder.bind(event)
    }

    override fun getItemCount(): Int = eventList.size
}

class EventViewHolder(itemView : View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.evTitle)
    private val category: TextView = itemView.findViewById(R.id.evCategory)
    private val date: TextView = itemView.findViewById(R.id.evDate)

    fun bind(event: Event) {
        title.text = event.title
        category.text = event.category
        date.text = event.date
    }

    init {
        itemView.setOnClickListener {
            listener.onItemClicked(adapterPosition)
        }
    }
}

interface OnItemClickListener {
    fun onItemClicked(position: Int)
}