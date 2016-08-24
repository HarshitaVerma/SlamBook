package com.example.slambook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends Activity {
Boolean flag=true;
ImageView iv=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv=(ImageView)findViewById(R.id.imageView1);
        Animation a=AnimationUtils.loadAnimation(this,R.anim.fadeinout);
        iv.startAnimation(a);
        new Thread(new Runnable()
        {

		
			public void run()
			{
				try {
					Thread.sleep(6000);
					Intent i=new Intent(Splash.this,Home.class);
					startActivity(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
        	
        }).start();
    }


    
}
