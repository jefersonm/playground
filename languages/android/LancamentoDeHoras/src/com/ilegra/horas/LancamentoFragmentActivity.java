package com.ilegra.horas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ilegra.horas.db.UserDAO;

public class LancamentoFragmentActivity extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return (ViewGroup) inflater.inflate(R.layout.activity_fragment_lancamento, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		getView().findViewById(R.id.saveButton).setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText data = (EditText) getView().findViewById(R.id.editText1);
				EditText desc = (EditText) getView().findViewById(R.id.editText2);
				
				if(data.getText().toString().isEmpty() || desc.getText().toString().isEmpty()){
					Toast.makeText(getActivity().getApplicationContext(), "Data e descrição obrigatórios!",  Toast.LENGTH_LONG).show();
					return;
				}

				UserDAO dao = new UserDAO();
				dao.saveData(getActivity().getBaseContext(), data.getText().toString(), desc.getText().toString());
				
				getActivity().finish();	
			}
		});
		
		super.onActivityCreated(savedInstanceState);
	}
	
}
