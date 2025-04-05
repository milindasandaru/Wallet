package com.example.wallet.ui.card

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R
import com.example.wallet.ui.home.Home
import com.example.wallet.ui.profile.Profile
import com.example.wallet.ui.setting.Setting
import com.example.wallet.ui.transfer.TransactionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        setupBackButton()
        setupCardDetailsButtons()
        setupBottomNavigation()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupCardDetailsButtons() {
        // Green card details button
        findViewById<Button>(R.id.btnGreenDetails).setOnClickListener {
            Toast.makeText(this, "Green Card Details", Toast.LENGTH_SHORT).show()
        }

        // Silver card details button
        findViewById<Button>(R.id.btnSilverDetails).setOnClickListener {
            Toast.makeText(this, "Silver Card Details", Toast.LENGTH_SHORT).show()
        }

        // Black card details button
        findViewById<Button>(R.id.btnBlackDetails).setOnClickListener {
            Toast.makeText(this, "Black Card Details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.navigation_card

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
                    // Already on card, do nothing
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
