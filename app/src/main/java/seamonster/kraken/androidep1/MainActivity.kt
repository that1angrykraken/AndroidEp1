package seamonster.kraken.androidep1

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import seamonster.kraken.androidep1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receiver = NetworkChangeReceiver()
        val filter = IntentFilter(@Suppress("DEPRECATION") ConnectivityManager.CONNECTIVITY_ACTION)
        // adding net filter to receiver is deprecated
        registerReceiver(receiver, filter)
    }
}