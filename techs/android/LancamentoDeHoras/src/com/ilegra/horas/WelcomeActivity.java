package com.ilegra.horas;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_welcome);

		String nome = getIntent().getStringExtra("nome");
		String senha = getIntent().getStringExtra("senha");

		TextView textview = (TextView) findViewById(R.id.nome);
		textview.setText("Bem vindo: " + nome);

		TextView textview1 = (TextView) findViewById(R.id.senha);
		textview1.setText("O total de horas no mes é de: "
				+ ((senha == null) ? "0" : senha.length()));

		findViewById(R.id.addAtividade).setOnClickListener(
				new Button.OnClickListener() {
					@Override
					public void onClick(View v) {
						//						Intent intent = new Intent(getApplicationContext(), LancamentoActivity.class);
						//						startActivity(intent);

						FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
						transaction.replace(R.id.fragment_welcome_container, new LancamentoFragmentActivity(), "lancamentoFragment");
						transaction.commit();
					}
				});

		//		UserDAO dao = new UserDAO();
		//		ListView mDrawerList = (ListView) findViewById(R.id.lancamento_listView);
		//		MenuAdapter adapter = new MenuAdapter(getBaseContext(),R.layout.menu_detail, dao.readData(getBaseContext()));
		//		adapter.notifyDataSetChanged();
		//		mDrawerList.setAdapter(adapter);

		openLoginFragment();
	}

	private void openLoginFragment(){
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_welcome_container, new WelcomeFragmentActivity(), "welcomeFragment");
		transaction.commit();
	}

}
