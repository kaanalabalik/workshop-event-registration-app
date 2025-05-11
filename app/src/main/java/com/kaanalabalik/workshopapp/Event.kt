package com.kaanalabalik.workshopapp

import java.io.Serializable

data class Event(
    val title: String,
    val date: String,
    val description: String,
    val speaker: String,
    var isRegistered: Boolean = false,
    val comments: MutableList<String> = mutableListOf()
) : Serializable
