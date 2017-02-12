//Listen to incoming messages 

package com.example.lostphoneapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class Receivesms extends BroadcastReceiver{
	          static String body;
	          static String phoneno;
	          String specifictext;
	          GPSTracker gps;
	          String stringdouble1="";
	          String stringdouble2="";
	@Override
	 public void onReceive(Context context, Intent intent) {
		//receive the data from the first screen 
		specifictext=MainActivity1.getActivityInstance().getData();  
	   
		Bundle bundle = intent.getExtras();
	         SmsMessage[] msgs = null;
	         String str = "";    
	         if (bundle != null)
	         {
	             Object[] pdus = (Object[]) bundle.get("pdus");
	             msgs = new SmsMessage[pdus.length];         
	             for (int i=0; i<msgs.length; i++){
	                 msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);             
	                 str += "SMS from " + msgs[i].getOriginatingAddress();                   
	                 str += " :";
	                 str += msgs[i].getMessageBody().toString();
	                 str += "\n";     
	               phoneno=msgs[i].getOriginatingAddress();
	                body=msgs[i].getMessageBody().toString();
	             }
	             String body1=body.trim();
	             String specifictext2=specifictext.trim();
	            // Toast.makeText(context,body +"---"+ phoneno, Toast.LENGTH_SHORT).show();
	         if(body1.contains(specifictext2)){
	      //if body text contains the specifictext then enable internet connection  
	        	 Internetenable.EnableInternet(context);
	       //enable GPS 
	       gps = new GPSTracker(context);
			
	       if(gps.canGetLocation()) {
	    	   //GPS is enable and fetch the location 
				double latitude = gps.getLatitude();
				double longitude = gps.getLongitude();   
				 stringdouble1= Double.toString(latitude);
				 stringdouble2= Double.toString(longitude);
			} else {
				//GPS is disable then enable the GPS
				Intent i=new Intent("android.location.GPS_ENABLED_CHANGE");
				intent.putExtra("enabled", true);
				context.sendBroadcast(i);
				//fetch the location 
				 double latitude = gps.getLatitude();
				 double longitude = gps.getLongitude();
				 stringdouble1= Double.toString(latitude);
			     stringdouble2= Double.toString(longitude);
			}
	      Toast.makeText(context,"latitute"+stringdouble1+"\n"+"longitute"+stringdouble2, Toast.LENGTH_SHORT).show();
	    SmsManager smsManager = SmsManager.getDefault();
	    smsManager.sendTextMessage(phoneno, null,"latitute"+stringdouble1+"\n"+"longitute"+stringdouble2, null, null);
	
	         }
	      }         
	  
	 }

}
