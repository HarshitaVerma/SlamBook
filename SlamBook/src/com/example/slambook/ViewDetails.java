package com.example.slambook;

import java.util.ArrayList;


import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class ViewDetails extends Activity {
	Person P=null;
ListView lv=null;
DataBaseManager dm=null;
SQLiteDatabase sb=null;
ArrayList<Person> category=null;
ArrayAdapter<Person> ad=null;
String name=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_details);
		lv=(ListView)findViewById(R.id.listView1);
		dm=new DataBaseManager(this);
		dm.openDb();
	
		lv=(ListView)findViewById(R.id.listView1);
		category=new ArrayList<Person>();
	    
	    
		 showData();
		}
	
	 public void showData() {
		 
		 Cursor c=dm.viewData();
		 
		 while(c.moveToNext())
			{
				String name=c.getString(c.getColumnIndex(AppConstants.NAME));
				category.add(new Person(name));
				ad=new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1,category);
				 lv.setAdapter(ad);
				
		}

		 lv.setOnItemClickListener(new OnItemClickListener() {

				
				
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int position,
						long arg3) {
					
					  /*  Person p=category.get(position);
*/						Intent i=new Intent(ViewDetails.this,DetailedInfo.class);
						
						i.putExtra("frnd", position);
						
						startActivity(i);
						
					// TODO Auto-generated method stub
				}	
				
			
		});
	 }
			
		 public void Back(View v)
		 {
			 Intent obj=new Intent(this,Home.class);
			 startActivity(obj); 
		 }

	 }



	
