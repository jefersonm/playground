package com.ilegra.horas;

import com.ilegra.horas.db.UserDAO;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class WelcomeFragmentActivity extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return (ViewGroup) inflater.inflate(R.layout.activity_fragment_welcome, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		UserDAO dao = new UserDAO();
		ListView mDrawerList = (ListView) getActivity().findViewById(R.id.lancamento_listView);
		MenuAdapter adapter = new MenuAdapter(getActivity().getBaseContext(),R.layout.menu_detail, dao.readData(getActivity().getBaseContext()));
		adapter.notifyDataSetChanged();
		mDrawerList.setAdapter(adapter);
		
		super.onActivityCreated(savedInstanceState);
	}
	
}
