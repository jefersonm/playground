package com.example.lancamentodehoras;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

					finish();	
				}
			});

	}
	
}
