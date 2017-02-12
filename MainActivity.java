package com.example.lostphoneapp;

//importing the libraries 
import com.example.settext.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	//variable declaration 
	SharedPreferences prefs = null;
	EditText specifictext;
    Button settext;
    final Context context = this;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //fetching the id if the variables 
        specifictext=(EditText)findViewById(R.id.specifictext);
        settext=(Button)findViewById(R.id.settext);
        //using the preferences for checking the first time visit of the page 
        prefs = getSharedPreferences("mypref", MODE_PRIVATE);
    }
    @Override
    //function 
    protected void onResume() {
        super.onResume();
//if condition to check the first time visit
   if (prefs.getBoolean("firstrun", true)) {
	   //action to performed by clicking on the button.
        	 settext.setOnClickListener(new OnClickListener(){
             	@Override
 			public void onClick(View v) {
 				String result =specifictext.getText().toString();
 				//using shared preferences variable data is stored on device
 				SharedPreferences.Editor editor= prefs.edit();
 		        editor.putString("name",result);
 		        editor.commit();
 		        //fetch the data into name 
 		       String name=prefs.getString("name","");
 				//go the next screen
 			     Intent i = new Intent(MainActivity.this,MainActivity1.class);
 					i.putExtra("new_var",name);
                // Intent intent = new Intent(context, MainActivity1.class);
                   startActivity(i);  
                  }
 	    	 }); 
            prefs.edit().putBoolean("firstrun", false).commit();
	  }else {
        	String name=prefs.getString("name","");
				//go the next screen
			     Intent i = new Intent(MainActivity.this,MainActivity1.class);
					i.putExtra("new_var",name);
            // Intent intent = new Intent(context, MainActivity1.class);
               startActivity(i);  
        }
    }
}
