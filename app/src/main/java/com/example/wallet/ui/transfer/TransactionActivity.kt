package com.example.wallet.ui.transfer

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R
import com.example.wallet.ui.card.CardActivity
import com.example.wallet.ui.home.Home
import com.example.wallet.ui.profile.Profile
import com.example.wallet.ui.setting.Setting
import com.google.android.material.bottomnavigation.BottomNavigationView

class TransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_screen)

        setupBackButton()
        setupSearchButton()
        setupFilterOptions()
        setupBottomNavigation()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupSearchButton() {
        findViewById<ImageView>(R.id.btnSearch).setOnClickListener {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupFilterOptions() {
        // Period filter
        findViewById<androidx.cardview.widget.CardView>(R.id.cardPeriod).setOnClickListener {
            Toast.makeText(this, "Period filter clicked", Toast.LENGTH_SHORT).show()
        }

        // Card filter
        findViewById<androidx.cardview.widget.CardView>(R.id.cardDebit).setOnClickListener {
            Toast.makeText(this, "Card filter clicked", Toast.LENGTH_SHORT).show()
        }

        // Sum filter
        findViewById<androidx.cardview.widget.CardView>(R.id.cardSum).setOnClickListener {
            Toast.makeText(this, "Sum filter clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.navigation_transfer

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
                    // Already on transfer, do nothing
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
