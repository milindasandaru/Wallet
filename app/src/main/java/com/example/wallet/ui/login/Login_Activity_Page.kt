package com.example.wallet.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R

class Login_Activity_Page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupBackButton()
        setupSignInButton()
        setupSignUpButton()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish() // Go back to previous screen
        }
    }

    private fun setupSignInButton() {
        findViewById<Button>(R.id.btnSignIn).setOnClickListener {
            startActivity(Intent(this, MobileNumberActivity::class.java))
            // We'll implement actual sign-in functionality later
        }
    }

    private fun setupSignUpButton() {
        findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            startActivity(Intent(this, MobileNumberActivity::class.java))
            // We'll implement actual sign-up functionality later
        }
    }
}
