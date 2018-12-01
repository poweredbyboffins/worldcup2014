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



	public class Matches extends Activity {
		private TextView myText = null;
		private TextView nlText = null;
		private ImageView myImageView1 = null;
		private ImageView myImageView2 = null;
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
	        
	        
	        List<Fixture> fixtures = db.getAllFixtures();
	        
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
	        
	        
	        
	        String savefixturedate = "";
	        String country;
	        String country_name1;
	        String country_name2;
	    	String header;
	    	String rowtext;
	    	String grp;
	    	String buttontext;
	    	int cnt = 0;
	    	
	    	//myText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	        
	        int colorswitch = 1;
	        
	        for (Fixture cn : fixtures) {
	            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getGroup();
	        	
	        	//grp = cn.getGroup();
	        	
	        	
	        	
	        	//if (grp != savedGrp)
	        	String team1 = cn.getteam1();
	        	String team2 = cn.getteam2();
	        	String fixturedate = cn.getfixturedate();
	        	
	        	
	        	
	        	if (fixturedate != savefixturedate)	        	
	        	{
	        		savefixturedate=fixturedate;
	        		
		        	Button grpButton = new Button(this);
		        	
		        	buttontext = savefixturedate;
		        	
		        	
		        	
		            grpButton.setText(buttontext);
		            grpButton.setTypeface(null, Typeface.BOLD);
		            grpButton.setBackgroundColor(LIGHTGREEN);
		            
		            grpButton.setLayoutParams(new LayoutParams(
		                ViewGroup.LayoutParams.WRAP_CONTENT,
		                    ViewGroup.LayoutParams.WRAP_CONTENT));
		            
		            lView.addView(grpButton);
		            
	        	}
	        	
	        	cnt++;
	        	
	        	
	            //imagewidth = myImageView.getWidth();
	       	
	        	TableRow tableRow = new TableRow(this);
	            tableRow.setLayoutParams(rowParams);
	            
	            TableRow tableRow2 = new TableRow(this);
	            tableRow2.setLayoutParams(rowParams);
	            
	            
	            myImageView1 = new ImageView(this);
	        	R.drawable ourRID = new R.drawable();
	        	String imagename1 = team1.toLowerCase();
	            Field photoNameField = ourRID.getClass().getField(imagename1);
	            myImageView1.setImageResource(photoNameField.getInt(ourRID));
	            myImageView1.setLayoutParams(new LayoutParams(
		                ViewGroup.LayoutParams.WRAP_CONTENT,
		                    ViewGroup.LayoutParams.WRAP_CONTENT));
	            
	            
	            myImageView2 = new ImageView(this);
	        	R.drawable ourRID2 = new R.drawable();
	        	String imagename2 = team2.toLowerCase();
	            Field photoNameField2 = ourRID.getClass().getField(imagename2);
	            myImageView2.setImageResource(photoNameField2.getInt(ourRID2));
	            myImageView2.setLayoutParams(new LayoutParams(
		                ViewGroup.LayoutParams.WRAP_CONTENT,
		                    ViewGroup.LayoutParams.WRAP_CONTENT));
	            
	        	myText = new TextView(this);
	        	
	        	
	        	
	        	//myText.setLayoutParams(rowParams);
	        	team1 = utils.padRight(team1,20);
	        	team2 = utils.padRight(team2,20);
	        	
	        	/*
	            myImageView = new ImageView(this);
	        	
	        	R.drawable ourRID = new R.drawable();
	        	String imagename = country_name.toLowerCase();
	            Field photoNameField = ourRID.getClass().getField(imagename);
	            myImageView.setImageResource(photoNameField.getInt(ourRID));
	            */
	        	
	            //myImageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 30));
	            //myImageView.setLayoutParams(new LayoutParams(30, 30));
	            
	        	rowtext = team1 + spaces + "0" + spaces + "-" + spaces + "0" + spaces + team2;
	        	//myText.setText(rowtext);
	        	myText.setId(cn.getID());
	        	
	        	/*
	        	SpannableString sptext = new SpannableString(rowtext);
	        	Drawable d = getResources().getDrawable(photoNameField.getInt(ourRID));
	        	d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
	        	
	        	ImageSpan span = new ImageSpan(d, null);
	        	
	        	sptext.setSpan(span,0,50,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
	        	
	        	myText.setText(sptext);
	        	        	
	        	myText.append(rowtext);
	        	*/
	        	
	        	myText.setText(rowtext);
	        	myText.setTypeface(null, Typeface.BOLD);
	        	myText.setBackgroundColor(LIGHTGREENBLUE);
	        	
	        	//lView.addView(myImageView);
	        	//myText.setTextSize(TypedValue.COMPLEX_UNIT_PX,24);
	        	
	        	//lView.addView(tableRow); 	
	        	
	        	//lView.addView(myText);
	        	
	        	
	        	lView.addView(tableRow);
	        	lView.addView(myImageView1);
	        	lView.addView(myImageView2);
	        	
	        	lView.addView(tableRow2);
	        	lView.addView(myText);

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
		        messageBox("Matches", e.getMessage());
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
