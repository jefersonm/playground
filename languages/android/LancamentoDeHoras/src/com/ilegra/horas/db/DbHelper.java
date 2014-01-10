package com.ilegra.horas.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	private static final String DATABASE_NAME = "horas.db";
	private static final int DATABASE_VERSION = 7;
	private static final String SQL_CACHE_TABLE = "CREATE TABLE IF NOT EXISTS HORA (DATA VARCHAR, DESC VARCHAR)";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CACHE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS HORA");
		onCreate(db);
	}

}
