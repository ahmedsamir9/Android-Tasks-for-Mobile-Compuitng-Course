package com.example.androidtasks.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidtasks.R;
import com.example.androidtasks.databinding.ActivityMainBinding;
import com.example.androidtasks.model.Coins;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private Coins coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        coins = new Coins();
        binding.clearBtn.setOnClickListener(this);
        binding.convertBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clear_btn:
                clear();
                break;

            case R.id.convert_btn:
                converter();
                break;
            default:
                break;
        }
    }

    private void converter() {
        String dollarString = binding.usEt.getText().toString();
        String poundString = binding.egEt.getText().toString();
        float dollars, pounds;
        if (!dollarString.equals("")) {
            try {
                dollars = Float.parseFloat(dollarString);
                coins.setNumberOfCoins(dollars);
                pounds = coins.convertFromUSToEgyptian();
                binding.egEt.setText(String.valueOf(pounds));
                return;
            } catch (NumberFormatException e) {
                Toast.makeText(this, "invalided Operation", Toast.LENGTH_LONG).show();

                clear();
            }

        }
        if (!poundString.equals("")) {
            try {
                pounds = Float.parseFloat(poundString);
                coins.setNumberOfCoins(pounds);
                dollars = coins.convertFromEgyptianToUS();
                binding.usEt.setText(String.valueOf(dollars));
                return;
            }catch (NumberFormatException e) {
                Toast.makeText(this, "invalided Operation", Toast.LENGTH_LONG).show();
                clear();
            }

        } else
            Toast.makeText(this, "invalided Operation", Toast.LENGTH_LONG).show();
    }

    private void clear() {
        binding.usEt.setText("");
        binding.egEt.setText("");
        return;
    }

}