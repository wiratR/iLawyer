package itos.ilawyer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 12/7/2015.
 */
public class UserTABLE {
    // Explicit
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String USER_TABLE = "USER_TB";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USER = "USER";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_NAME = "NAME";

    public UserTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }// Constructor

    public long addNewUser(String strUser,String strPassword,String strName) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER, strUser);
        objContentValues.put(COLUMN_PASSWORD,strPassword);
        objContentValues.put(COLUMN_NAME,strName);
        return readSqLiteDatabase.insert(USER_TABLE, null, objContentValues);
    }/// Add new User

    public String[] searchUserPassword(String strUser){
        try
        {
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(USER_TABLE,new String[]{COLUMN_ID_USER,COLUMN_USER,COLUMN_PASSWORD,COLUMN_NAME},
                    COLUMN_USER + "=?",
                    new String[]{String.valueOf(strUser)},
                    null,null,null,null
                    );
            if(objCursor != null){
                if(objCursor.moveToFirst()){
                    strResult = new String[4];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                }
            }
        }catch (Exception e){
            return null;
        }
        return new String[0];
    }// Functoion SerachUSERPassword



}// Main Class
