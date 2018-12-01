package com.example.worldcup;
/*
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.view.View;
*/
//import android.map.MapView;

import java.util.*;

import android.app.AlertDialog;
import android.util.Log;
import android.app.AlertDialog.Builder;


public class utils {
	
	public final static String white = "#FFFFFF";
	public final static String yellow = "#FFFF00";
	public final static String fuchsia = "#FF00FF";
	public final static String red = "#FF0000";
	public final static String silver = "#C0C0C0";
	public final static String gray = "#808080";
	public final static String olive = "#808000";
	public final static String purple = "#800080";
	public final static String maroon = "#800000";
	public final static String aqua = "#00FFFF";
	public final static String lime = "#00FF00";
	public final static String teal = "#008080";
	public final static String green = "#008000";
	public final static String blue = "#0000FF";
	public final static String navy = "#000080";
	public final static String black = "#000000";
	
	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}

	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
	
	//@Override
	/*
	public void draw(Canvas canvas,  boolean shadow) {

	Paint strokePaint = new Paint();
	strokePaint.setARGB(255, 0, 0, 0);
	strokePaint.setTextAlign(Paint.Align.CENTER);
	strokePaint.setTextSize(16);
	strokePaint.setTypeface(Typeface.DEFAULT_BOLD);
	strokePaint.setStyle(Paint.Style.STROKE);
	strokePaint.setStrokeWidth(2);

	Paint textPaint = new Paint();
	textPaint.setARGB(255, 255, 255, 255);
	textPaint.setTextAlign(Paint.Align.CENTER);
	textPaint.setTextSize(16);
	textPaint.setTypeface(Typeface.DEFAULT_BOLD);

	canvas.drawText("Some Text", 100, 100, strokePaint);
	canvas.drawText("Some Text", 100, 100, textPaint);

	super.draw(canvas, shadow); 
	}
	*/
	

	class Score implements Comparable<Score> {
	    int score;
	    String name;

	    public Score(int score, String name) {
	        this.score = score;
	        this.name = name;
	    }

	    @Override
	    public int compareTo(Score o) {
	        return score < o.score ? -1 : score > o.score ? 1 : 0;
	    }
	}

	public class Test {

	    public void scoreprocess(String[] args){
	        List<Score> scores = new ArrayList<Score>();

	        scores.add(new Score(9, "Brazil"));  
	        scores.add(new Score(3, "Cameroon"));  
	        scores.add(new Score(3, "Mexico"));  
	        scores.add(new Score(6, "Croatia"));  
	        
	        Collections.sort(scores);
	        
	        
	    }
	}

	
	

}
