package com.example.masterofconsumption;

import android.graphics.Bitmap;
import android.widget.CheckBox;

public class ListViewSetItem {

    String name;
    String price;
    Bitmap image;
    CheckBox checkBox;

    public ListViewSetItem(String _name, String _price) {
        name = _name;
        price = _price;
    }

}
