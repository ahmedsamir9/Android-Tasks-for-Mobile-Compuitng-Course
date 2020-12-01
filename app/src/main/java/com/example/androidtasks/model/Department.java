package com.example.androidtasks.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Department {
    @PrimaryKey(autoGenerate = true)
    private int departmentId;
    private String departmentName;
}
