package com.example.androidtasks.dataBase;

import android.widget.ListView;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.androidtasks.model.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertEmployee(Employee employee);
    @Query("select * from Employee where employeeName like '%' || :name || '%'")
    public List<Employee>getEmployees(String name);
    @Transaction
    @Query("select * from Employee where employeeId =:id")
    public EmplyeeAndDepartment getEmployeeData(int id);
}
