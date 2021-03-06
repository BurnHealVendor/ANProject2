package com.example.anproject2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val title: String,
    val category: String,
    val date: String
) : Parcelable