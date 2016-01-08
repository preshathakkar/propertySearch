package com.example.myfirstapp;



import java.io.InputStream;



import org.json.JSONObject;



import android.app.Activity;

import android.app.Dialog;

import android.content.Intent;

import android.graphics.Bitmap;

import android.graphics.BitmapFactory;

import android.graphics.Typeface;

import android.os.AsyncTask;

import android.os.Bundle;

import android.text.Html;

import android.util.Log;

import android.view.Gravity;

import android.view.View;

import android.view.ViewGroup;

import android.view.ViewGroup.LayoutParams;

import android.widget.Button;

import android.widget.ImageView;

import android.widget.LinearLayout;

import android.widget.TextView;



public class Tab2Activity extends Activity

{

	private String url1, url5, url10;

	LinearLayout ll;

	TextView header, subheader, footer1, footer2, footer3;

	String results;

	ImageView image;

	int activeUrl;

	@Override

	public void onCreate(Bundle savedInstanceState)

	{

		super.onCreate(savedInstanceState);



		Intent intent = getIntent();

		String text = intent.getStringExtra("CHART");

		try{

			JSONObject data = new JSONObject(text);
			//System.out.println("Hello");

			JSONObject resultsData = data;
			JSONObject res = data;


			//System.out.println("Hey");

			JSONObject url1Obj = resultsData.getJSONObject("ch1yr");
			//System.out.println("Ho");

			JSONObject url5Obj = resultsData.getJSONObject("ch5yr");
			//System.out.println("Blah");

			JSONObject url10Obj = resultsData.getJSONObject("ch10yr");
			//System.out.println("Blum");



			url1 = url1Obj.getString("0");

			url5 = url5Obj.getString("0");

			url10 = url10Obj.getString("0");

			activeUrl = 1;



			ll = new LinearLayout(this);

			ll.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));

			ll.setGravity(Gravity.CENTER_HORIZONTAL);

			ll.setOrientation(1);



			header = new TextView(Tab2Activity.this);

			header.setText("Historical Zestimate for the past 1 year");

			header.setGravity(Gravity.CENTER_HORIZONTAL);

			header.setTextSize(20);

			header.setTypeface(null, Typeface.BOLD);



			subheader = new TextView(Tab2Activity.this);

			subheader.setText(res.getString("street")+", "+res.getString("city")+", "+res.getString("state")+"-"+res.getString("zipcode"));

			subheader.setGravity(Gravity.CENTER_HORIZONTAL);

			subheader.setTextSize(15);



			image = new ImageView(Tab2Activity.this);



			LinearLayout llinner = new LinearLayout(this);

			llinner.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));

			llinner.setGravity(Gravity.CENTER_HORIZONTAL);

			llinner.setOrientation(LinearLayout.HORIZONTAL);



			Button prev = new Button(Tab2Activity.this);

			prev.setText(R.string.prev);

			prev.setGravity(Gravity.CENTER_HORIZONTAL);

			prev.setLayoutParams(new LayoutParams(

					ViewGroup.LayoutParams.WRAP_CONTENT,

					ViewGroup.LayoutParams.WRAP_CONTENT));

			prev.setOnClickListener(new View.OnClickListener() {

				@Override

				public void onClick(View view) {

					if(activeUrl == 5){

						activeUrl = 1;

						header.setText("Historical Zestimate for the past 1 year");

						new ImageDownloader(image).execute(url1);

					}

					else if(activeUrl == 10){

						activeUrl = 5;

						header.setText("Historical Zestimate for the past 5 years");

						new ImageDownloader(image).execute(url5);

					}

				}

			});



			Button next = new Button(Tab2Activity.this);

			next.setText(R.string.next);

			next.setGravity(Gravity.CENTER_HORIZONTAL);

			next.setLayoutParams(new LayoutParams(

					ViewGroup.LayoutParams.WRAP_CONTENT,

					ViewGroup.LayoutParams.WRAP_CONTENT));

			next.setOnClickListener(new View.OnClickListener() {

				@Override

				public void onClick(View view) {

					if(activeUrl == 1){

						activeUrl = 5;

						header.setText("Historical Zestimate for the past 5 years");

						new ImageDownloader(image).execute(url5);

					}

					else if(activeUrl == 5){

						activeUrl = 10;

						header.setText("Historical Zestimate for the past 10 years");

						new ImageDownloader(image).execute(url10);

					}

				}

			});



			footer1 = new TextView(Tab2Activity.this);

			footer1.setText("\u00A9 Zillow, Inc., 2006-2014");

			footer1.setGravity(Gravity.CENTER_HORIZONTAL);



			footer2 = new TextView(Tab2Activity.this);

			footer2.setText(Html.fromHtml("Use is subject to <a href='http://www.zillow.com/corp/Terms.htm'>Terms of Use</a>"));

			footer2.setGravity(Gravity.CENTER_HORIZONTAL);



			footer3 = new TextView(Tab2Activity.this);

			footer3.setText(Html.fromHtml("<a href='http://www.zillow.com/zestimate/'>What's a Zestimate?</a>"));

			footer3.setGravity(Gravity.CENTER_HORIZONTAL);



			llinner.addView(prev);

			llinner.addView(next);

			ll.addView(header);

			ll.addView(subheader);

			ll.addView(image);

			ll.addView(llinner);

			ll.addView(footer1);

			ll.addView(footer2);

			ll.addView(footer3);

			setContentView(ll);



			new ImageDownloader(image).execute(url1);



		}

		catch(Exception e){

			e.printStackTrace();

		}



		//            TextView  tv=new TextView(this);

		//            tv.setText(text);

		//            

		//            setContentView(tv);

	}



	private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

		ImageView bmImage;



		public ImageDownloader(ImageView bmImage) {

			image = bmImage;

		}



		protected Bitmap doInBackground(String... urls) {

			String url = urls[0];

			Bitmap mIcon = null;

			try {

				InputStream in = new java.net.URL(url).openStream();

				mIcon = BitmapFactory.decodeStream(in);

			} catch (Exception e) {

				Log.e("Error", e.getMessage());

			}

			return mIcon;

		}



		protected void onPostExecute(Bitmap result) {
			result=Bitmap.createScaledBitmap(result,900,600, true);
			image.setImageBitmap(result);
			

		}

	}

}