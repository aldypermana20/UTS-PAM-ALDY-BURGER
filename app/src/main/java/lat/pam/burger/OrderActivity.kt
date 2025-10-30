package lat.pam.burger

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class OrderActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageButton
    private lateinit var ivOrderFood: ImageView
    private lateinit var tvOrderFoodName: TextView
    private lateinit var tvOrderFoodPrice: TextView
    private lateinit var etServings: TextInputEditText
    private lateinit var etOrderingName: TextInputEditText
    private lateinit var etNotesAddress: TextInputEditText
    private lateinit var btnPlaceOrder: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        supportActionBar?.hide()

        // 🔹 Inisialisasi view sesuai layout
        btnBack = findViewById(R.id.btnBack)
        ivOrderFood = findViewById(R.id.ivOrderFood)
        tvOrderFoodName = findViewById(R.id.tvOrderFoodName)
        tvOrderFoodPrice = findViewById(R.id.tvOrderFoodPrice)
        etServings = findViewById(R.id.etServings)
        etOrderingName = findViewById(R.id.etOrderingName)
        etNotesAddress = findViewById(R.id.etNotesAddress)
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder)

        // 🔹 Ambil data dari activity sebelumnya
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "Burger Tanpa Nama 🍔"
        val foodPrice = intent.getStringExtra("FOOD_PRICE") ?: "0"
        val foodImage = intent.getIntExtra("FOOD_IMAGE", R.drawable.burger1)

        // 🔹 Tampilkan data ke UI
        ivOrderFood.setImageResource(foodImage)
        tvOrderFoodName.text = foodName
        tvOrderFoodPrice.text = "Total: Rp $foodPrice"

        // 🔹 Tombol kembali
        btnBack.setOnClickListener { finish() }

        // 🔹 Tombol “Pesan Sekarang”
        btnPlaceOrder.setOnClickListener {
            val servings = etServings.text.toString().trim()
            val orderingName = etOrderingName.text.toString().trim()
            val address = etNotesAddress.text.toString().trim()

            // 🔹 Validasi input
            when {
                servings.isEmpty() -> {
                    Toast.makeText(this, "Masukkan jumlah porsi!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                orderingName.isEmpty() -> {
                    Toast.makeText(this, "Masukkan nama pemesan!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                address.isEmpty() -> {
                    Toast.makeText(this, "Masukkan alamat pengiriman!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            // 🔹 Kirim data ke SuccessActivity
            val intent = Intent(this, SuccessActivity::class.java).apply {
                putExtra("FOOD_NAME", foodName)
                putExtra("SERVINGS", servings)
                putExtra("ORDERING_NAME", orderingName)
                putExtra("ADDRESS", address)
            }

            val order = Order(
                foodName = foodName ?: "Unknown",
                foodPrice = foodPrice ?: "Rp 0",
                servings = servings,
                orderingName = orderingName,
                address = address,
                foodImage = foodImage
            )
            OrderManager.addOrder(order)

            // 🔹 Pesan feedback
            Toast.makeText(this, "Pesanan dikirim ke dapur 🍔🔥", Toast.LENGTH_SHORT).show()

            // 🔹 Pindah ke SuccessActivity
            startActivity(intent)
            finish()
        }
    }
}
