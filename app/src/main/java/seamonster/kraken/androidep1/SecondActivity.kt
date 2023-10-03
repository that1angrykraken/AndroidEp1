package seamonster.kraken.androidep1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import seamonster.kraken.androidep1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent?.getStringExtra("data")
        if (!data.isNullOrBlank()) {
            binding.textView.text = data
        }
    }

}