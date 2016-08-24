package com.example.slambook;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;

public class AddFrnd extends Activity {
	TextView iv=null;
	Person P=null;
ListView lv=null;
ArrayList<Person> category=null;
ArrayAdapter<Person> ad=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_frnd);
		 iv=(TextView)findViewById(R.id.Category);
	        Animation a=AnimationUtils.loadAnimation(this,R.anim.fadeinout);
	        iv.startAnimation(a);
		
		lv=(ListView)findViewById(R.id.categorylist);
		
		category=new ArrayList<Person>();
		category.add(new Person("Friend"));
		category.add(new Person("Family Members"));
		category.add(new Person("Office Friend"));
		category.add(new Person("Teacher"));
		category.add(new Person("Other"));
		ad=new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1,category);
	 lv.setAdapter(ad);
	
     lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			
			    Person p=category.get(position);
				Intent i=new Intent(AddFrnd.this,AddDetails.class);
				
				i.putExtra("Frnd","Friend");
				i.putExtra("Frnd", "Family Members");
				i.putExtra("Frnd", "Office Friend");
				i.putExtra("Frnd", "Teacher");
				i.putExtra("Frnd", "Other");
				startActivity(i);
				
			// TODO Auto-generated method stub
		}	
		
	
});
	
	}
}
