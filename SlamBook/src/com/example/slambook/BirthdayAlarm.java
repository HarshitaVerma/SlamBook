package com.example.slambook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.Toast;



@SuppressLint("SimpleDateFormat")
public class BirthdayAlarm extends Activity {
	
    ListView lv=null;
    DataBaseManager dm=null;
   
    java.util.Date d=null;
	    
	    
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_birthday_alarm);
	        ListView lv=(ListView)findViewById(R.id.listView1);
	        
			
		dm=new DataBaseManager(this);
		dm.openDb();
		Cursor c=dm.viewData();
		while(c.moveToNext())
		{  
			String remnm=c.getString(c.getColumnIndex(AppConstants.NAME));
			String lastdate=c.getString(c.getColumnIndex(AppConstants.BDAY));
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			d=new Date();
			
				try {
					d=sdf.parse(lastdate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			Calendar cal=Calendar.getInstance();
			cal.setTime(d);
		
			
			int month=cal.get(Calendar.MONTH);
		    int year=cal.get(Calendar.YEAR);
		    
			
			Toast.makeText(this, " "+month+year, Toast.LENGTH_LONG).show();
			
			System.out.println("month="+month);
			System.out.println("year="+year);
			
			Intent i=new Intent(this, Receiver.class);
			PendingIntent pdi=PendingIntent.getBroadcast(this, 2, i, 0);
			
			AlarmManager alarmngr=(AlarmManager)getSystemService(BirthdayAlarm.ALARM_SERVICE);
			alarmngr.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pdi);
			alarmngr.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 6*1000*60, pdi);
		
			
			Toast.makeText(this, "Alarm Set ", Toast.LENGTH_LONG).show();
			
			
		}
		
	}
		
	
	}
	
	

	

