package com.example.masterofconsumption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class SetItemActivity extends AppCompatActivity implements View.OnClickListener {

    BackButtonCloseHandler backButtonCloseHandler;

    ImageButton backButton;
    Button applyButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_item);

        backButtonCloseHandler = new BackButtonCloseHandler(this);

        backButton = findViewById(R.id.backButton);
        applyButton = findViewById(R.id.applyButton);
        listView = findViewById(R.id.listView);

        backButton.setOnClickListener(this);
        applyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == backButton){
            ChangeActivity(MainActivity.class);
        }
        else if(v == applyButton){
            ChangeActivity(ResultActivity.class);
        }
    }

    private void ChangeActivity(Class activity){
        Intent intent = new Intent(SetItemActivity.this, activity);
        startActivity(intent);

        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backButtonCloseHandler.OnPressedBackButton();
    }
}
