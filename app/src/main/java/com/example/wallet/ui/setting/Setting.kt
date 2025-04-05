package com.example.wallet.ui.setting

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.cardview.widget.CardView
import com.example.wallet.R
import com.example.wallet.ui.card.CardActivity
import com.example.wallet.ui.home.Home
import com.example.wallet.ui.profile.Profile
import com.example.wallet.ui.transfer.TransactionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        setupBackButton()
        setupHelpButton()
        setupCardSettings()
        setupNotificationSettings()
        setupBottomNavigation()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupHelpButton() {
        findViewById<ImageView>(R.id.ivHelp).setOnClickListener {
            Toast.makeText(this, "Help & Support", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupCardSettings() {
        // Allow transaction switch
        findViewById<SwitchCompat>(R.id.switchAllowTransaction).setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Transactions allowed" else "Transactions blocked"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        // Change PIN
        findViewById<CardView>(R.id.cardChangePin).setOnClickListener {
            Toast.makeText(this, "Change PIN", Toast.LENGTH_SHORT).show()
        }

        // Replace card
        findViewById<CardView>(R.id.cardReplaceCard).setOnClickListener {
            Toast.makeText(this, "Replace card", Toast.LENGTH_SHORT).show()
        }

        // Edit profile
        findViewById<CardView>(R.id.cardEditProfile).setOnClickListener {
            Toast.makeText(this, "Edit profile", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupNotificationSettings() {
        // Notification switch
        findViewById<SwitchCompat>(R.id.switchNotification).setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Notifications enabled" else "Notifications disabled"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.navigation_settings

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
                    try {
                        startActivity(Intent(this, Profile::class.java))
                    } catch (e: Exception) {
                        Toast.makeText(this, "Profile activity not found", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                R.id.navigation_settings -> {
                    // Already on settings, do nothing
                    true
                }
                else -> false
            }
        }
    }
}
