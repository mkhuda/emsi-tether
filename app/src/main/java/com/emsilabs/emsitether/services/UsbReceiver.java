package com.emsilabs.emsitether.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.emsilabs.emsitether.MainActivity;
import com.emsilabs.emsitether.R;

/**
 * Created by emsi on 23/02/16.
 */
public class UsbReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        if (intent.getExtras().getBoolean("connected")) {
            //do your stuff
            showNotification(context);

        } else {
            cancelNotification(context, 1);
        }

    }

    private void showNotification(Context context) {
        Intent ngintent = new Intent();
        ngintent.setAction(Intent.ACTION_MAIN);
        ComponentName com = new ComponentName("com.android.settings", "com.android.settings.TetherSettings");
        ngintent.setComponent(com);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                ngintent, 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Emsi Tether")
                        .setContentText("Activate USB Tethering Now.");
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }

    public static void cancelNotification(Context ctx, int notifyId) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) ctx.getSystemService(ns);
        nMgr.cancel(notifyId);
    }

}
