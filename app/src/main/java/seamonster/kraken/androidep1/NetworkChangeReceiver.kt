package seamonster.kraken.androidep1

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (isNetworkConnected(context)) {
            showToast(context, "Network connected!")
        } else {
            showToast(context, "Network disconnected!")
        }
    }

    @Suppress("DEPRECATION")
    private fun isNetworkConnected(context: Context): Boolean {
        val cm =
            context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= 29) {
            val netCapabilities = cm.getNetworkCapabilities(cm.activeNetwork)
            val internetNetCap = NetworkCapabilities.NET_CAPABILITY_INTERNET
            (netCapabilities != null) && netCapabilities.hasCapability(internetNetCap)
        } else {
            val networkInfo = cm.activeNetworkInfo
            (networkInfo != null) && networkInfo.isConnected
        }
    }

    private fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}