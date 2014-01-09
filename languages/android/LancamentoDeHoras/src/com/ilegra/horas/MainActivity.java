package com.ilegra.horas;

import com.ilegra.horas.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
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
					Toast.makeText(getApplicationContext(), "Nome e senha obrigat??rio!",  Toast.LENGTH_LONG).show();
					return;
				}

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
   
    
}
