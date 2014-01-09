package com.example.lancamentodehoras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
//	private int onDestroy;
//	private int onStart;
//	private int onStop;
//	private int onPause;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.button1).setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText nome = (EditText) findViewById(R.id.editText1);
				EditText senha = (EditText) findViewById(R.id.editText2);
				
				if(nome.getText().toString().isEmpty() || senha.getText().toString().isEmpty()){
					Toast.makeText(getApplicationContext(), "Nome e senha obrigat—rio!",  Toast.LENGTH_LONG).show();
					return;
				}
//				Toast.makeText(getApplicationContext(), "Nome: "+nome.getText() + " Senha: "+senha.getText(),
//			  			   Toast.LENGTH_LONG).show();
				Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
				intent.putExtra("nome", ""+nome.getText());
				intent.putExtra("senha", ""+senha.getText());
				startActivity(intent);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
//    @Override
//    protected void onStart() {
//    	super.onStart();
//    	onStart +=1;
//    	Toast.makeText(getApplicationContext(), "onStart: "+onStart,
//  			   Toast.LENGTH_LONG).show();
//    }
//    
//    @Override
//    protected void onStop() {
//    	super.onStop();
//    	onStop +=1;
//    	Toast.makeText(getApplicationContext(), "onStop: "+onStop,
//  			   Toast.LENGTH_LONG).show();
//    }
//    
//    @Override
//    protected void onDestroy() {
//    	super.onDestroy();
//    	onDestroy +=1;
//    	Toast.makeText(getApplicationContext(), "onDestroy: "+onDestroy,
// 			   Toast.LENGTH_LONG).show();
//    }
//    
//    @Override
//    protected void onPause() {
//    	super.onPause();
//    	onPause +=1;
//    	Toast.makeText(getApplicationContext(), "onPause: "+onPause,
//    			   Toast.LENGTH_LONG).show();
//    }
}
