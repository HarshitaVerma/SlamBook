package com.example.slambook;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class Receiver extends BroadcastReceiver {
	Context ctx=null;
	@Override





	public void onReceive(Context ctx, Intent arg1)
	{
		
this.ctx=ctx;
       
		Intent i=new Intent(ctx,BirthdayAlarm.class);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent pd=PendingIntent.getActivity(ctx, 2, i, 0);
		NotificationCompat.Builder n=new NotificationCompat.Builder(ctx);
		n.setSmallIcon(R.drawable.ic_launcher);
		n.setContentTitle("Title");
		n.setContentText("text");
		n.setContentIntent(pd);
		n.setAutoCancel(true);
		Notification not=n.build();
	
      NotificationManager nm=(NotificationManager)ctx.getSystemService(Context.NOTIFICATION_SERVICE);
		nm.notify(1,not);

	ctx.startService(i);
	
	
	
		
}}
	



