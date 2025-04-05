package com.example.wallet.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R

class PersonalInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        setupBackButton()
        setupQuestionButton()
        setupNextArrowButton()
        setupContinueButton()
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

    private fun setupNextArrowButton() {
        findViewById<ImageView>(R.id.ivNextArrow).setOnClickListener {
            Toast.makeText(this, "Next arrow clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupContinueButton() {
        findViewById<Button>(R.id.btnContinue).setOnClickListener {
            startActivity(Intent(this, VerificationSuccessActivity::class.java))
        }
    }
}
