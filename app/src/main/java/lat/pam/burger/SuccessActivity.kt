package lat.pam.burger

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SuccessActivity : AppCompatActivity() {

    private lateinit var tvSuccessMessage: TextView
    private lateinit var tvOrderDetails: TextView
    private lateinit var tvGreeting: TextView
    private lateinit var btnOke: MaterialButton

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        // Hilangkan ActionBar
        supportActionBar?.hide()

        // Inisialisasi view
        tvSuccessMessage = findViewById(R.id.tvSuccessMessage)
        tvOrderDetails = findViewById(R.id.tvOrderDetails)
        tvGreeting = findViewById(R.id.tvGreeting)
        btnOke = findViewById(R.id.btnOke)

        // Ambil data dari Intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "-"
        val servings = intent.getStringExtra("SERVINGS") ?: "-"
        val orderingName = intent.getStringExtra("ORDERING_NAME") ?: "-"
        val address = intent.getStringExtra("ADDRESS") ?: "-"

        // Logging untuk debug
        Log.d("SuccessActivity", "Food Name: $foodName")
        Log.d("SuccessActivity", "Servings: $servings")
        Log.d("SuccessActivity", "Ordering Name: $orderingName")
        Log.d("SuccessActivity", "Address: $address")

        // Tampilkan pesan ke user
        tvSuccessMessage.text = "Pesananmu Berhasil Diterima! 🎉"
        tvGreeting.text = "Halo, $orderingName!"

        // Format detail pesanan
        val orderDetails = """
            Makanan: $foodName
            Jumlah: $servings porsi
            Nama Pemesan: $orderingName
            Alamat Pengiriman: $address
        """.trimIndent()
        tvOrderDetails.text = orderDetails

        Log.d("SuccessActivity", "Order Details: $orderDetails")

        // Tombol kembali ke Home
        btnOke.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // Efek animasi muncul
        animateContent()
    }

    private fun animateContent() {
        val views = listOf(tvGreeting, tvSuccessMessage, tvOrderDetails, btnOke)
        views.forEachIndexed { index, view ->
            view.alpha = 0f
            view.animate()
                .alpha(1f)
                .setStartDelay((index * 150).toLong())
                .setDuration(400)
                .start()
        }
    }
}
