package com.example.worldcup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
																		

public class WC_Menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wc__menu);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//MenuInflater inflater=getMenuInflater();
	    //inflater.inflate(R.menu.menu, menu);
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
																							
	/** Called when the user touches the button */
	public void displayMatches(View view) {
	    // Do something in response to button click
		Intent i = new Intent(WC_Menu.this, Matches.class);
    	startActivity(i);
	}
	
	public void displayGroups(View view) {
	    // Do something in response to button click
		Intent i = new Intent(WC_Menu.this, GroupsTest.class);
    	startActivity(i);
	}
	
	public void displayTeams(View view) {
	    // Do something in response to button click
		Intent i = new Intent(WC_Menu.this, TeamsActivity.class);
    	startActivity(i);
	}

	public void displayNews(View view) {
		Intent i = new Intent(WC_Menu.this, Rss.class);
    	startActivity(i);
	}


}
