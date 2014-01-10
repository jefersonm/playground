package com.ilegra.horas;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private FileOutputStream fos;
	private String logErro = "";
	
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
					Toast.makeText(getApplicationContext(), "Nome e senha obrigatório!",  Toast.LENGTH_LONG).show();
					return;
				}
		    	
		    	String[] db = getFromInternalDb();
				String nomeDB = db[0];
				String senhaDB = db[1];
				
				if(!nome.getText().toString().equals(nomeDB) || !senha.getText().toString().equals(senhaDB)){
					logaErros("Usuario e senha invalidos!");
					mostraErros();
					return;
				}
				
				SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
				settings.edit()
					.putString("nome", nome.getText().toString())
					.putString("senha", senha.getText().toString())
					.commit();
				
				Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
				intent.putExtra("nome", ""+nome.getText());
				intent.putExtra("senha", ""+senha.getText());
				startActivity(intent);
				
			}
		});
    }
    
    private void mostraErros(){
    	String FILENAME = "log_db";
    	FileInputStream fis;
    	String erro = "";
		try {
			fis = openFileInput(FILENAME);
			int content;
			while ((content = fis.read()) != -1) {
				erro += (char) content;
			}
			Toast.makeText(getApplicationContext(), "Erros do log:"+erro,  Toast.LENGTH_LONG).show();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void logaErros(String erro){
    	String FILENAME = "log_db";
		try {
			logErro = erro + "\n";
			if(fos == null)
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);	
			
			fos.write(logErro.getBytes());
	    	fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    
    private void saveToInternalDb(){
    	String FILENAME = "internal_db";
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write("jeferson,123".getBytes());
	    	fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private String[] getFromInternalDb(){
    	String FILENAME = "internal_db";
    	String retorno = "";
    	
    	FileInputStream fis;
		try {
			fis = openFileInput(FILENAME);
			int content;
			while ((content = fis.read()) != -1) {
				retorno += (char) content;
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno.split(",");
    }

    @Override
	protected void onStart() {
    	SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
		EditText nome = (EditText) findViewById(R.id.editText1);
		EditText senha = (EditText) findViewById(R.id.editText2);
		
		saveToInternalDb();
		
		nome.setText(settings.getString("nome", null));
		senha.setText(settings.getString("senha", null));
		
		super.onStart();
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
