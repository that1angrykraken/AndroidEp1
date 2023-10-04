package seamonster.kraken.androidep1

import android.Manifest
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.IBinder
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class ForegroundMusicService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
    private var isRunning = false

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.specialz)
        mediaPlayer.isLooping = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!isRunning) {
            startForeground(1, serviceNotification())
            mediaPlayer.start()
            isRunning = true
        } else {
            stopSelf()
            isRunning = false
        }
        return START_NOT_STICKY
    }

    private fun serviceNotification(): Notification {
        val channel = NotificationChannelCompat.Builder(
            "FOREGROUND_NOTIFICATIONS",
            NotificationManager.IMPORTANCE_LOW
        ).setName("Foreground service").build()
        NotificationManagerCompat.from(this).createNotificationChannel(channel)

        val stopIntent = Intent(this, ForegroundMusicService::class.java)
        stopIntent.action = "STOP"
        val pendingIntent =
            PendingIntent.getService(this, 0, stopIntent, PendingIntent.FLAG_IMMUTABLE)

        return NotificationCompat.Builder(this, "FOREGROUND_NOTIFICATIONS")
            .setContentTitle("ForegroundService")
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .addAction(R.drawable.ic_launcher_foreground, "Stop", pendingIntent)
            .build()
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
        stopSelf()
        super.onDestroy()
    }
}