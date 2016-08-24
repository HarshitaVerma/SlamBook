package com.example.slambook;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailedInfo extends Activity {
	Person p=null;
TextView tv,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12=null;
	DataBaseManager dm=null;

String name=null;
int pos=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detailed_info);
	tv=(TextView)findViewById(R.id.textView2);
	tv1=(TextView)findViewById(R.id.textView4);
	tv2=(TextView)findViewById(R.id.textView6);
	tv3=(TextView)findViewById(R.id.textView8);
	tv4=(TextView)findViewById(R.id.textView10);
	tv5=(TextView)findViewById(R.id.textView12);
	tv6=(TextView)findViewById(R.id.textView14);
	tv7=(TextView)findViewById(R.id.textView16);
	tv8=(TextView)findViewById(R.id.textView18);
	tv9=(TextView)findViewById(R.id.textView20);
	tv10=(TextView)findViewById(R.id.textView22);
	tv11=(TextView)findViewById(R.id.textView24);
	tv12=(TextView)findViewById(R.id.textView26);
	
	
		Intent i=getIntent();
	     pos= i.getIntExtra("frnd" , 2);
	     
		dm=new DataBaseManager(this);
		dm.openDb();
		
	    showData();
		 
		}
	
	 public void showData() {
		 
		 Cursor c=dm.viewData();
		 
		 if(c.moveToPosition(pos))
			{
				  String name=c.getString(c.getColumnIndex(AppConstants.NAME));
				String nicknm=c.getString(c.getColumnIndex(AppConstants.NICKNAME));
				String address=c.getString(c.getColumnIndex(AppConstants.ADDRESS));
				String phone=c.getString(c.getColumnIndex(AppConstants.PHONE));
				String bday=c.getString(c.getColumnIndex(AppConstants.BDAY));
				String hobby=c.getString(c.getColumnIndex(AppConstants.HOBBY));
				String email=c.getString(c.getColumnIndex(AppConstants.EMAIL));
				String bstfrnd=c.getString(c.getColumnIndex(AppConstants.BSTFRND));
				String aim=c.getString(c.getColumnIndex(AppConstants.AIM));
				String happymoment=c.getString(c.getColumnIndex(AppConstants.HAPPYMOMENT));
				String song=c.getString(c.getColumnIndex(AppConstants.SONG));
				String movie=c.getString(c.getColumnIndex(AppConstants.MOVIE));
				String sport=c.getString(c.getColumnIndex(AppConstants.SPORT));
				
				tv.setText(name);
				tv1.setText(nicknm);
				tv2.setText(address);
				tv3.setText(phone);
				tv4.setText(bday);
				tv5.setText(hobby);
				tv6.setText(email);
				tv7.setText(bstfrnd);
				tv8.setText(aim);
				tv9.setText(happymoment);
				tv10.setText(song);
				tv11.setText(movie);
				tv12.setText(sport);
				
				
				}
	 }
		 public void Back(View v)
		 {
			 Intent obj=new Intent(this,ViewDetails.class);
			 startActivity(obj); 
		 }
		 
		 
	}



				