package com.example.wallet.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R
import com.example.wallet.ui.card.CardActivity
import com.example.wallet.ui.home.Home
import com.example.wallet.ui.setting.Setting
import com.example.wallet.ui.transfer.TransactionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupBackButton()
        setupEditButtons()
        setupAvatarEdit()
        setupBottomNavigation()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupEditButtons() {
        // Personal information edit button
        findViewById<TextView>(R.id.tvEditPersonal).setOnClickListener {
            Toast.makeText(this, "Edit personal information", Toast.LENGTH_SHORT).show()
        }
        // Bank information edit button
        findViewById<TextView>(R.id.tvEditBank).setOnClickListener {
            Toast.makeText(this, "Edit bank information", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupAvatarEdit() {
        findViewById<ImageView>(R.id.ivEditAvatar).setOnClickListener {
            Toast.makeText(this, "Edit profile picture", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.navigation_profile

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    try {
                        startActivity(Intent(this, Home::class.java))
                    } catch (e: Exception) {
                        Toast.makeText(this, "Home activity not found", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                R.id.navigation_card -> {
                    try {
                        startActivity(Intent(this, CardActivity::class.java))
                    } catch (e: Exception) {
                        Toast.makeText(this, "Card activity not found", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                R.id.navigation_transfer -> {
                    try {
                        startActivity(Intent(this, TransactionActivity::class.java))
                    } catch (e: Exception) {
                        Toast.makeText(this, "Transaction activity not found", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                R.id.navigation_profile -> {
                    // Already on profile, do nothing
                    true
                }
                R.id.navigation_settings -> {
                    try {
                        startActivity(Intent(this, Setting::class.java))
                    } catch (e: Exception) {
                        Toast.makeText(this, "Settings activity not found", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                else -> false
            }
        }
    }
}
