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
import android.widget.BaseAdapter;
import android.view.ViewGroup;
//import android.widget.ViewHolder;
import android.view.LayoutInflater;
import android.content.Context;



public class SpecialAdapter extends BaseAdapter {
	//Defining the background color of rows. The row will alternate between green light and green dark.
	private int[] colors = new int[] { 0xAAf6ffc8, 0xAA538d00 };
	private LayoutInflater mInflater;
	 
	//The variable that will hold our text data to be tied to list.
	private String[] data;
	 
	public SpecialAdapter(Context context, String[] items) {
	    mInflater = LayoutInflater.from(context);
	    this.data = items;
	}
	 
	@Override
	public int getCount() {
	    return data.length;
	}
	 
	@Override
	public Object getItem(int position) {
	    return position;
	}
	 
	@Override
	public long getItemId(int position) {
	    return position;
	}
	 
	//A view to hold each row in the list
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	 
	// A ViewHolder keeps references to children views to avoid unneccessary calls
	// to findViewById() on each row.
	ViewHolder holder;
	 
	if (convertView == null) {
	    convertView = mInflater.inflate(R.layout.row, null);
	 
	    holder = new ViewHolder();
	    holder.text = (TextView) convertView.findViewById(R.id.headline);
	    convertView.setTag(holder);
	} else {
	    holder = (ViewHolder) convertView.getTag();
	}
	    // Bind the data efficiently with the holder.
	    holder.text.setText(data[position]);
	 
	    //Set the background color depending of  odd/even colorPos result
	    int colorPos = position % colors.length;
	    convertView.setBackgroundColor(colors[colorPos]);
	 
	   return convertView;
	}
	}

