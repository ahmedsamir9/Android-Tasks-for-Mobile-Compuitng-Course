package com.example.androidtasks.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidtasks.model.Department;
import com.example.androidtasks.model.Employee;

@Database(entities = {Employee.class, Department.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    public static AppDatabase getInstance(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"assignmentDb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }
    public abstract EmployeeDao employeeDao();
    public abstract DepartmentDao departmentDao();
}
