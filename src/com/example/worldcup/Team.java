package com.example.worldcup;

public class Team {
    
    //private variables
    int _id;
    String _name;
    String _group;
     
    // Empty constructor
    public Team(){
         
    }
    // constructor
    public Team(int id, String name, String _group){
        this._id = id;
        this._name = name;
        this._group = _group;
    }
     
    // constructor
    public Team(String name, String _group){
        this._name = name;
        this._group = _group;
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
    public String getName(){
        return this._name;
    }
     
    // setting name
    public void setName(String name){
        this._name = name;
    }
     
    // getting phone number
    public String getGroup(){
        return this._group;
    }
     
    // setting phone number
    public void setGroup(String group){
    	this._group = group;
    }
}



