package seamonster.kraken.androidep1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import seamonster.kraken.androidep1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNavigate1.setOnClickListener {
            startActivity(Intent(this, Activity1::class.java))
        }
        binding.buttonNavigate2.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }
    }
}