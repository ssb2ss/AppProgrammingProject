package com.example.masterofconsumption;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadItemActivity extends AppCompatActivity implements View.OnClickListener {

    BackButtonCloseHandler backButtonCloseHandler;

    ImageButton backButton;
    Button selectKindButton, selectImageButton, applyButton;
    EditText itemKind, itemName, itemPrice;
    ImageView selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_item);

        backButtonCloseHandler = new BackButtonCloseHandler(this);

        backButton = findViewById(R.id.backButton);
        itemKind = findViewById(R.id.itemKind);
        selectKindButton = findViewById(R.id.selectKindButton);
        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);
        selectedImage = findViewById(R.id.selectedImage);
        selectImageButton = findViewById(R.id.selectImageButton);
        applyButton = findViewById(R.id.applyButton);

        backButton.setOnClickListener(this);
        selectKindButton.setOnClickListener(this);
        selectImageButton.setOnClickListener(this);
        applyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == backButton){
            //뒤로가기 버튼 눌렀을때
            Intent intent = new Intent(UploadItemActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        }
        else if(v == selectKindButton){
            //종류 선택 버튼 눌렀을때

        }
        else if(v == selectImageButton){
            //이미지 검색 버튼 눌렀을때

        }
        else if(v == applyButton){
            //물건 업로드 버튼 눌렀을때
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db =helper.getWritableDatabase();

            String item = itemKind.getText().toString();
            String name = itemName.getText().toString();
            String price = itemPrice.getText().toString();

            String sql ="insert into uploaditem values('"+item+"','"+name+"','"+price+"')";
            try {
                db.execSQL(sql);
                Toast.makeText(this, "물품 1개가 입력되었습니다.",
                        Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this,"입력에 실패하였습니다. 이미 입력되어 있는 물품인지 확인해주세요 ",
                        Toast.LENGTH_SHORT).show();

            }
            db.close();
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backButtonCloseHandler.OnPressedBackButton();
    }
}
