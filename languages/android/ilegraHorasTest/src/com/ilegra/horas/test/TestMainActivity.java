package com.ilegra.horas.test;

import junit.framework.Assert;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.ilegra.horas.LoginFragmentActivity;
import com.ilegra.horas.MainActivity;

public class TestMainActivity extends ActivityInstrumentationTestCase2<MainActivity> {

	public TestMainActivity(){
		super(MainActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
	}

	public void testLoginFragmentACreated(){
		LoginFragmentActivity fragment = (LoginFragmentActivity) getActivity().getSupportFragmentManager().findFragmentByTag("loginFragment");
		Assert.assertNotNull("Deveria existir um login, não ?", fragment);
	}

	public void testLoginFragmentButton() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				EditText name = (EditText) getActivity().findViewById(com.ilegra.horas.R.id.editText2);
				EditText password = (EditText) getActivity().findViewById(com.ilegra.horas.R.id.editText1);
				name.setText("jeferson");
				password.setText("123");

				Button b = (Button) getActivity().findViewById(com.ilegra.horas.R.id.login_btn);
				b.performClick();
			}
		});

		MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 1000);
		Assert.assertNotNull("Erro ao passar da página de login para ", nextActivity);
	}

}
