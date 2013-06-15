package com.example.progressdialogexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.ProgressDialog;
 
public class MainActivity extends Activity implements OnClickListener {
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        // set a click listener on the toast button
        Button toast = (Button) findViewById(R.id.toastbtn);
        toast.setOnClickListener(this);
             
        // set a click listener on the alert button
        Button alert = (Button) findViewById(R.id.alertbtn);
        alert.setOnClickListener(this);
         
        // set a click listener on the yesno button
        Button yesno = (Button) findViewById(R.id.yesnobtn);
        yesno.setOnClickListener(this);
         
        // set a click listener on the progress button
        Button progress = (Button) findViewById(R.id.progressbtn);
        progress.setOnClickListener(this);       
    }
     
        
    public void onClick(View view) {
        // which button is clicked?
         
        // the Toast button
        if (view == findViewById(R.id.toastbtn)) {
            // display the toast popup window
            Toast.makeText(this, "This is the Toast message", Toast.LENGTH_LONG).show();
        }
 
        // the Alert button the activated
        if (view == findViewById(R.id.alertbtn)) {
         
            // prepare the alert box                  
            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
             
            // set the message to display
            alertbox.setMessage("This is the alertbox!");
             
            // add a neutral button to the alert box and assign a click listener
            alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                 
                // click listener on the alert box
                public void onClick(DialogInterface arg0, int arg1) {
                    // the button was clicked
                    Toast.makeText(getApplicationContext(), "OK button clicked", Toast.LENGTH_LONG).show();
                }
            });
             
            // show it
            alertbox.show();
        }
         
        // the yesno button is clicked
        if (view == findViewById(R.id.yesnobtn)) {       
            // prepare the alert box                  
            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
             
            // set the message to display
            alertbox.setMessage("This is the alertbox!");
                     
            // set a positive/yes button and create a listener                   
            alertbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                 
                // do something when the button is clicked
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(getApplicationContext(), "'Yes' button clicked", Toast.LENGTH_SHORT).show();
                }
            });
             
            // set a negative/no button and create a listener
            alertbox.setNegativeButton("No", new DialogInterface.OnClickListener() {
 
                // do something when the button is clicked               
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(getApplicationContext(), "'No' button clicked", Toast.LENGTH_SHORT).show();
                }
            });
             
            // display box
            alertbox.show();
        }
  
        // progress button clicked
        if (view == findViewById(R.id.progressbtn)) {
            // prepare the dialog box
            ProgressDialog dialog = new ProgressDialog(this);
            dialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
            // make the progress bar cancelable
            dialog.setCancelable(true);
             
            // set a message text
            dialog.setMessage("Loading...");
            dialog.getWindow ().setBackgroundDrawableResource(R.drawable.ic_launcher);
            // show it
            dialog.show();
        }
         
    }
}