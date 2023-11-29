package seamonster.kraken.androidintentexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import seamonster.kraken.androidintentexample.databinding.ActivitySecondBinding

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

        Log.d(TAG, "onCreate: ok")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ok")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ok")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ok")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ok")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ok")
    }

    companion object{
        private const val TAG = "SecondActivity"
    }
}