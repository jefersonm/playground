package com.ilegra.horas;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ilegra.horas.db.UserDAO;

public class LancamentoActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento);
        
	       findViewById(R.id.saveButton).setOnClickListener(new Button.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					EditText data = (EditText) findViewById(R.id.editText1);
					EditText desc = (EditText) findViewById(R.id.editText2);
					
					if(data.getText().toString().isEmpty() || desc.getText().toString().isEmpty()){
						Toast.makeText(getApplicationContext(), "Data e descrição obrigatórios!",  Toast.LENGTH_LONG).show();
						return;
					}

					UserDAO dao = new UserDAO();
					dao.saveData(getBaseContext(), data.getText().toString(), desc.getText().toString());
					
//					MenuAdapter adapter = new MenuAdapter(getApplicationContext(), textViewResourceId, itens)
					
//					Toast.makeText(getApplicationContext(), dao.readData(getBaseContext()), Toast.LENGTH_LONG).show();
					
					finish();	
				}
			});

	}
	
}
