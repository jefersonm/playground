package com.ilegra.horas.util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.EditText;

public class UIUtils {

	public static final String getTextById(Activity a,Integer id){
		return ((EditText)a.findViewById(id)).getText().toString();
	}

	public static void setText(Activity a,Integer textID,String value){
		((EditText)a.findViewById(textID)).setText(value);
	}

//	public static void persistentBehavior(Activity self,Integer fieldID,String prefID){
//		SharedPreferences preferences = PreferencesUtils.getPreferences(self);
//		String uiValue = UIUtils.getTextById(self, fieldID);
//
//		String value = preferences.getString(prefID,"");
//		if (value.equals(""))
//			PreferencesUtils.write(preferences, prefID, uiValue);
//		else
//			UIUtils.setText(self, fieldID, value);
//	}

}