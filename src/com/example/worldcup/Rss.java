package com.example.worldcup;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ListView;


import java.util.ArrayList;

import android.util.Log;
import android.app.AlertDialog;
	//import android.graphics.Paint;
	//import android.graphics.Canvas;
	//import android.graphics.Paint.FontMetrics;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlPullParser;
import java.net.URL;
import java.io.InputStream;
import java.io.IOException;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.net.Uri;
//import android.net.UriBuilder;
import android.view.View;
import android.widget.TextView;



public class Rss extends ListActivity {
	 
	ArrayList<String> headlines;
	ArrayList<String> links;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     // Initializing instance variables
        headlines = new ArrayList<String>();
        links = new ArrayList<String>();
        
        
         
        try {
            URL url = new URL("http://www.fifa.com/worldcup/news/rss.xml");
         
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();
         
                // We will get the XML from an input stream
            xpp.setInput(getInputStream(url), "UTF_8");
         
                /* We will parse the XML content looking for the "<title>" tag which appears inside the "<item>" tag.
                 * However, we should take in consideration that the rss feed name also is enclosed in a "<title>" tag.
                 * As we know, every feed begins with these lines: "<channel><title>Feed_Name</title>...."
                 * so we should skip the "<title>" tag which is a child of "<channel>" tag,
                 * and take in consideration only "<title>" tag which is a child of "<item>"
                 *
                 * In order to achieve this, we will make use of a boolean variable.
                 */
            boolean insideItem = false;
         
                // Returns the type of current event: START_TAG, END_TAG, etc..
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
         
                    if (xpp.getName().equalsIgnoreCase("item")) {
                        insideItem = true;
                    } else if (xpp.getName().equalsIgnoreCase("title")) {
                        if (insideItem)
                            headlines.add(xpp.nextText()); //extract the headline
                    } else if (xpp.getName().equalsIgnoreCase("link")) {
                        if (insideItem)
                            links.add(xpp.nextText()); //extract the link of article
                    }
                }else if(eventType==XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")){
                    insideItem=false;
                }
         
                eventType = xpp.next(); //move to next element
            }
         
        /*} catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("Rss Feed", "exception", e);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            Log.e("Rss Feed", "exception", e);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Rss Feed", "exception", e);
        }*/
        }   catch(Exception e)
	    {
        	messageBox("RSS Error", e.getMessage());
	    }
        
        
         
        // Binding data
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          //      android.R.layout.simple_list_item_1, headlines);
        
        
        
        //String[] params = {android.R.layout.simple_list_item_1, headlines};        		                                    , headlines]
        
        
        String[] headlinearray = new String[headlines.size()];
        headlinearray = headlines.toArray(headlinearray);
        
        SpecialAdapter adapter = new SpecialAdapter(this, headlinearray);
        		
        		                                    
        //list.setAdapter(adapter);
        setListAdapter(adapter);
 
    }
 
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
       Uri uri = Uri.parse(links.get(position));
       Intent intent = new Intent(Intent.ACTION_VIEW, uri);
       startActivity(intent);
    }
    
    //@Override
    public InputStream getInputStream(URL url) {
    	   try {
    	       return url.openConnection().getInputStream();
    	   } catch (IOException e) {
    		   messageBox("GetInout Stream Error", e.getMessage());
    	       return null;
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
}