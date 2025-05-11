package com.kaanalabalik.workshopapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eventList = listOf(
            Event("AI Workshop", "May 20, 2025", "Learn about AI basics.", "Dr. Smith"),
            Event("Mobile App Talk", "May 21, 2025", "Discuss modern mobile apps.", "Prof. Lee")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EventAdapter(eventList) { event ->
            val intent = Intent(this, EventDetailActivity::class.java)
            intent.putExtra("event", event)
            startActivity(intent)
        }
    }
}
