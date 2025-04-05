package com.example.wallet.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R

class VerifyOtpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_otp)

        setupBackButton()
        setupQuestionButton()
        setupOkButton()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            Toast.makeText(this, "Back button clicked", Toast.LENGTH_SHORT).show()
            finish() // Go back to previous screen
        }
    }

    private fun setupQuestionButton() {
        findViewById<ImageView>(R.id.ivQuestion).setOnClickListener {
            Toast.makeText(this, "Question button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupOkButton() {
        findViewById<TextView>(R.id.tvKeyOk).setOnClickListener {
            startActivity(Intent(this, PersonalInfoActivity::class.java))
        }
    }
}
