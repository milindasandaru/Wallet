package com.example.wallet.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R

class NeedHelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_need_help)

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
        findViewById<LinearLayout>(R.id.chatWithAgentContainer).setOnClickListener {
            startActivity(Intent(this, NeedHelpActivitySecond::class.java))
            // Navigation to chat screen will be added later
        }
    }
}
