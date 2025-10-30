package lat.pam.burger

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class FoodDetailActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageButton
    private lateinit var ivFoodDetail: ImageView
    private lateinit var tvFoodDetailName: TextView
    private lateinit var tvFoodDetailDescription: TextView
    private lateinit var tvFoodDetailPrice: TextView
    private lateinit var btnOrder: MaterialButton
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        // Hide action bar
        supportActionBar?.hide()

        // Initialize views
        btnBack = findViewById(R.id.btnBack)
        ivFoodDetail = findViewById(R.id.ivFoodDetail)
        tvFoodDetailName = findViewById(R.id.tvFoodDetailName)
        tvFoodDetailDescription = findViewById(R.id.tvFoodDetailDescription)
        tvFoodDetailPrice = findViewById(R.id.tvFoodDetailPrice)
        btnOrder = findViewById(R.id.btnOrder)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Get data from Intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "Unknown Food"
        val foodDescription = intent.getStringExtra("FOOD_DESCRIPTION") ?: "No description"
        val foodPrice = intent.getStringExtra("FOOD_PRICE") ?: "Rp 0"
        val foodImage = intent.getIntExtra("FOOD_IMAGE", R.drawable.ic_food)

        // Set data to views
        tvFoodDetailName.text = foodName
        tvFoodDetailDescription.text = foodDescription
        tvFoodDetailPrice.text = foodPrice
        ivFoodDetail.setImageResource(foodImage)

        // Back button
        btnBack.setOnClickListener { finish() }

        // Order button
        btnOrder.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java).apply {
                putExtra("FOOD_NAME", foodName)
                putExtra("FOOD_PRICE", foodPrice)
                putExtra("FOOD_IMAGE", foodImage)
            }
            startActivity(intent)
        }

        // Bottom Navigation setup
        bottomNavigation.selectedItemId = R.id.nav_order

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, HomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    }
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_order -> true
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
