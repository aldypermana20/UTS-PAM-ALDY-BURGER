package lat.pam.burger

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity

class ConfirmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        supportActionBar?.hide()

        val foodImage: ImageView = findViewById(R.id.confirmFoodImage)
        val foodName: TextView = findViewById(R.id.confirmFoodName)
        val foodPrice: TextView = findViewById(R.id.confirmTotal)
        val foodAddress = findViewById<TextView?>(R.id.confirmAddress)
        val foodNote = findViewById<TextView?>(R.id.confirmNote)
        val btnOrderNow: MaterialButton = findViewById(R.id.btnOrderNow)

        val burgerName = intent.getStringExtra("BURGER_NAME")
        val burgerPrice = intent.getStringExtra("BURGER_PRICE")
        val burgerImage = intent.getIntExtra("BURGER_IMAGE", R.drawable.burger1)
        val namaLengkap = intent.getStringExtra("NAMA_LENGKAP")
        val alamat = intent.getStringExtra("ALAMAT")
        val catatan = intent.getStringExtra("CATATAN")

        foodName.text = burgerName ?: "Burger Tanpa Nama 🍔"
        foodPrice.text = if (!burgerPrice.isNullOrEmpty()) "Total: Rp $burgerPrice" else "Harga tidak tersedia"
        foodImage.setImageResource(burgerImage)
        foodAddress?.text = "Alamat: ${alamat ?: "-"}"
        foodNote?.text = "Catatan: ${catatan ?: "-"}"

        btnOrderNow.setOnClickListener {
            if (burgerName.isNullOrEmpty() || namaLengkap.isNullOrEmpty() || alamat.isNullOrEmpty()) {
                Toast.makeText(this, "Data pesanan belum lengkap!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SuccessActivity::class.java).apply {
                putExtra("FOOD_NAME", burgerName)
                putExtra("SERVINGS", "1")
                putExtra("ORDERING_NAME", namaLengkap)
                putExtra("ADDRESS", alamat)
            }

            Toast.makeText(this, "Pesanan dikirim ke dapur 🍔🔥", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}
