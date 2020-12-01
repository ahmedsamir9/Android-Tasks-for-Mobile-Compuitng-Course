package com.example.androidtasks.dataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidtasks.model.Department;
import com.example.androidtasks.model.Employee;

import java.util.List;

@Dao
public interface DepartmentDao {
@Insert
    public void insertDepartment(Department department);

}
