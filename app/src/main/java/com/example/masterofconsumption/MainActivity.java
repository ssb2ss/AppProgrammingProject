package com.example.masterofconsumption;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton uploadButton;
    Button setItemButton, button_CE, button_C, button_backspace, button_equals, button_plus, button_minus, button_multiply, button_divide;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_00, button_dot;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadButton = findViewById(R.id.uploadButton);
        setItemButton = findViewById(R.id.setItemButton);

        button_CE = findViewById(R.id.button_CE);
        button_C = findViewById(R.id.button_C);
        button_backspace = findViewById(R.id.button_backspace);
        button_equals = findViewById(R.id.button_equals);
        button_plus = findViewById(R.id.button_plus);
        button_minus = findViewById(R.id.button_minus);
        button_multiply = findViewById(R.id.button_multiply);
        button_divide = findViewById(R.id.button_divide);

        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_00 = findViewById(R.id.button_00);
        button_dot = findViewById(R.id.button_dot);

        answer = findViewById(R.id.answer);

        uploadButton.setOnClickListener(this);
        setItemButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == uploadButton){
            ChangeActivity(UploadItemActivity.class);
        }
        else if(v == setItemButton){
            ChangeActivity(SetItemActivity.class);
        }
    }

    private void ChangeActivity(Class activity){
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);

        finish();
    }
}
