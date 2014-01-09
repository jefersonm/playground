package com.example.lancamentodehoras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

		String nome = getIntent().getStringExtra("nome");
		String senha = getIntent().getStringExtra("senha");
		
		TextView textview = (TextView)findViewById(R.id.nome); 
		textview.setText("Bem vindo: "+nome);
		
		TextView textview1 = (TextView)findViewById(R.id.senha); 
		textview1.setText("O total de horas no mês é de: "+((senha==null)?"0":senha.length()));
		
	       findViewById(R.id.addAtividade).setOnClickListener(new Button.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(getApplicationContext(), LancamentoActivity.class);
					startActivity(intent);
					
				}
			});

	}
	
	
}
