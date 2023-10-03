package seamonster.kraken.androidep1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import seamonster.kraken.androidep1.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSend.setOnClickListener {
            val data = binding.textData.text.toString()
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            startActivity(secondActivityIntent.apply { putExtra("data", data) })
        }
    }
}