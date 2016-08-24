package com.example.slambook;

import java.util.ArrayList;



import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;


public class Contact extends Activity {
	ArrayList<Person>category=null;
	ArrayAdapter<Person>ad=null;
    ListView lv=null;
    DataBaseManager dm=null;
    Person p=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		
		dm=new DataBaseManager(this);
		dm.openDb();
	
		lv=(ListView)findViewById(R.id.friendlist);
		category=new ArrayList<Person>();
	    
	    
		 showData();
		}
	
	 public void showData() {
		 
		 Cursor c=dm.viewData();
		 
		 while(c.moveToNext())
			{
				String name=c.getString(c.getColumnIndex(AppConstants.NAME));
				
				
				/*category.add(new Person(name));*/
				category.add(new Person(name));
				
				ad=new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1,category);
				 lv.setAdapter(ad);
				
		}

		 lv.setOnItemClickListener(new OnItemClickListener() {

				
				
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int position,
						long arg3) {
					
					  /*  Person p=category.get(position);
*/						Intent i=new Intent(Contact.this,ContactFriend.class);
						
						i.putExtra("frnd", position);
						
						startActivity(i);
						
					// TODO Auto-generated method stub
				}	
				
			
		});
	 }
			
		 
		 
		/* Cursor c=dm.viewData();
		 while(c.moveToNext())
			{
				
				String name=c.getString(c.getColumnIndex(AppConstants.NAME));
				String phone=c.getString(c.getColumnIndex(AppConstants.PHONE));
				p=new Person();
				
				p.setName(name);
				p.setPhone(phone);
				category.add(p);
				}
		 lv.setAdapter(ad);*/
	}


		
		
	



