package com.example.worldcup;

public class dbpop {
	
	public dbpop (DBHandler db)
	{
		
		//DBHandler db = new DBHandler(this);	
		
		db.deleteTeams();
        db.addTeam(new Team("Brazil", "A"));       
        db.addTeam(new Team("Croatia", "A"));
        db.addTeam(new Team("Mexico", "A"));
        db.addTeam(new Team("Cameroon", "A"));
        db.addTeam(new Team("Spain", "B"));       
        db.addTeam(new Team("Netherlands", "B"));
        db.addTeam(new Team("Chile", "B"));
        db.addTeam(new Team("Australia", "B"));
        db.addTeam(new Team("Columbia", "C"));       
        db.addTeam(new Team("Greece", "C"));
        db.addTeam(new Team("Ivory_Coast", "C"));
        db.addTeam(new Team("Japan", "C"));
        db.addTeam(new Team("Uruguay", "D"));       
        db.addTeam(new Team("Costa_Rica", "D"));
        db.addTeam(new Team("England", "D"));
        db.addTeam(new Team("Italy", "D"));
	}
	
}


