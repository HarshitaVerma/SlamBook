package com.example.slambook;



import java.io.IOException;



import android.app.Activity;
import android.content.Intent;
 
import android.database.sqlite.SQLiteDatabase;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;


import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class AddDetails extends Activity
{
	private MediaRecorder myRecorder; 


	  private MediaPlayer myPlayer; 


	    private String outputFile = null; 


	    private Button startBtn; 


	    private Button stopBtn; 

	    private Button playBtn; 


	    private Button stopPlayBtn; 


	    private TextView text;       


TextView txt,txt1,txt2,txt3,txt4,txt5,txt6,txt8,txt9,txt10,txt11,txt12,txt13=null;
Button btn=null;


SQLiteDatabase sdb=null;
DataBaseManager dm=null;
ImageView iv=null;
String outputfyl=null;
String name, nicknm, address, phone, bday, hobby, email, bstfrnd, aim, happymoment, song, movie, sport, AUDIO=null;
/*int  CAMERA_REQUEST=77;*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_details);
		  text = (TextView) findViewById(R.id.textView14); 
		  // store it to sd card 


		    outputFile = Environment.getExternalStorageDirectory(). 


		          getAbsolutePath() + "/AudioRecording.3gpp"; 


		   


		       myRecorder = new MediaRecorder(); 


		       myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC); 


		       myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP); 


		       myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB); 


		    myRecorder.setOutputFile(outputFile);          


		    startBtn = (Button)findViewById(R.id.button2); 


		       startBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 start(v); 

					
				}
			});
		       
		       stopBtn = (Button)findViewById(R.id.button5); 


		       stopBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					stop(v); 
					
				}
			});            

		       playBtn = (Button)findViewById(R.id.button3); 

		       playBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					play(v);
				}
			});
		
		       stopPlayBtn = (Button)findViewById(R.id.button4); 


		       stopPlayBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 stopPlay(v); 
				}
			});
		       
	
	
		Intent i=getIntent();
	     i.getSerializableExtra("frnd");
		
		dm=new DataBaseManager(this);
		
		dm.openDb();
		txt=(TextView)findViewById(R.id.editText1);
		txt1=(TextView)findViewById(R.id.editText2);
		txt2=(TextView)findViewById(R.id.editText3);
		txt3=(TextView)findViewById(R.id.editText4);
		txt4=(TextView)findViewById(R.id.editText5);
		txt5=(TextView)findViewById(R.id.editText6);
		txt6=(TextView)findViewById(R.id.editText7);
		
		txt8=(TextView)findViewById(R.id.editText8);
		txt9=(TextView)findViewById(R.id.editText9);
		txt10=(TextView)findViewById(R.id.editText10);
		txt11=(TextView)findViewById(R.id.editText11);
		txt12=(TextView)findViewById(R.id.editText12);
		txt13=(TextView)findViewById(R.id.editText13);
		iv=(ImageView)findViewById(R.id.imageView1);
		
	    	 
	} 	
	

public void Save(View V)
{
	name=txt.getText().toString().trim();
	nicknm=txt1.getText().toString().trim();
	address=txt2.getText().toString().trim();
	phone=txt3.getText().toString().trim();
	bday=txt4.getText().toString().trim();
	hobby=txt5.getText().toString().trim();
	email=txt6.getText().toString().trim();
	bstfrnd=txt8.getText().toString().trim();
	aim=txt9.getText().toString().trim();
	happymoment=txt10.getText().toString().trim();
	song=txt11.getText().toString().trim();
	movie=txt12.getText().toString().trim();
	sport=txt13.getText().toString().trim();
	
    long l=dm.insertData(name, nicknm, address, phone, bday, hobby, email, bstfrnd, aim, happymoment, song, movie, sport);
	
	Toast.makeText(this, "Thanks For Filling"+l, Toast.LENGTH_LONG).show();
	
	if(l>0)
	{
		Toast.makeText(this, "inserted"+l, Toast.LENGTH_SHORT).show();
		
	}
	Intent i=new Intent(this,ClickImageActivity.class);
	startActivity(i);
}


	
public void start(View view){ 


	  try { 


	  myRecorder.prepare(); 


	 myRecorder.start(); 


	  } catch (IllegalStateException e) { 

	 // start:it is called before prepare() 


	 // prepare: it is called after start() or before setOutputFormat()  


	 e.printStackTrace(); 

	 } catch (IOException e) { 


	 // prepare() fails 


	  e.printStackTrace(); 


	 } 


	 text.setText("Recording Point: Recording"); 


	startBtn.setEnabled(false); 


	 stopBtn.setEnabled(true); 


	  Toast.makeText(getApplicationContext(), "Start recording...",  


	 Toast.LENGTH_SHORT).show(); 

	  } 


	  public void stop(View view){ 


	  try { 


	 myRecorder.stop(); 


	myRecorder.release(); 


	myRecorder  = null; 


	  stopBtn.setEnabled(false); 


	 playBtn.setEnabled(true); 


	  text.setText("Recording Point: Stop recording"); 


	  Toast.makeText(getApplicationContext(), "Stop recording...", 


	Toast.LENGTH_SHORT).show(); 


	 } catch (IllegalStateException e) { 


	 //  it is called before start() 


	 e.printStackTrace(); 


	 } catch (RuntimeException e) { 


	 // no valid audio/video data has been received 


	e.printStackTrace(); 


	 } 


	 } 


	  public void play(View view) { 


	 try{ 


	 myPlayer = new MediaPlayer(); 


	   myPlayer.setDataSource(outputFile); 


	 myPlayer.prepare(); 


	myPlayer.start(); 


	 playBtn.setEnabled(false); 


	stopPlayBtn.setEnabled(true); 


	text.setText("Recording Point: Playing"); 


	 Toast.makeText(getApplicationContext(), "Start play the recording...",Toast.LENGTH_LONG).show();


	   } catch (Exception e) { 


	 // TODO Auto-generated catch block 


	e.printStackTrace(); 


	  } 


	   } 


	 public void stopPlay(View view) { 


	  try { 


	 if (myPlayer != null) { 


	 myPlayer.stop(); 


	 myPlayer.release(); 


	 myPlayer = null; 


	 playBtn.setEnabled(true); 


	 stopPlayBtn.setEnabled(false); 


	text.setText("Recording Point: Stop playing"); 


	 Toast.makeText(getApplicationContext(), "Stop playing the recording...",  


	 Toast.LENGTH_SHORT).show(); 


	 } 


	  } catch (Exception e) { 


	 // TODO Auto-generated catch block 


	 e.printStackTrace(); 


	 } 


	  } 


	 } 
