package seamonster.kraken.androidep1

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        binding.buttonStartService.setOnClickListener {
            startService(Intent(this, MusicService::class.java))
        }
        binding.buttonStartForegroundService.setOnClickListener {
            startForegroundService(Intent(this, ForegroundMusicService::class.java))
            Log.d(TAG, "buttonStartForegroundService: ok")
        }
        binding.buttonNavigateToBoundServiceExample.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
    }
}