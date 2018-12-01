package com.example.worldcup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.ImageView;
import java.lang.reflect.Field;
import android.util.Log;
import android.app.AlertDialog;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.graphics.Color;
import android.text.style.ImageSpan;
import android.text.SpannableString;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.widget.ScrollView;
//import android.graphics.Paint;
//import android.graphics.Canvas;
//import android.graphics.Paint.FontMetrics;
import android.widget.Button;
import android.graphics.Typeface;



public class GroupsTest extends Activity {
	private TextView myText = null;
	private TextView nlText = null;
	private ImageView myImageView = null;
	private TextView myText1 = null;
	private TextView myText2 = null;
	private TextView myText3 = null;
	private TextView myText4 = null;
	private String spaces = "     ";
	public static final int LIGHTGREEN = Color.rgb(204, 255, 204);
	public static final int LIGHTGREENBLUE = Color.rgb(204, 255, 229);
	public static final int LIGHTYELLOW = Color.rgb(255, 255, 204);
	public int cnt;


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
        // Inserting Contacts
        /*
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
        */
		
        // Reading all contacts
        //Log.d("Reading: ", "Reading all contacts..");
        
        
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
        String country_head;
    	String header;
    	String rowtext;
    	String grp;
    	String buttontext;
    	int cnt = 0;
    	int imagewidth;
    	
    	//myText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        
        int colorswitch = 1;
        
        for (Team cn : teams) {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getGroup();
        	
        	grp = cn.getGroup();
        	
        	
        	String country_name = cn.getName();
        	//myText.setLayoutParams(rowParams);
        	
        	
            myImageView = new ImageView(this);
        	R.drawable ourRID = new R.drawable();
        	String imagename = country_name.toLowerCase();
            Field photoNameField = ourRID.getClass().getField(imagename);
            myImageView.setImageResource(photoNameField.getInt(ourRID));
            imagewidth = myImageView.getWidth();
            int pad = 20 - imagewidth;
            
            if (pad < 0)
            {
            	// adjust the pad
            	pad = 20;
            	
            }
        	
            country = utils.padRight(country_name,pad);
        	
        	if ((cnt % 4) == 0 || cnt==0)
        	
        	{
        		savedGrp=grp;
        		
	        	Button grpButton = new Button(this);
	        	
	        	buttontext = "Group " + grp;
	        	
	        	
	        	
	            grpButton.setText(buttontext);
	            grpButton.setTypeface(null, Typeface.BOLD);
	            grpButton.setBackgroundColor(LIGHTGREENBLUE);
	            
	            grpButton.setLayoutParams(new LayoutParams(
	                ViewGroup.LayoutParams.WRAP_CONTENT,
	                    ViewGroup.LayoutParams.MATCH_PARENT));
	            
	            lView.addView(grpButton);
	            
	            nlText = new TextView(this);
	            nlText.setText("\n");
	            
	            
	            country_head = utils.padRight("Country",20);
	        	header = country_head + spaces + "P" + spaces + "W" + spaces + "D" + spaces + "L" + spaces + "Pts";
	        	
	        	myText = new TextView(this);
	        	myText.setText(header);
	        	myText.setTypeface(null, Typeface.BOLD);
	        	myText.setBackgroundColor(LIGHTGREEN);
	        	lView.addView(myText);
        	
        	}
        	
        	cnt++;
       	
        	TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(rowParams);
            
        	myText = new TextView(this);
        	
        	
        	
        	
        	
        	
            
            //myImageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 30));
            //myImageView.setLayoutParams(new LayoutParams(30, 30));
            
        	rowtext = country + spaces + "1" + spaces + "1" + spaces + "0" + spaces + "0" + spaces + "2";
        	//myText.setText(rowtext);
        	myText.setId(cn.getID());
        	
        	
        	//SpannableString sptext = new SpannableString(rowtext);
        	Drawable d = getResources().getDrawable(photoNameField.getInt(ourRID));
        	d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        	
        	//ImageSpan span = new ImageSpan(d, null);
        	
        	//sptext.setSpan(span,0,50,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        	
        	//myText.setText(sptext);
        	        	
        	//myText.append(rowtext);
        	lView.addView(tableRow); 
        	myText.setCompoundDrawablesWithIntrinsicBounds(photoNameField.getInt(ourRID),0,0,0);
            //lView.addView(myImageView);
            //lView.addView(myText);
        	
        	myText.setText(rowtext);
        	
        	//lView.addView(myImageView);
        	//myText.setTextSize(TypedValue.COMPLEX_UNIT_PX,24);
        	
        	//lView.addView(tableRow); 	
        	
        	lView.addView(myText);
        	
        	
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

