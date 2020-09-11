package com.example.stayfit;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

public class AlaramReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID ="SAMPLE_CHANNEL";
    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationid=intent.getIntExtra("notificationid",0);
        String message=intent.getStringExtra("message");

        Intent mi=new Intent(context,RemainderActivity.class);
        PendingIntent ci = PendingIntent.getActivity(context,0,mi,0
        );

        NotificationManager nm= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                CharSequence channel_name="My Notification";
                int importance=NotificationManager.IMPORTANCE_DEFAULT;

                NotificationChannel channel=new NotificationChannel(CHANNEL_ID,channel_name,importance);
                nm.createNotificationChannel(channel);
            }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID).setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle("REMAINDER")
                .setContentText(message)
                .setContentIntent(ci).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
        nm.notify(notificationid,builder.build());
        }
    }

