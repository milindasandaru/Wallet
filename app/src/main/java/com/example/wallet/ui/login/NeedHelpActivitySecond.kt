package com.example.wallet.ui.login

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R

class NeedHelpActivitySecond : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_need_help_second)

        setupBackButton()
        setupChatWithAgent()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            Toast.makeText(this, "Back button clicked", Toast.LENGTH_SHORT).show()
            finish() // Go back to previous screen
        }
    }

    private fun setupChatWithAgent() {
        // The entire chat container is already visible in the layout
        // Just add click listener for the send button
        findViewById<ImageView>(R.id.ivSend).setOnClickListener {
            Toast.makeText(this, "Message send button clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
