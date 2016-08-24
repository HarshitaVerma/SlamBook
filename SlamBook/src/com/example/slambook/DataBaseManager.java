package com.example.slambook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager
{
	Context context=null;

SQLiteDatabase sdb=null;
MySQLOpenHelper mh=null;
public DataBaseManager(Context context)
{
	mh=new MySQLOpenHelper(context, AppConstants.DBNAME2, null, 1);
	
}
public void openDb()
{
	sdb=mh.getWritableDatabase();
}
public void closeDb()
{
	mh.close();
}
public long insertData(String name,String nicknm,String address,String phone,String bday,String hobby,String email,String bstfrnd,String aim,String happymoment,String song,String movie,String sport)
{
	ContentValues cv=new ContentValues();
	cv.put(AppConstants.NAME, name);
	cv.put(AppConstants.NICKNAME, nicknm);
	cv.put(AppConstants.ADDRESS, address);
	cv.put(AppConstants.PHONE, phone);
	cv.put(AppConstants.BDAY, bday);
	cv.put(AppConstants.HOBBY, hobby);
	cv.put(AppConstants.EMAIL, email);
	
	cv.put(AppConstants.BSTFRND, bstfrnd);
	cv.put(AppConstants.AIM, aim);
	cv.put(AppConstants.HAPPYMOMENT, happymoment);
	cv.put(AppConstants.SONG, song);
	cv.put(AppConstants.MOVIE, movie);	
	cv.put(AppConstants.SPORT, sport);	

	/*cv.put(AppConstants.PIC, arrimg);*/
	long rw=sdb.insert(AppConstants.TBLNAME, null, cv);
	return rw;
	
}
public Cursor viewData()
{
	Cursor c=null;
	
	c=sdb.query(AppConstants.TBLNAME, null, null, null, null, null, null);
	return c;
	
}

}

