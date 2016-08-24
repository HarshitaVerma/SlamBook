package com.example.slambook;

public class AppConstants {
public static final String DBNAME2="slambook2";
public static final String TBLNAME="slambookdetails";
public static final String NAME="name";
public static final String NICKNAME="nicknm";
public static final String ADDRESS="address";
public static final String PHONE="phone";
public static final String BDAY="bday";
public static final String HOBBY="hobby";
public static final String EMAIL="email";

public static final String BSTFRND="bstfrnd";
public static final String AIM="aim";
public static final String HAPPYMOMENT="happymoment";
public static final String SONG="song";
public static final String MOVIE="movie";
public static final String SPORT="sport";

public static final String CREATEQUERY="create table "+TBLNAME+"("+NAME+" text primary key, "+NICKNAME+" text, "+ADDRESS+" text, "+AIM+" text, "+BDAY+" text,"+BSTFRND+" text, "+EMAIL+" text, "+HAPPYMOMENT+" text, "+HOBBY+" text, "+MOVIE+" text, "+PHONE+" text, "+SONG+" text, "+SPORT+" text)";

}
