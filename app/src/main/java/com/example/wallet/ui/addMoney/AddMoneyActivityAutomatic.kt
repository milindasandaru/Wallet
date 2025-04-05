package com.example.wallet.ui.addMoney

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R
import com.example.wallet.ui.card.CardActivity
import com.example.wallet.ui.home.Home
import com.example.wallet.ui.profile.Profile
import com.example.wallet.ui.setting.Setting
import com.example.wallet.ui.transfer.TransactionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AddMoneyActivityAutomatic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_money_automatic)

        setupBackButton()
        setupToggleButtons()
        setupBottomNavigation()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish() // Go back to previous screen
        }
    }

    private fun setupToggleButtons() {
        val btnOneTime = findViewById<Button>(R.id.btnOneTime)
        val btnAutomatic = findViewById<Button>(R.id.btnAutomatic)

        // Set default selection - Automatic is selected by default
        btnAutomatic.setBackgroundResource(R.drawable.toggle_button_right_bg_selected)
        btnAutomatic.setTextColor(resources.getColor(R.color.white))
        btnOneTime.setBackgroundResource(R.drawable.toggle_button_left_bg)
        btnOneTime.setTextColor(resources.getColor(R.color.black))

        btnOneTime.setOnClickListener {
            // Navigate to One Time page
            val intent = Intent(this, AddMoneyActivity::class.java)
            startActivity(intent)
            finish() // Close current activity to prevent stacking
        }

        btnAutomatic.setOnClickListener {
            // We're already on the Automatic page, just update UI
            btnAutomatic.setBackgroundResource(R.drawable.toggle_button_right_bg_selected)
            btnAutomatic.setTextColor(resources.getColor(R.color.white))
            btnOneTime.setBackgroundResource(R.drawable.toggle_button_left_bg)
            btnOneTime.setTextColor(resources.getColor(R.color.black))
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this, Home::class.java))
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
