package com.ilegra.horas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private int countPause = 0;
	private int countStart = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.main_salvar_btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText name = (EditText) findViewById(R.id.main_name_txt);
				EditText passwd = (EditText) findViewById(R.id.main_password_txt);
				
				toastMessage("Name: " + name.getText() +" , Passwd: " +passwd.getText());
				
				toastMessage("Name: " + name.getText());
				toastMessage("Passwd: " + passwd.getText());
			}
		});
	}
	
	@Override
	protected void onPause() {
		toastMessage("PAUSED", countPause++);
		
		Log.d("PAUSED", "App paused, nr: " + countPause);
		super.onPause();
	}

	@Override
	protected void onStart() {
		toastMessage("STARTED", countStart++);
		
		Log.d("STARTED", "App started, nr: " + countStart);
		super.onStart();
	}
	
	private void toastMessage(String message, int count){
		CharSequence text = "APP " + message +", NR: " + count;
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	private void toastMessage(String message){
		Context context = getApplicationContext();
		CharSequence text = message;
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
