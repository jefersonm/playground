package com.ilegra.horas.db;

import java.util.ArrayList;
import java.util.List;

import com.ilegra.horas.pojo.Atividade;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {

	public void saveData(Context context, String data, String desc){
		DbHelper dbHelper = new DbHelper(context);
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put("data", data);
		cv.put("desc", desc);
		database.insert("hora", null, cv);
		dbHelper.close();
	}
	
	public List<Atividade> readData(Context context){
		List<Atividade> list = new ArrayList<Atividade>();
		DbHelper dbHelper = new DbHelper(context);
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		Cursor cursor = database.query("hora", new String[]{"data","desc"}, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			list.add(new Atividade(cursor.getString(0), cursor.getString(1)));
			cursor.moveToNext();
		}
		
		return list;
	}
	
}
