package zw.co.noityu.notifyu.database;


import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by Munyaradzi Mafi
 */
public class DbTable {
    public DbTable() {
    }

    /* Inner class that defines the table contents */
    public static abstract class USERENTRY implements BaseColumns{
        public static final String TABLE_NAME = "USER";
        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String FIRSTNAME = "FIRSTNAME";
        public static final String LASTNAME = "LASTNAME";
        public static final String USERID = "USERID";
        public static final String SCHOOLID = "SCHOOLID";
        public static final String SCHOOLNAME = "SCHOOLNAME";
        public static final String GENDER = "GENDER";

    }

    /* Inner class that defines the table contents */
    public static abstract class NOTIFICATIONENTRY implements BaseColumns{
        public static final String TABLE_NAME = "NOTIFICATION";
        public static final String CATEGORY = "CATEGORY";
        public static final String HEADER = "HEADER";
        public static final String MESSAGE = "MESSAGE";
        public static final String DATERECEIVED = "DATERECEIVED";
    }

    /* Inner class that defines the table contents */
    public static abstract class CLASSIFIEDSENTRY implements BaseColumns{
        public static final String TABLE_NAME = "CLASSIFIEDS";
        public static final String UPLOADER = "UPLOADER";
        public static final String PRICE = "PRICE";
        public static final String IMAGE = "IMAGE";
        public static final String CATEGORY = "CATEGORY";
        public static final String DECSRIPTION = "DECSRIPTION";
        public static final String CONTACT = "CONTACT";
        public static final String EMAIL = "EMAIL";
    }

}
