package com.example.masterofconsumption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ResultActivity extends AppCompatActivity {

    Button applyButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        applyButton = findViewById(R.id.applyButton);
        listView = findViewById(R.id.listView);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //확인 버튼 눌렀을때
            }
        });
    }
}
