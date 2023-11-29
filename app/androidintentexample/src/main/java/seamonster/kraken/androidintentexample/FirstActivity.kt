package seamonster.kraken.androidintentexample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import seamonster.kraken.androidintentexample.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeComponents()

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
        Log.d(TAG, "onDestroy: ok")
        super.onDestroy()
    }

    private fun initializeComponents() {

        binding.buttonSend.setOnClickListener {
            val data = binding.textData.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent.apply { putExtra("data", data) })
        }
    }

    companion object {
        private const val TAG = "FirstActivity"
    }
}