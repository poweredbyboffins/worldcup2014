package com.example.worldcup;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;

public class DatabaseHelper extends SQLiteOpenHelper{
    
//The Android's default system path of your application database.
private static String DB_PATH = "/data/data/com.example.worldcup/databases/";
 
private static String DB_NAME = "worldcup.db";

//Table names
private static final String TABLE_TEAMS = "teams";
private static final String TABLE_FIXTURES = "fixtures";


// Contacts Table Columns names
private static final String KEY_ID = "_id";
private static final String KEY_NAME = "name";
private static final String KEY_GRP = "group_id";
 
private SQLiteDatabase myDataBase;
 
private final Context myContext;
 
/**
  * Constructor
  * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
  * @param context
  */
public DatabaseHelper(Context context) {
 
super(context, DB_NAME, null, 1);
this.myContext = context;
}	
 
/**
  * Creates a empty database on the system and rewrites it with your own database.
  * */
public void createDataBase() throws IOException{


myContext.deleteDatabase(DB_NAME);
	
 boolean dbExist = checkDataBase();
 
if(dbExist){
//do nothing - database already exist
}else{
 
//By calling this method and empty database will be created into the default system path
//of your application so we are gonna be able to overwrite that database with our database.
this.getReadableDatabase();
 
try {
 
copyDataBase();
 
} catch (IOException e) {
 
throw new Error("Error copying database");
 
}
}
 
}
 
/**
  * Check if the database already exist to avoid re-copying the file each time you open the application.
  * @return true if it exists, false if it doesn't
  */
private boolean checkDataBase(){
 
SQLiteDatabase checkDB = null;
 
try{
String myPath = DB_PATH + DB_NAME;
checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
}catch(SQLiteException e){
 
//database does't exist yet.
 
}
 
if(checkDB != null){
 
checkDB.close();
 
}
 
return checkDB != null ? true : false;
}
 
/**
  * Copies your database from your local assets-folder to the just created empty database in the
  * system folder, from where it can be accessed and handled.
  * This is done by transfering bytestream.
  * */
private void copyDataBase() throws IOException{
 
//Open your local db as the input stream
InputStream myInput = myContext.getAssets().open(DB_NAME);
 
// Path to the just created empty db
String outFileName = DB_PATH + DB_NAME;
 
//Open the empty db as the output stream
OutputStream myOutput = new FileOutputStream(outFileName);
 
//transfer bytes from the inputfile to the outputfile
byte[] buffer = new byte[1024];
int length;
while ((length = myInput.read(buffer))>0){
myOutput.write(buffer, 0, length);
}
 
//Close the streams
myOutput.flush();
myOutput.close();
myInput.close();
 
}
 
public void openDataBase() throws SQLException{
 
//Open the database
String myPath = DB_PATH + DB_NAME;
myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
}
 
@Override
public synchronized void close() {
 
if(myDataBase != null)
myDataBase.close();
 
super.close();
 
}
 
@Override
public void onCreate(SQLiteDatabase db) {
 
}
 
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
	 myContext.deleteDatabase(DB_NAME);
 
}
 
// Add your public helper methods to access and get content from the database.
// You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
// to you to create adapters for your views.
 


// Getting All Teams
public List<Team> getAllTeams() {
    List<Team> teamList = new ArrayList<Team>();
    // Select All Query
    String selectQuery = "SELECT  name,group_id FROM " + TABLE_TEAMS;
    
    String myPath = DB_PATH + DB_NAME;
    
    myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    //SQLiteDatabase db = this.getWritableDatabase();
    
    Cursor cursor = myDataBase.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            Team team = new Team();
            //team.setID(Integer.parseInt(cursor.getString(0)));
            
            //team.setID(cursor.getInt(0));
            
            team.setName(cursor.getString(0));
            team.setGroup(cursor.getString(1));
            // Adding contact to list
            teamList.add(team);
        } while (cursor.moveToNext());
    }
    cursor.close();
    // return teams
    return teamList;
}


//Getting All Fixtures
public List<Fixture> getAllFixtures() {
 List<Fixture> fixtureList = new ArrayList<Fixture>();
 // Select All Query
 String selectQuery = "SELECT  team1,team2,fixturedate FROM " + TABLE_FIXTURES;
 
 String myPath = DB_PATH + DB_NAME;
 
 myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

 //SQLiteDatabase db = this.getWritableDatabase();
 
 Cursor cursor = myDataBase.rawQuery(selectQuery, null);

 // looping through all rows and adding to list
 if (cursor.moveToFirst()) {
     do {
         Fixture fixture = new Fixture();
         //team.setID(Integer.parseInt(cursor.getString(0)));
         
         //team.setID(cursor.getInt(0));
         
         fixture.setteam1(cursor.getString(0));
         fixture.setteam2(cursor.getString(1));
         fixture.setfixturedate(cursor.getString(2));
         // Adding team to list
         fixtureList.add(fixture);
     } while (cursor.moveToNext());
 }
 cursor.close();
 // return teams
 return fixtureList;
}

}