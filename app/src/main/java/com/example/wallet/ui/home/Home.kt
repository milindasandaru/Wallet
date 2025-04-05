package com.example.wallet.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet.R
import com.example.wallet.ui.addMoney.AddMoneyActivity
import com.example.wallet.ui.card.CardActivity
import com.example.wallet.ui.profile.Profile
import com.example.wallet.ui.setting.Setting
import com.example.wallet.ui.transfer.TransactionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Calendar

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupGreeting()
        setupBalanceCard()
        setupCardsSection()
        setupTransactionsSection()
        setupBottomNavigation()
    }

    private fun setupGreeting() {
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val calendar = Calendar.getInstance()
        val greeting = when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            else -> "Good Evening"
        }
        tvGreeting.text = "$greeting, Sams"

        findViewById<ImageView>(R.id.ivNotification).setOnClickListener {
            Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBalanceCard() {
        findViewById<Button>(R.id.btnAddMoney).setOnClickListener {
            startActivity(Intent(this, AddMoneyActivity::class.java))
        }

        findViewById<ImageView>(R.id.ivRefresh).setOnClickListener {
            Toast.makeText(this, "Refreshing balance...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupCardsSection() {
        findViewById<TextView>(R.id.tvNewCard).setOnClickListener {
            Toast.makeText(this, "Add new card", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnDetails).setOnClickListener {
            Toast.makeText(this, "Card details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupTransactionsSection() {
        findViewById<TextView>(R.id.tvSeeAll).setOnClickListener {
            Toast.makeText(this, "See all transactions", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.navigation_home

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Already on home, do nothing
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


/*package com.example.wallet.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.ui.card.CardActivity
import com.example.wallet.ui.addMoney.AddMoney
import com.example.wallet.ui.profile.Profile
import com.example.wallet.ui.setting.Setting
import com.example.wallet.ui.transfer.TransactionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class Home : AppCompatActivity() {

    private lateinit var cardAdapter: CardAdapter
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupGreeting()
        setupBalanceCard()
        setupCardsRecyclerView()
        setupTransactionsRecyclerView()
        setupBottomNavigation()
    }

    private fun setupGreeting() {
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val calendar = Calendar.getInstance()
        val greeting = when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            else -> "Good Evening"
        }
        tvGreeting.text = "$greeting, Sams"

        // Setup notification bell click listener
        findViewById<ImageView>(R.id.ivNotification).setOnClickListener {
            Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBalanceCard() {
        // Add money button click listener
        findViewById<Button>(R.id.btnAddMoney).setOnClickListener {
            val intent = Intent(this, AddMoney::class.java)
            startActivity(intent)
        }


        // Refresh balance click listener
        findViewById<ImageView>(R.id.ivRefresh).setOnClickListener {
            Toast.makeText(this, "Refreshing balance...", Toast.LENGTH_SHORT).show()
            // Implement refresh logic
        }
    }

    private fun setupCardsRecyclerView() {
        val rvCards = findViewById<RecyclerView>(R.id.rvCards)

        // Sample card data
        val cards = listOf(
            Card("$ 2,313.27", "2321 3455 2323 3435", "Sams Clifford"),
            Card("$ 1,500.00", "4567 7890 1234 5678", "Sams Clifford"),
            Card("$ 950.75", "9876 5432 1098 7654", "Sams Clifford")
        )

        cardAdapter = CardAdapter(cards) { card ->
            Toast.makeText(this, "Card details: ${card.number}", Toast.LENGTH_SHORT).show()
            // Navigate to card details
        }

        rvCards.apply {
            layoutManager = LinearLayoutManager(this@Home, LinearLayoutManager.HORIZONTAL, false)
            adapter = cardAdapter
        }

        // New card click listener
        findViewById<TextView>(R.id.tvNewCard).setOnClickListener {
            Toast.makeText(this, "Add new card", Toast.LENGTH_SHORT).show()
            // Navigate to add new card screen
        }
    }

    private fun setupTransactionsRecyclerView() {
        val rvTransactions = findViewById<RecyclerView>(R.id.rvTransactions)

        // Sample transaction data
        val transactions = listOf(
            Transaction("Starbucks Coffee", "March 05, 09:00 AM", "-$ 26.38", R.drawable.starbuck),
            Transaction("Walmart", "March 05, 19:00 PM", "-$ 102.21", R.drawable.wallmart),
            Transaction("Amazon", "March 03, 11:22 AM", "-$ 56.32", R.drawable.amazon)
        )

        transactionAdapter = TransactionAdapter(transactions)

        rvTransactions.apply {
            layoutManager = LinearLayoutManager(this@Home)
            adapter = transactionAdapter
        }

        // See all transactions click listener
        findViewById<TextView>(R.id.tvSeeAll).setOnClickListener {
            Toast.makeText(this, "See all transactions", Toast.LENGTH_SHORT).show()
            // Navigate to all transactions screen
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // If you're already on the home page, do nothing
                    true
                }
                R.id.navigation_card -> {
                    startActivity(Intent(this, CardActivity::class.java))
                    true
                }
                R.id.navigation_transfer -> {
                    startActivity(Intent(this, TransactionActivity::class.java))
                    true
                }
                R.id.navigation_profile -> {
                    startActivity(Intent(this, Profile::class.java))
                    true
                }
                R.id.navigation_settings -> {
                    startActivity(Intent(this, Setting::class.java))
                    true
                }
                else -> false
            }
        }
    }
}

// Data classes
data class Card(val amount: String, val number: String, val holder: String)
data class Transaction(val merchant: String, val date: String, val amount: String, val logoResId: Int)

// Adapters
class CardAdapter(
    private val cards: List<Card>,
    private val onDetailsClick: (Card) -> Unit
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCardAmount: TextView = view.findViewById(R.id.tvCardAmount)
        val tvCardNumber: TextView = view.findViewById(R.id.tvCardNumber)
        val tvCardHolder: TextView = view.findViewById(R.id.tvCardHolder)
        val btnDetails: Button = view.findViewById(R.id.btnDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]
        holder.tvCardAmount.text = card.amount
        holder.tvCardNumber.text = card.number
        holder.tvCardHolder.text = card.holder
        holder.btnDetails.setOnClickListener { onDetailsClick(card) }
    }

    override fun getItemCount() = cards.size
}

class TransactionAdapter(
    private val transactions: List<Transaction>
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivMerchantLogo: ImageView = view.findViewById(R.id.ivMerchantLogo)
        val tvMerchantName: TextView = view.findViewById(R.id.tvMerchantName)
        val tvTransactionDate: TextView = view.findViewById(R.id.tvTransactionDate)
        val tvAmount: TextView = view.findViewById(R.id.tvAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.ivMerchantLogo.setImageResource(transaction.logoResId)
        holder.tvMerchantName.text = transaction.merchant
        holder.tvTransactionDate.text = transaction.date
        holder.tvAmount.text = transaction.amount
    }

    override fun getItemCount() = transactions.size
}*/
