package com.example.worldcup;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DBHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "worldcup.db";
 
    // Database Name
    //private static final String DATABASE_NAME = "WorldCup";
 
    // Contacts table name
    private static final String TABLE_TEAMS = "teams";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_GRP = "group_id";
 
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TEAMS_TABLE = "CREATE TABLE " + TABLE_TEAMS + " ( "
              + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
              + KEY_GRP + " TEXT" + " ) ";
      //db.execSQL(CREATE_TEAMS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAMS);
 
        // Create tables again
        onCreate(db);
       
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new contact
    void addTeam(Team team) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, team.getName()); // Team Name
        values.put(KEY_GRP, team.getGroup()); // Team Group
 
        // Inserting Row
        db.insert(TABLE_TEAMS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single contact
    Team getTeam(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_TEAMS, new String[] { KEY_ID,
                KEY_NAME, KEY_GRP }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Team team = new Team(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return team
        return team;
    }
     
    // Getting All Contacts
    public List<Team> getAllTeams() {
        List<Team> teamList = new ArrayList<Team>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TEAMS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Team team = new Team();
                team.setID(Integer.parseInt(cursor.getString(0)));
                team.setName(cursor.getString(1));
                team.setGroup(cursor.getString(2));
                // Adding contact to list
                teamList.add(team);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return teamList;
    }
 
    // Updating single contact
    public int updateTeam(Team team) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, team.getName());
        values.put(KEY_GRP, team.getGroup());
 
        // updating row
        return db.update(TABLE_TEAMS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(team.getID()) });
    }
 
    // Deleting single contact
    public void deleteTeam(Team team) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEAMS, KEY_ID + " = ?",
                new String[] { String.valueOf(team.getID()) });
        db.close();
    }
    public void deleteTeams() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEAMS,null,null);
        //db.execSQL("delete from "+ TABLE_TEAMS);
        db.close();
    }
    
    // Getting contacts Count
    public int getTeamsCount() {
        String countQuery = "SELECT  COUNT(*) FROM " + TABLE_TEAMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.moveToFirst();
        int count= cursor.getInt(0);
        
 
        // return count
        return count;
    }
    
    
 
}
