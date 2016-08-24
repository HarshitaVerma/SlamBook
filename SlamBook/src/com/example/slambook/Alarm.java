package com.example.slambook;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class Alarm extends BroadcastReceiver
{

public void onReceive(Context context, Intent intent) {
		
		
		createNotification(context,"Times Up","5 sec has Passed","Alert");
		
	}

	public void createNotification(Context context, String msg,
			String msgText, String msgAlert) 
	{ 
		//Toast.makeText(context, "helooo", Toast.LENGTH_LONG).show();
		
		PendingIntent notificIntent=PendingIntent.getActivity(context,0,new Intent(context,BirthdayAlarm.class),0);
		
		NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.bub)
		.setContentTitle("Alert !!! ")
		.setTicker("Task Reminder")
		.setContentText("You need to perform these...");
		mBuilder.setContentIntent(notificIntent);
		mBuilder.setAutoCancel(true);
		NotificationManager mNotificationManager=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1, mBuilder.build());
		
				
	}
}
