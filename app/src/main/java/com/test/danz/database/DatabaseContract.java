package com.test.danz.database;

import android.provider.BaseColumns;

public class DatabaseContract {

    public static final String TABLE_NAME = "CURRENCY";
    public static final String KEY_NUM_CODE = "NUM_CODE";
    public static final String KEY_CHAR_CODE = "CHAR_CODE";
    public static final String KEY_NOMINAL = "NOMINAL";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_ID = "ID";
    public static final String KEY_VALUE = "VALUE";

    public final static String CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT, %s REAL) ", TABLE_NAME, BaseColumns._ID,
            KEY_NUM_CODE, KEY_CHAR_CODE, KEY_NOMINAL, KEY_NAME, KEY_ID, KEY_VALUE);


}
