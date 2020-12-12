package com.example.androidtasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androidtasks.dataBase.AppDatabase;
import com.example.androidtasks.dataBase.EmplyeeAndDepartment;
import com.example.androidtasks.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    AppDatabase appDatabase;
    ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_details);
        appDatabase = AppDatabase.getInstance(this);
        int id = getIntent().getIntExtra("ID",0);
       EmplyeeAndDepartment employeeData =  appDatabase.employeeDao().getEmployeeData(id);
       binding.name.setText(employeeData.employee.getEmployeeName());
       binding.email.setText(employeeData.employee.getEmployeeEmail());
       binding.phone.setText(employeeData.employee.getEmployeePhone());
       binding.title.setText(employeeData.employee.getEmployeeTitle());
       binding.department.setText(employeeData.department.getDepartmentName());


    }
}