package com.example.masterofconsumption;

import android.widget.ImageView;

public class ListViewSetItem {

    String name;
    String price;
    ImageView image;
    boolean isChecked;

    public ListViewSetItem(String _name, String _price) {
        name = _name;
        price = _price;
        isChecked = false;
    }

}
