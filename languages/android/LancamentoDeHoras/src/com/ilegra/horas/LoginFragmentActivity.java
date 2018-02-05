package com.ilegra.horas;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragmentActivity extends Fragment {
	
	private FileOutputStream fos;
	private String logErro = "";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return (ViewGroup) inflater.inflate(R.layout.activity_fragment_login, container, false);
	}
	
	@Override
	public void onStart() {
		SharedPreferences settings = getActivity().getPreferences(Context.MODE_PRIVATE);
		EditText nome = (EditText) getView().findViewById(R.id.editText2);
		EditText senha = (EditText) getView().findViewById(R.id.editText1);
		
		saveToInternalDb();
		
		nome.setText(settings.getString("nome", null));
		senha.setText(settings.getString("senha", null));
		
		super.onStart();
		super.onStart();
	}

    private void saveToInternalDb(){
    	String FILENAME = "internal_db";
		try {
			FileOutputStream fos = getActivity().openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write("jeferson,123".getBytes());
	    	fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		getView().findViewById(R.id.login_btn).setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText nome = (EditText) getView().findViewById(R.id.editText2);
				EditText senha = (EditText) getView().findViewById(R.id.editText1);
				
				if(nome.getText().toString().isEmpty() || senha.getText().toString().isEmpty()){
					Toast.makeText(getActivity().getApplicationContext(), "Nome e senha obrigatório!",  Toast.LENGTH_LONG).show();
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
				
				SharedPreferences settings = getActivity().getPreferences(Context.MODE_PRIVATE);
				settings.edit()
					.putString("nome", nome.getText().toString())
					.putString("senha", senha.getText().toString())
					.commit();
				
				Intent intent = new Intent(getActivity().getApplicationContext(), WelcomeActivity.class);
				intent.putExtra("nome", ""+nome.getText());
				intent.putExtra("senha", ""+senha.getText());
				startActivity(intent);
				
			}
		});
		
		super.onActivityCreated(savedInstanceState);
	}
	
	private void mostraErros(){
    	String FILENAME = "log_db";
    	FileInputStream fis;
    	String erro = "";
		try {
			fis = getActivity().openFileInput(FILENAME);
			int content;
			while ((content = fis.read()) != -1) {
				erro += (char) content;
			}
			Toast.makeText(getActivity().getApplicationContext(), "Erros do log:"+erro,  Toast.LENGTH_LONG).show();
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
				fos = getActivity().openFileOutput(FILENAME, Context.MODE_PRIVATE);	
			
			fos.write(logErro.getBytes());
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
			fis = getActivity().openFileInput(FILENAME);
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

}
