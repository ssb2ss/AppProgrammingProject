package com.example.masterofconsumption;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SetItemActivity extends AppCompatActivity implements View.OnClickListener {

    BackButtonCloseHandler backButtonCloseHandler;

    ImageButton backButton;
    Button applyButton;
    ExpandableListView listView;

    ArrayList<ListViewSetItemKind> kindArrayList;
    ArrayList<ListViewSetItem>[] itemArrayList;

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

        kindArrayList = new ArrayList<>();
        itemArrayList = new ArrayList[4];

        initKindArrayList();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from uploaditem";

        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            if(cursor.getString(0) == "음식"){
                itemArrayList[0].add(new ListViewSetItem(name, price));
                setImageViewBitmap(image, itemArrayList[0].get(itemArrayList[0].size() - 1).image);
            }
            else if(cursor.getString(0) == "생활용품"){
                itemArrayList[1].add(new ListViewSetItem(name, price));
                setImageViewBitmap(image, itemArrayList[1].get(itemArrayList[1].size() - 1).image);
            }
            else if(cursor.getString(0) == "문화"){
                itemArrayList[2].add(new ListViewSetItem(name, price));
                setImageViewBitmap(image, itemArrayList[2].get(itemArrayList[2].size() - 1).image);
            }
            else if(cursor.getString(0) == "생활용품"){
                itemArrayList[3].add(new ListViewSetItem(name, price));
                setImageViewBitmap(image, itemArrayList[3].get(itemArrayList[3].size() - 1).image);
            }
        }
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

    public void setImageViewBitmap(byte[] imageByte, ImageView imageView){
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length));
    }

    private void initKindArrayList(){
        kindArrayList.add(new ListViewSetItemKind("음식", itemArrayList[0]));
        kindArrayList.add(new ListViewSetItemKind("생활용품", itemArrayList[1]));
        kindArrayList.add(new ListViewSetItemKind("문화", itemArrayList[2]));
        kindArrayList.add(new ListViewSetItemKind("기타", itemArrayList[3]));
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backButtonCloseHandler.OnPressedBackButton();
    }
}
