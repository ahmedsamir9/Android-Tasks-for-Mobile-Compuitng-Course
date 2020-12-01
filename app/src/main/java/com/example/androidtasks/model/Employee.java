package com.example.androidtasks.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity(foreignKeys = @ForeignKey(entity = Department.class
,parentColumns = "departmentId",childColumns = "depId",onDelete = ForeignKey.CASCADE))
public class Employee {
    @PrimaryKey(autoGenerate = true)
    private int employeeId;
    @ColumnInfo
    private String employeeName;
    @ColumnInfo
    private String employeeTitle;
    @ColumnInfo
    private String employeePhone;
    @ColumnInfo
    private String employeeEmail;
    private int depId;

    public Employee() {
    }
    @Ignore
    public Employee(String employeeName, String employeeTitle, String employeePhone, String employeeEmail, int depId) {
        this.employeeName = employeeName;
        this.employeeTitle = employeeTitle;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.depId = depId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }
}
