package br.com.mobile.goteam

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationUtil {

    fun createChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val manager = GoTeamApplication.getInstance().getSystemService(
                Context.NOTIFICATION_SERVICE
            ) as NotificationManager

            val c = NotificationChannel("1", "GoTeam Countries",
            NotificationManager.IMPORTANCE_HIGH )
            manager.createNotificationChannel(c)
        }
    }

    fun create(id: Int, intent: Intent, titulo: String?, texto: String?) {
        createChannel()

        val contexto = GoTeamApplication.getInstance().applicationContext
        val p = PendingIntent.getActivity(
            contexto,0, intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(contexto, "1")
            .setContentIntent(p)
            .setContentTitle(titulo)
            .setContentText(texto)
            .setSmallIcon(R.drawable.globo48)
            .setAutoCancel(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)


        with(NotificationManagerCompat.from(GoTeamApplication.getInstance())) {
            val n = builder.build()
            notify(id, n)
        }
    }
}