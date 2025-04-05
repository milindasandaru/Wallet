package com.example.wallet

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.databinding.ActivityMainBinding
import com.example.wallet.ui.lockscreen.LockScreenActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.startBtn.setOnClickListener {
            startActivity(Intent(this, LockScreenActivity::class.java))
        }
    }
}



/*package com.example.wallet

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}*/
/*class YourActivity : AppCompatActivity(), NumericKeypad.KeypadListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keypad = findViewById<NumericKeypad>(R.id.numericKeypad)
        keypad.setKeypadListener(this)
    }

   override fun onNumberClicked(number: Int) {
        // Handle number input
        // For example, append to a TextView
        findViewById<TextView>(R.id.inputDisplay).append(number.toString())
    }

    override fun onDeleteClicked() {
        // Handle delete action
        val display = findViewById<TextView>(R.id.inputDisplay)
        val text = display.text
        if (text.isNotEmpty()) {
            display.text = text.substring(0, text.length - 1)
        }
    }

    override fun onOkClicked() {
        // Handle OK action
        // For example, process the input and proceed
        val input = findViewById<TextView>(R.id.inputDisplay).text.toString()
        processInput(input)
    }

    private fun processInput(input: String) {
        // Process the input
    }
}*/