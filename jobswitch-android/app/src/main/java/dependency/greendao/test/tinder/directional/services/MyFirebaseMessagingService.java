package dependency.greendao.test.tinder.directional.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

import dependency.greendao.test.tinder.directional.tinder_card.MainActivity;
import dependency.greendao.test.tinder.directional.R;

/**
 * Created by RubenEdery on 22/02/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    Bitmap bitmap;
    public static  int NOTIFICATION_ID = 1;
    private Context mContext;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body1: " + remoteMessage.getNotification().getBody());
        }


        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body2: " + remoteMessage.getNotification().getBody());


        if (remoteMessage.getNotification() != null) {
            Log.d("getData :", "Data Payload: " + remoteMessage.getData().toString());
            Log.d("getMessageId :", "Data getMessageId: " + remoteMessage.getMessageId().toString());
            Log.d("TIME :", "TIME: " + remoteMessage.getSentTime());

            try {
                JSONObject jsonObject = new JSONObject(remoteMessage.getData().toString());
                //JSONObject dataObject = jsonObject.getJSONObject("data");
                //String imageURL = dataObject.getString("image");
                String title = remoteMessage.getNotification().getTitle();
                String message = remoteMessage.getNotification().getBody();
                generateNotification(title,message);

            } catch (Exception e) {
                Log.e("exc", "Exception: " + e.getMessage());
            }
        }
    }

        private void generateNotification(String title,String message) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                    PendingIntent.FLAG_ONE_SHOT);

            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            if (NOTIFICATION_ID > 1073741824) {
                NOTIFICATION_ID = 0;
            }
            notificationManager.notify(NOTIFICATION_ID++ , mNotifyBuilder.build());
        }


        public void putnotif() {







        }

    }




