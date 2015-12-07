package itos.ilawyer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 12/7/2015.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper{
    //Explicit
    private static final String DATABASE_NAME = "MyDB.db";
    private static final int DATABASE_VERION = 1;
    private static final String CREATE_USER_TABLE = "CREATE TABLE USER_TB"
            + "(_id integer primary key, USER TEXT, PASSWORD TEXT, NAME TEXT);";
    // Create TABLE USER on Phone

    public MySQLiteOpenHelper(Context context) {
        super(context , DATABASE_NAME , null , DATABASE_VERION);


    } // Constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    } // Create DATABASE
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}// Main Class
