package lat.pam.burger

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var etNamaLengkap: TextInputEditText
    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnRegister: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Hide action bar
        supportActionBar?.hide()

        // Initialize views
        etNamaLengkap = findViewById(R.id.etNamaLengkap)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        // Register button click
        btnRegister.setOnClickListener {
            val namaLengkap = etNamaLengkap.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (namaLengkap.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Temporary success message (nanti bisa simpan ke database)
                Toast.makeText(this, "Registration Success! Please login.", Toast.LENGTH_SHORT).show()

                // Navigate to Login
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}