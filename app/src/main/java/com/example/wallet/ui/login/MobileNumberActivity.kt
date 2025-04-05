package com.example.wallet.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R

class MobileNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_number)

        setupBackButton()
        setupQuestionMarkButton()
        setupCountrySelector()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            Toast.makeText(this, "Back button clicked", Toast.LENGTH_SHORT).show()
            finish() // Go back to previous screen
        }
    }

    private fun setupQuestionMarkButton() {
        findViewById<ImageView>(R.id.ivQuestionMark).setOnClickListener {
            startActivity(Intent(this, NeedHelpActivity::class.java))
        }
    }

    private fun setupCountrySelector() {
        findViewById<LinearLayout>(R.id.llCountrySelector).setOnClickListener {
            startActivity(Intent(this, VerifyOtpActivity::class.java))
        }
    }
}
