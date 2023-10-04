package seamonster.kraken.androidep1

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class CalculatorService : Service() {
    private val binder = CalculatorBinder()

    inner class CalculatorBinder : Binder() {
        fun getService(): CalculatorService {
            return this@CalculatorService
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun calculate(num1: Double, num2: Double, op: String): Double? {
        return when (op) {
            "+" -> (num1 + num2)
            "-" -> (num1 - num2)
            "*", "x", "X" -> (num1 * num2)
            ":", "/" -> (num1 / num2)
            else -> null
        }
    }
}