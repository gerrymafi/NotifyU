package zw.co.noityu.notifyu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import zw.co.noityu.notifyu.database.DbTable.*;
import zw.co.noityu.notifyu.database.DbTask;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "notify.db";
    public final static int MINUTES_TO_LOGOUT = 120;
    public final static int MAX_LOGIN_ATTEMPTS = 5;
    private static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String DATA_TYPE = " DATA";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_USER_ENTRIES =
            "CREATE TABLE " + USERENTRY.TABLE_NAME + " (" +
                    USERENTRY._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    USERENTRY.USERNAME + TEXT_TYPE + " UNIQUE " + COMMA_SEP +
                    USERENTRY.PASSWORD + TEXT_TYPE + COMMA_SEP +
                    USERENTRY.FIRSTNAME + TEXT_TYPE + COMMA_SEP +
                    USERENTRY.LASTNAME + TEXT_TYPE + COMMA_SEP +
                    USERENTRY.USERID + " INTEGER " + COMMA_SEP +
                    USERENTRY.SCHOOLID + TEXT_TYPE + COMMA_SEP +
                    USERENTRY.SCHOOLNAME + TEXT_TYPE + COMMA_SEP +
                    USERENTRY.GENDER + TEXT_TYPE +
                    " )";

    private static final String SQL_CREATE_NOTIFICATION_ENTRIES =
            "CREATE TABLE " + NOTIFICATIONENTRY.TABLE_NAME + " (" +
                    NOTIFICATIONENTRY._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    NOTIFICATIONENTRY.CATEGORY + TEXT_TYPE + " UNIQUE " + COMMA_SEP +
                    NOTIFICATIONENTRY.HEADER + TEXT_TYPE + COMMA_SEP +
                    NOTIFICATIONENTRY.MESSAGE + TEXT_TYPE + COMMA_SEP +
                    NOTIFICATIONENTRY.DATERECEIVED + " DATE " +
                    " )";

    private static final String SQL_CREATE_CLASSIFIEDS_ENTRIES =
            "CREATE TABLE " + CLASSIFIEDSENTRY.TABLE_NAME + " (" +
                    CLASSIFIEDSENTRY._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    CLASSIFIEDSENTRY.UPLOADER + TEXT_TYPE + COMMA_SEP +
                    CLASSIFIEDSENTRY.PRICE + " DECIMAL " + COMMA_SEP +
                    CLASSIFIEDSENTRY.IMAGE + TEXT_TYPE + COMMA_SEP +
                    CLASSIFIEDSENTRY.CATEGORY + " INTEGER " + COMMA_SEP +
                    CLASSIFIEDSENTRY.DECSRIPTION + TEXT_TYPE + COMMA_SEP +
                    CLASSIFIEDSENTRY.CONTACT + TEXT_TYPE + COMMA_SEP +
                    CLASSIFIEDSENTRY.EMAIL + TEXT_TYPE +
                    " )";



    private static final String SQL_DELETE_USER_ENTRIES =
            "DROP TABLE IF EXISTS " + USERENTRY.TABLE_NAME;
    private static final String SQL_DELETE_NOTIFICTION_ENTRIES =
            "DROP TABLE IF EXISTS " + NOTIFICATIONENTRY.TABLE_NAME;
    private static final String SQL_DELETE_CLASSIFIEDS_ENTRIES =
            "DROP TABLE IF EXISTS " + CLASSIFIEDSENTRY.TABLE_NAME;

   public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_USER_ENTRIES);
        db.execSQL(SQL_DELETE_NOTIFICTION_ENTRIES);
        db.execSQL(SQL_DELETE_CLASSIFIEDS_ENTRIES);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USER_ENTRIES);
        db.execSQL(SQL_CREATE_NOTIFICATION_ENTRIES);
        db.execSQL(SQL_CREATE_CLASSIFIEDS_ENTRIES);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
