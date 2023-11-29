package seamonster.kraken.serviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import seamonster.kraken.serviceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStartService.setOnClickListener {
            val intent = Intent(
                this,
                MusicService::class.java
            )
            startService(intent)
        }

        binding.buttonStartForegroundService.setOnClickListener {
            val intent = Intent(this, ForegroundMusicService::class.java)
            startForegroundService(intent)
            Log.d(TAG, "buttonStartForegroundService: ok")
        }

        binding.buttonNavigateToBoundServiceExample.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
    }
}