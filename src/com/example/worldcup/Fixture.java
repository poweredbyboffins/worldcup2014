package com.example.worldcup;

public class Fixture {
    
    //private variables
    int _id;
    String team1;
    String team2;
    String fixturedate;
    String team1_score;
    String team2_score;
    String fixture_type;

     
    // Empty constructor
    public Fixture(){
         
    }
    // constructor
    public Fixture(int _id,String team1,String team2,String fixturedate, String team1_score,
    String team2_score, String fixture_type){
    	this._id=_id;
    	this.team1=team1;
    	this.team2=team2;
    	this.fixturedate=fixturedate;
    	this.team1_score=team1_score;
    	this.team2_score=team2_score;
    	this.fixture_type=fixture_type;
    }
     
    
    // getting ID
    public int getID(){
        return this._id;
    }
     
    // setting id
    public void setID(int id){
        this._id = id;
    }
     
    // getting name
    public String getteam1(){
        return this.team1;
    }
     
    // setting name
    public void setteam1(String team1){
        this.team1 = team1;
    }
     
 // getting name
    public String getteam2(){
        return this.team2;
    }
     
    // setting name
    public void setteam2(String team2){
        this.team2 = team2;
    }
    
 // getting name
    public String getfixturedate(){
        return this.fixturedate;
    }
     
    // setting name
    public void setfixturedate(String fixturedate){
        this.fixturedate = fixturedate;
    }
}

