package com.example.androidtasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.androidtasks.dataBase.AppDatabase;
import com.example.androidtasks.dataBase.DepartmentDao;
import com.example.androidtasks.dataBase.EmployeeDao;
import com.example.androidtasks.databinding.ActivityMainBinding;
import com.example.androidtasks.model.Department;
import com.example.androidtasks.model.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    EmployeeDao employeeDao;
    DepartmentDao departmentDao;
    AppDatabase appDatabase;
    ArrayAdapter adapter;
    List<Employee>employees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_main);
        adapter =new ArrayAdapter(this ,R.layout.item);
        appDatabase = AppDatabase.getInstance(this);
       binding.listView.setAdapter(adapter);
        appDatabase.departmentDao().insertDepartment(new Department("it"));
        appDatabase.departmentDao().insertDepartment(new Department("sales"));
        appDatabase.employeeDao().insertEmployee(new Employee("ahmed ","Asamir","000","S@dd",1));
        appDatabase.employeeDao().insertEmployee(new Employee("mohamed ","Asamir","000","S@dd",1));
        appDatabase.employeeDao().insertEmployee(new Employee("ahmed ","Asr","000","S@dd",1));
        appDatabase.employeeDao().insertEmployee(new Employee("ali ","Asr","000","S@dd",1));
        appDatabase.employeeDao().insertEmployee(new Employee("mohamed ","Asr","000","S@dd",1));


        binding.button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               adapter.clear();
               adapter.notifyDataSetChanged();
               String name =binding.edName.getText().toString();
               Log.d("ahmed",name);
               employees=appDatabase.employeeDao().getEmployees(name);
               for (Employee employeeName :employees){
                   adapter.add(employeeName.getEmployeeName());
               }
           }
       });
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivity.this,DetailsActivity.class);

                intent.putExtra("ID",employees.get(position).getEmployeeId());
                startActivity(intent);
            }
        });
    }
    private void makeToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}