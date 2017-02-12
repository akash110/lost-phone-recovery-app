package com.example.lostphoneapp;
//importing the important libraries
import com.example.settext.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity1 extends Activity {
  //variable declaration
	Button button1;
	String specifictext;
	static MainActivity1 INSTANCE;
     TextView textview1;
     final Context context = this;
    
  @Override
    protected void onCreate(Bundle savedInstanceState) {
    	INSTANCE=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //to take data from previous activity(i.e. activity_main)
        SharedPreferences sharedPref= getSharedPreferences("mypref",MODE_PRIVATE);
         Intent intent = getIntent();
         //fetch the data 
        specifictext = intent.getStringExtra("new_var");
        
        button1=(Button)findViewById(R.id.button1);
        textview1=(TextView)findViewById(R.id.textView1);
        textview1.setText("HELLO USER !YOUR LOCATION TRACING TEXT IS "+specifictext);   
     
        button1.setOnClickListener(new OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				 Intent i = new Intent(MainActivity1.this,MainActivity2.class);
             // Intent intent = new Intent(context, MainActivity1.class);
                startActivity(i);  
			}
		});
        
       
}
 
  public String getData()
    {
      return this.specifictext;
    }
public static MainActivity1 getActivityInstance() {
	// TODO Auto-generated method stub
	return INSTANCE;
}  
}   
