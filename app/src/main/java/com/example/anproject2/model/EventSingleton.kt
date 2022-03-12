package com.example.anproject2.model

object EventSingleton {
    var myEventList: MutableList<Event> = mutableListOf()
    var myNewEvent: Event? = null
}