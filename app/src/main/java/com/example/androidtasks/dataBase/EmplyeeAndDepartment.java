package com.example.androidtasks.dataBase;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.androidtasks.model.Department;
import com.example.androidtasks.model.Employee;

public class EmplyeeAndDepartment {
    @Embedded
    public Employee employee;
    @Relation(parentColumn = "depId", entityColumn = "departmentId")
    public Department department;

    public EmplyeeAndDepartment() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
