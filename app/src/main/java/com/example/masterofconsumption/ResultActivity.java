package com.example.masterofconsumption;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ResultActivity extends AppCompatActivity {

    BackButtonCloseHandler backButtonCloseHandler;


    Button applyButton;
    ListView listView;
    String[] datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        backButtonCloseHandler = new BackButtonCloseHandler(this);

        applyButton = findViewById(R.id.applyButton);
        listView = findViewById(R.id.listView);


        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from upload_db", null);



        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backButtonCloseHandler.OnPressedBackButton();
    }
}
