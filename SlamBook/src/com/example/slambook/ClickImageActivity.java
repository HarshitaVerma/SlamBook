package com.example.slambook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.Random;

import android.os.Bundle;
import android.os.Environment;


import android.view.View;

import android.widget.ImageView;
import android.widget.Toast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;



public class ClickImageActivity extends Activity {
	private static final  int CAMERA_REQUEST=1;
	ImageView iv=null;
	String outputfyl=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_click_image);
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		
		
	}
	
	public void Camera(View v)
	{
		Intent cameraintent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		
		startActivityForResult(cameraintent, CAMERA_REQUEST);
	}
	
	protected void onActivityResult(int requestcode,int resultcode,Intent data)
	{
		super.onActivityResult(requestcode, resultcode, data);
		if(requestcode==CAMERA_REQUEST)
		{
			Bitmap photo=(Bitmap)data.getExtras().get("data");
			iv.setImageBitmap(photo);
		}
		try {
			insert(iv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(View v) throws IOException	
	{
   	iv.setDrawingCacheEnabled(true);
	Bitmap bitmap=iv.getDrawingCache();
	String root=Environment.getExternalStorageDirectory().toString();
	File newDir=new File(root +"My_Slam_Images");
	newDir.mkdirs();
	Random gen=new Random();
	int n= 10000;
	n=gen.nextInt(n);
	String fotoname="Photo-"+n+".jpg";
	File file=new File(newDir,fotoname);
	if(file.exists()) file.delete();
	try{
		FileOutputStream out=new FileOutputStream(file);
		bitmap.compress(Bitmap.CompressFormat.JPEG,90,out);
		out.flush();
		out.close();
		Toast.makeText(getApplicationContext(), "Saved to your folder",Toast.LENGTH_SHORT).show();
	} catch(Exception e)
	{
	}
	

	

	}

}
	
	


	
	
	
		

			

		
