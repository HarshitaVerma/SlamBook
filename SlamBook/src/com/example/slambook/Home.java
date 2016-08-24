package com.example.slambook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends Activity {
TextView txt,txt1,txt2,txt3=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		 
		txt=(TextView)findViewById(R.id.txtaddfrnd);
		txt1=(TextView)findViewById(R.id.txtviewfrnd);
		txt2=(TextView)findViewById(R.id.txtcontact);
		txt3=(TextView)findViewById(R.id.txtbday);
		Typeface tf=Typeface.createFromAsset(getAssets(),"font/android_7.ttf");
		txt.setTypeface(tf);
		txt1.setTypeface(tf);
		txt2.setTypeface(tf);
		txt3.setTypeface(tf);
	}
public void add(View V)
{
	Intent i=new Intent(this,AddFrnd.class);
	startActivity(i);
}
public void view(View V)
{
	Intent i=new Intent(this,ViewDetails.class);
	startActivity(i);
}
public void contact(View V)
{
	Intent i=new Intent(this,Contact.class);
	startActivity(i);
}
public void bday(View V)
{
	Intent i=new Intent(this,Bday.class);
	startActivity(i);
}
	

}
