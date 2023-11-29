package seamonster.kraken.serviceexample

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import seamonster.kraken.serviceexample.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var mService: CalculatorService
    private var mBound = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName?, service: IBinder?) {
            val binder = service as CalculatorService.CalculatorBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(className: ComponentName?) {
            mBound = false
        }
    }

    override fun onResume() {
        super.onResume()
        Intent(this, CalculatorService::class.java).also {
            bindService(it, serviceConnection, BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(serviceConnection)
        mBound = false
    }

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            if (mBound) {
                val num1 = binding.textFirstNumber.text.toString().toDouble()
                val num2 = binding.textSecondNumber.text.toString().toDouble()
                val op = binding.textOperation.text.toString()
                val result = mService.calculate(num1, num2, op)
                binding.textAnswer.text = "${result ?: "Syntax error"}"
            }
        }
    }
}