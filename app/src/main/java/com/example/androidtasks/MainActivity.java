package com.example.androidtasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.androidtasks.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ActivityMainBinding mainBinding ;
ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

     adapter =new ArrayAdapter(this ,R.layout.item);
    mainBinding.listItemView.setAdapter(adapter);
    mainBinding.addingBtn.setOnClickListener(this);
    mainBinding.listItemView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            String item = (String) adapter.getItem(position);
                adapter.remove(item);
               adapter.notifyDataSetChanged();
               makeToast("Item "+ item+" Deleted");
            return false;
        }
    });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addingBtn) {
            String item = mainBinding.infoEditText.getText().toString();
            adapter.add(item);
            makeToast("Item Added " + item);
            mainBinding.infoEditText.getText().clear();
        }
    }


    private void makeToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}