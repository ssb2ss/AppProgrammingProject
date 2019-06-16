package com.example.masterofconsumption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class SetItemActivity extends AppCompatActivity implements View.OnClickListener {

    Button backButton, applyButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_item);

        backButton = findViewById(R.id.backButton);
        applyButton = findViewById(R.id.applyButton);
        listView = findViewById(R.id.listView);

        backButton.setOnClickListener(this);
        applyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == backButton){
            //뒤로가기 버튼 눌렀을때
        }
        else if(v == applyButton){
            //확인 버튼 눌렀을때
        }
    }
}
