package com.example.slambook;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.*;
import android.util.Log;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactFriend extends Activity {
TextView txt,txt1,txt2=null;
EditText msg=null;
String message,email=null;
int pos=0;
DataBaseManager dm=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_friend);
		Intent i=getIntent();
	     pos = i.getIntExtra("frnd" , 2);
		txt=(TextView)findViewById(R.id.txtname);
		txt1=(TextView)findViewById(R.id.txtphone);
		txt2=(TextView)findViewById(R.id.txtmail);
		msg=(EditText)findViewById(R.id.editText1);

		
	     
		dm=new DataBaseManager(this);
		dm.openDb();
		
	    showData();
		 
		}
	
	 public void showData() {
		 
		 Cursor c=dm.viewData();
		 
		 if(c.moveToPosition(pos))
		 { String name=c.getString(c.getColumnIndex(AppConstants.NAME));
			String phn=c.getString(c.getColumnIndex(AppConstants.PHONE));
			String email=c.getString(c.getColumnIndex(AppConstants.EMAIL));
			txt.setText(name);
			txt1.setText(phn);
			txt2.setText(email); 
			 
		 }
			 
			 
			 
			 
			 
			 
	}
	 public void mail(View v)
	 {Log.i("Send email", "");
		String[] TO={""};
	
		
		String[] CC={""};
		Intent i=new Intent(Intent.ACTION_SEND);
		i.setData(Uri.parse("mail to:"));
		i.setType("text/plain");
		i.putExtra(Intent.EXTRA_EMAIL,TO);
		i.putExtra(Intent.EXTRA_CC, CC);
		i.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
		i.putExtra(Intent.EXTRA_TEXT, "Email Message goes here");
		try{
			startActivity(Intent.createChooser(i, "Send mail..."));
			finish();
			Log.i("Finished sending email...", "");
			
		}
		catch (android.content.ActivityNotFoundException ex){
			Toast.makeText(ContactFriend.this, "There is no email client installed.", Toast.LENGTH_LONG).show();
			
		}
		
	 }
	 
	public void call(View V)
	{ 
		try{
		String uri="tel:"+txt1.getText().toString();
		Intent callIntent=new Intent(Intent.ACTION_CALL,Uri.parse(uri));
		startActivity(callIntent);
		
	}
	catch (Exception e)
	{
		Toast.makeText(this,"your call has failed",Toast.LENGTH_LONG).show();
		e.printStackTrace();
	}
	
	}
	public void sms(View V)
	{
SmsManager sm=SmsManager.getDefault();
		
		String message=msg.getText().toString();
		String phono=txt1.getText().toString();
		Intent obj=new Intent(Intent.ACTION_SENDTO);
		PendingIntent pi=PendingIntent.getActivity(this,1, obj, 0);
		sm.sendTextMessage(phono,null,message,pi,null);
		Toast.makeText(this,"Message Sent",Toast.LENGTH_LONG).show();
		
	}



}
