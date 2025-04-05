package com.example.wallet.ui.lockscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R
import com.example.wallet.ui.login.Login_Activity_Page
import com.example.wallet.ui.home.Home

class LockScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_screen)

        findViewById<Button>(R.id.btnOk)?.setOnClickListener {
            navigateToHome()
        }

        findViewById<TextView>(R.id.tvNoAccount)?.setOnClickListener {
            navigateToLoginActivity()
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
        finish() // Close the lock screen activity
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, Login_Activity_Page::class.java)
        startActivity(intent)
        finish()
    }
}


/*package com.example.wallet.ui.lockscreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R
import com.example.wallet.ui.home.Home

class LockScreenActivity : AppCompatActivity() {

    private val pinDots = mutableListOf<View>()
    private val currentPin = StringBuilder()
    private val correctPin = "1234" // Simple PIN as requested

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            Log.d("LockScreenActivity", "Starting onCreate")
            super.onCreate(savedInstanceState)
            Log.d("LockScreenActivity", "About to set content view")
            setContentView(R.layout.lockscreen)
            Log.d("LockScreenActivity", "Content view set successfully")

            // Initialize PIN dots
            Log.d("LockScreenActivity", "Initializing PIN dots")
            pinDots.apply {
                add(findViewById(R.id.pinDot1))
                add(findViewById(R.id.pinDot2))
                add(findViewById(R.id.pinDot3))
                add(findViewById(R.id.pinDot4))
            }
            Log.d("LockScreenActivity", "PIN dots initialized")

            // Set up number buttons
            Log.d("LockScreenActivity", "Setting up number buttons")
            setupNumberButtons()
            Log.d("LockScreenActivity", "Number buttons setup complete")

            // Set up OK button
            Log.d("LockScreenActivity", "Setting up OK button")
            findViewById<Button>(R.id.btnOk)?.apply {
                setOnClickListener { verifyPinAndNavigate() }
                Log.d("LockScreenActivity", "OK button setup complete")
            } ?: Log.e("LockScreenActivity", "btnOk not found in layout")

            // Set up Delete button
            Log.d("LockScreenActivity", "Setting up Delete button")
            findViewById<Button>(R.id.btnDelete)?.apply {
                setOnClickListener {
                    if (currentPin.isNotEmpty()) {
                        currentPin.deleteCharAt(currentPin.length - 1)
                        updatePinDots()
                    }
                }
                Log.d("LockScreenActivity", "Delete button setup complete")
            } ?: Log.e("LockScreenActivity", "btnDelete not found in layout")

            // Set up Forget PIN text
            Log.d("LockScreenActivity", "Setting up Forget PIN text")
            findViewById<TextView>(R.id.tvForgetPin)?.apply {
                setOnClickListener {
                    Toast.makeText(this@LockScreenActivity, "Forgot PIN functionality", Toast.LENGTH_SHORT).show()
                }
                Log.d("LockScreenActivity", "Forget PIN text setup complete")
            } ?: Log.e("LockScreenActivity", "tvForgetPin not found in layout")

            // Set up Don't have an account text
            Log.d("LockScreenActivity", "Setting up No Account text")
            findViewById<TextView>(R.id.tvNoAccount)?.apply {
                setOnClickListener {
                    Toast.makeText(this@LockScreenActivity, "Create account functionality", Toast.LENGTH_SHORT).show()
                }
                Log.d("LockScreenActivity", "No Account text setup complete")
            } ?: Log.e("LockScreenActivity", "tvNoAccount not found in layout")

            // Initialize PIN dots display
            Log.d("LockScreenActivity", "Initializing PIN dots display")
            updatePinDots()
            Log.d("LockScreenActivity", "onCreate completed successfully")
        } catch (e: Exception) {
            Log.e("LockScreenActivity", "Error in onCreate: ${e.message}", e)
            Toast.makeText(this, "Error initializing lock screen: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }


    private fun setupNumberButtons() {
        val buttonIds = arrayOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        buttonIds.forEachIndexed { index, buttonId ->
            findViewById<Button>(buttonId)?.setOnClickListener {
                // For btn0, index is 0 but we want the digit 0
                val digit = if (index == 0) 0 else index

                if (currentPin.length < 4) {
                    currentPin.append(digit)
                    updatePinDots()

                    // Auto-verify if 4 digits entered
                    if (currentPin.length == 4) {
                        verifyPinAndNavigate()
                    }
                }
            }
        }
    }


    private fun updatePinDots() {
        pinDots.forEachIndexed { index, view ->
            val backgroundResource = if (index < currentPin.length) {
                R.drawable.pin_dot_active
            } else {
                R.drawable.pin_dot_inactive
            }
            view.setBackgroundResource(backgroundResource)
        }
    }

    private fun verifyPinAndNavigate() {
        if (currentPin.toString() == correctPin) {
            try {
                // PIN is correct, navigate to main activity
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish() // Close the lock screen
            } catch (e: Exception) {
                // Log the error
                e.printStackTrace()
                Toast.makeText(this, "Navigation error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        } else if (currentPin.length == 4) {
            // Wrong PIN
            Toast.makeText(this, "Incorrect PIN", Toast.LENGTH_SHORT).show()
            currentPin.clear()
            updatePinDots()
        }
    }

}
*/