package com.example.worldcup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Menu;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.app.AlertDialog;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;


public class TeamsActivity extends Activity {
	private TextView myText = null;
	private TextView nlText = null;
	private ImageView myImageView = null;
	private TextView myText1 = null;
	private TextView myText2 = null;
	private TextView myText3 = null;
	private TextView myText4 = null;
	private String spaces = "     ";
	public int cnt;
	public static final int LIGHTGREEN = Color.rgb(204, 255, 204);
	public static final int LIGHTGREENBLUE = Color.rgb(204, 255, 229);
	public static final int LIGHTYELLOW = Color.rgb(255, 255, 204);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(this));

		
		//myText = new TextView(this);
		
        //setContentView(R.layout.activity_groupstest);
		
		//myText = new TextView(this);
		
        //LinearLayout lView = (LinearLayout) findViewById(R.id.Groups);
        
        ScrollView sv = new ScrollView(this);
        ScrollView.LayoutParams sp = new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT, 
                LayoutParams.MATCH_PARENT);
        sv.setLayoutParams(sp);
        //sv.addView(sv);
        
		
      //Add your widget as a child of the ScrollView.
        LinearLayout lView = new LinearLayout(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 
                LayoutParams.MATCH_PARENT);
        lView.setLayoutParams(lp);
        lView.setOrientation(LinearLayout.VERTICAL);
        sv.addView(lView);
        
        //setContentView(lView);
        
        //ScrollView scrlView = (ScrollView) findViewById(R.id.Groups);
		//initFragment(new TeamsFragment());
       
		try
		{
		// DB Handler call
		DatabaseHelper db = new DatabaseHelper(this);	
		 
		db.createDataBase();
		         		
		//db.openDataBase();
		
		
		//dbpop dpop = new dbpop(db);        
        /**
         * CRUD Operations
         * */
       
        
        
        List<Team> teams = db.getAllTeams();
        
        //cnt = db.getTeamsCount();
        
        //String str = "count " + Integer.toString(cnt);
        
        
        /* LinearLayout lView = new LinearLayout(this);
        
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 
                LayoutParams.MATCH_PARENT);
        
        lView.setLayoutParams(lp);
        lView.addView(lView);
        */
        
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
       // TextView.LayoutParams textParams = new TextView.LayoutParams(TextView.LayoutParams.WRAP_CONTENT, TextView.LayoutParams.WRAP_CONTENT);

        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(tableParams);
        lView.addView(tableLayout);

        //TextView textView = new TextView(context);
        

    	//TableRow tableRow = new TableRow(this);
    	
        //tableRow.setLayoutParams(tableParams);
        //myText = new TextView(this);
        //layout.addView(myText);
        //myText.setText(str);
        
        //myText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 50));
        
        
        
        String savedGrp = "";
        String country;
    	String header;
    	String rowtext;
    	String grp;
    	String buttontext;
    	int cnt = 0;
    	
    	//myText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        
        int colorswitch = 1;
        
        for (Team cn : teams) {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getGroup();
        	
        	grp = cn.getGroup();
        	
        	
        	
        	//if (grp != savedGrp)
        	Button teamButton = new Button(this);
        	
        	
            String country_name = cn.getName();
        	
        	//myText.setLayoutParams(rowParams);
        	country = utils.padRight(country_name,20);
        	
        	
        	buttontext = country;
        	teamButton.setText(buttontext);
        	teamButton.setTypeface(null, Typeface.BOLD);
        	teamButton.setBackgroundColor(LIGHTGREEN);
        	//teamButton.setBackgroundColor(#00FFFF);
            
        	teamButton.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            
                     
        	
        	
       	
        	TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(rowParams);
            
        	myText = new TextView(this);
        	
        	
            myImageView = new ImageView(this);
        	
        	R.drawable ourRID = new R.drawable();
        	String imagename = country_name.toLowerCase();
            Field photoNameField = ourRID.getClass().getField(imagename);
            myImageView.setImageResource(photoNameField.getInt(ourRID));
            
            
            //myImageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 30));
            //myImageView.setLayoutParams(new LayoutParams(30, 30));
            
        	       	
        	
        	/*SpannableString sptext = new SpannableString(country);
        	Drawable d = getResources().getDrawable(photoNameField.getInt(ourRID));
        	d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        	
        	ImageSpan span = new ImageSpan(d, null);
        	
        	sptext.setSpan(span,0,20,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        	
        	myText.setText(sptext);
        	*/
        	        	
        	//myText.append(rowtext);
        	//myText.setText(rowtext);
        	
        	//lView.addView(myImageView);
        	//myText.setTextSize(TypedValue.COMPLEX_UNIT_PX,24);
        	
        	//lView.addView(tableRow); 	
            lView.addView(tableRow); 
            teamButton.setCompoundDrawablesWithIntrinsicBounds(photoNameField.getInt(ourRID),0,0,0);
            //lView.addView(myImageView);
            //lView.addView(myText);
        	lView.addView(teamButton);
        	
        	
        	//lView.addView(tableRow); 	

        	/*
        	if (colorswitch==1)
        	{
        		myText.setBackgroundColor(Color.YELLOW);
        		colorswitch=0;
        	}
        	else
        	{
        		myText.setBackgroundColor(Color.GREEN);
        		colorswitch = 1;
        	}
        	*/
        	
        	//myText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 50));
            //myText.setLayoutParams(lp);
             
        	 
      	
        
        }
        
        //sv.addView(lView);
        
        setContentView(sv);
        	
                // Writing Contacts to log
        //Log.d("Name: ", log);
		}
	    catch(Exception e)
	    {
	        messageBox("TeamsActivity", e.getMessage());
	    }
		
	}

	private void messageBox(String method, String message)
	{
	    Log.d("EXCEPTION: " + method,  message);

	    AlertDialog.Builder messageBox = new AlertDialog.Builder(this);
	    messageBox.setTitle(method);
	    messageBox.setMessage(message);
	    messageBox.setCancelable(false);
	    messageBox.setNeutralButton("OK", null);
	    messageBox.show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teams, menu);
		return true;
	}

}
