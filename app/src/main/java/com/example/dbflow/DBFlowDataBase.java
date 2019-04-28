package com.example.dbflow;


import android.os.Build;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = DBFlowDataBase.DBName,version = DBFlowDataBase.VERSION)
public class DBFlowDataBase {
    public static final String DBName = "mydb";
    public static final int VERSION = 1;
}
