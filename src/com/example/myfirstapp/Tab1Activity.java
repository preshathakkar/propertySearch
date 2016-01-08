package com.example.myfirstapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Tab1Activity extends Activity
{
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tab1);
            
            Intent intent = getIntent();
            String text = intent.getStringExtra("RESULT");
            try {
				JSONObject totaldetails = new JSONObject(text);
				
	            JSONObject res = totaldetails;
	        	System.out.println("Hey");
	            String proptyp = res.getString("useCode");
	    		System.out.println(proptyp);
	    		TextView tv = (TextView)findViewById(R.id.proptyp1);
	    		tv.setText(proptyp, TextView.BufferType.EDITABLE);
	        	
	    		String yrbt = res.getString("yearBuilt");
	    		System.out.println(yrbt);
	    		TextView tv1 = (TextView)findViewById(R.id.yrbt1);
	    		tv1.setText(yrbt, TextView.BufferType.EDITABLE);
	    		
	        	String ls = res.getString("lotSizeSqFt");
	        	TextView tv2 = (TextView)findViewById(R.id.ls1);
	    		tv2.setText(ls, TextView.BufferType.EDITABLE);
	        	
	    		String fa = res.getString("finishedSqFt");
	    		TextView tv3 = (TextView)findViewById(R.id.fa1);
	    		tv3.setText(fa, TextView.BufferType.EDITABLE);

	        	String ba = res.getString("bathrooms");
	        	TextView tv4 = (TextView)findViewById(R.id.ba1);
	    		tv4.setText(ba, TextView.BufferType.EDITABLE);

	        	String be = res.getString("bedrooms");
	        	TextView tv5 = (TextView)findViewById(R.id.be1);
	    		tv5.setText(be, TextView.BufferType.EDITABLE);

	        	String taxyr = res.getString("taxAssessmentYear");
	        	TextView tv6 = (TextView)findViewById(R.id.taxyr1);
	    		tv6.setText(be, TextView.BufferType.EDITABLE);
	    		
	        	String taxass = res.getString("taxAssessment");
	        	TextView tv7 = (TextView)findViewById(R.id.taxass1);
	    		tv7.setText(taxass, TextView.BufferType.EDITABLE);

	        	String lastsoldpr = res.getString("lastSoldPrice");
	        	TextView tv8 = (TextView)findViewById(R.id.lastsoldpr1);
	    		tv8.setText(lastsoldpr, TextView.BufferType.EDITABLE);

	        	String lastsolddt = res.getString("dateLSD");
	        	TextView tv9 = (TextView)findViewById(R.id.lastsolddt1);
	    		tv9.setText(lastsolddt, TextView.BufferType.EDITABLE);
	    		
	        	String zestpropval = res.getString("zamount");
	        	TextView tv10 = (TextView)findViewById(R.id.zestpropval1);
	    		tv10.setText(zestpropval, TextView.BufferType.EDITABLE);
	    		
	        	String zestpropdate= res.getString("dateZLU");
	        	TextView tv11 = (TextView)findViewById(R.id.zestprop);
	    		tv11.setText("Zestimate \u00AE Property Estimate \nas of "+zestpropdate+":", TextView.BufferType.EDITABLE);
	    		
	        	String thirtydaysoverallchange= res.getString("valueChange");
	        	TextView tv12 = (TextView)findViewById(R.id.thirtydaysoverallchange1);
	        	
	    		tv12.setText(thirtydaysoverallchange, TextView.BufferType.EDITABLE);
	    		//String imageUrl = res.getString("zimg"); 
	    		//Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageUrl).getContent());
	    		
	    		//ImageView i = (ImageView)findViewById(R.id.zimg);
	    		  //Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageUrl).getContent());
	    		  //i.setImageBitmap(bitmap); 
//	    	 
	    		
	        	String alltimeproplow = res.getString("valuationRangeLow");
	        	String alltimeprophigh = res.getString("valuationRangeHigh");
	        	TextView tv13 = (TextView)findViewById(R.id.alltimeproplowhigh);
	    		tv13.setText(alltimeproplow+" - "+alltimeprophigh, TextView.BufferType.EDITABLE);
	    		
	        
	    		String restpropval= res.getString("rzamount");
	        	TextView tv14 = (TextView)findViewById(R.id.restpropval1);
	    		tv14.setText(restpropval, TextView.BufferType.EDITABLE);
	    		
	        	String restpropdate= res.getString("dateRZLU");
	        	TextView tv15 = (TextView)findViewById(R.id.restprop);
	    		tv15.setText("Rent Zestimate \u00AE Rent Valuation \nas of "+restpropdate, TextView.BufferType.EDITABLE);
	    		
	        	String thirtydaysrentchange =res.getString("rzvalueChange");
	        	TextView tv16 = (TextView)findViewById(R.id.thirtydaysrentchange1);
	    		tv16.setText(thirtydaysrentchange, TextView.BufferType.EDITABLE);
	    		
	        	String alltimerentlow = res.getString("rzvaluationrangeLow");
	        	String alltimerenthigh= res.getString("rzvaluationrangeHigh");
	        	TextView tv17 = (TextView)findViewById(R.id.alltimerentlowhigh);
	    		tv17.setText(alltimerentlow+" - "+alltimerenthigh, TextView.BufferType.EDITABLE);
	    		
	        
//	    		&copy Zillow, Inc., 2006-2014. Use is subject to <a href='http://www.zillow.com/corp/Terms.htm'>Terms of Use</a><br><a href='http://www.zillow.com/zestimate/'>What's a Zestimate?</a></b></div>";
	    		
	    		String homedetails = res.getString("homeDetails");
	    		String street = res.getString("street");
	    		String city = res.getString("city");
	    		String state = res.getString("state");
	    		String zip = res.getString("zipcode");

	            String header=street+", "+city+", "+state+"-"+zip;
	    		TextView link = (TextView) findViewById(R.id.row2);
	    		String linkText = "<a href='"+homedetails+"'>"+header+"</a>";
	    		link.setText(Html.fromHtml(linkText));
	    		link.setClickable(true);
	    		link.setMovementMethod (LinkMovementMethod.getInstance());
	    		TextView link1 = (TextView) findViewById(R.id.zillow_tnc2);
	    		String linkText1 = "Use is subject to <a href=http://www.zillow.com/wikipages/Privacy-and-Terms-of-Use/>Terms of Use</a>";
	    		link1.setText(Html.fromHtml(linkText1));
	    		link1.setClickable(true);
	    		link1.setMovementMethod (LinkMovementMethod.getInstance());
	    		TextView link2 = (TextView) findViewById(R.id.zillow_tnc3);
	    		String linkText2 = "<a href=http://www.zillow.com/zestimate/>What's a Zestimate?</a>";
	    		link2.setText(Html.fromHtml(linkText2));
	    		link2.setClickable(true);
	    		link2.setMovementMethod (LinkMovementMethod.getInstance());


	    		
	    		

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
    	
            
//            TextView  tv=new TextView(this);
//            tv.setTextSize(25);
//            tv.setGravity(Gravity.CENTER_VERTICAL);
//            tv.setText("This Is Tab1 Activity");
//            
//            setContentView(tv);
        }
}