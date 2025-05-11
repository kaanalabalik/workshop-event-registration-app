package com.kaanalabalik.workshopapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EventDetailActivity : AppCompatActivity() {

    private lateinit var event: Event
    private lateinit var commentAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        event = intent.getSerializableExtra("event") as Event

        findViewById<TextView>(R.id.detailTitle).text = event.title
        findViewById<TextView>(R.id.detailDate).text = event.date
        findViewById<TextView>(R.id.detailDesc).text = event.description
        findViewById<TextView>(R.id.detailSpeaker).text = "Speaker: ${event.speaker}"

        val registerButton = findViewById<Button>(R.id.registerButton)
        val statusText = findViewById<TextView>(R.id.registrationStatus)

        if (event.isRegistered) {
            statusText.text = "You are registered."
            registerButton.isEnabled = false
        }

        registerButton.setOnClickListener {
            event.isRegistered = true
            statusText.text = "You are registered."
            registerButton.isEnabled = false
        }

        val commentList = findViewById<ListView>(R.id.commentList)
        commentAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, event.comments)
        commentList.adapter = commentAdapter

        val commentInput = findViewById<EditText>(R.id.commentInput)
        val commentButton = findViewById<Button>(R.id.commentButton)

        commentButton.setOnClickListener {
            val commentText = commentInput.text.toString()
            if (commentText.isNotBlank()) {
                event.comments.add(commentText)
                commentAdapter.notifyDataSetChanged()
                commentInput.text.clear()
            }
        }
    }
}
