package com.example.masterofconsumption;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewSetItemAdapter extends BaseExpandableListAdapter {

    Context context;
    ArrayList<ListViewSetItemKind> kindList;

    public ListViewSetItemAdapter(Context _context, ArrayList<ListViewSetItemKind> arrayList){
        context = _context;
        kindList = arrayList;
    }

    @Override
    public int getGroupCount() {
        return kindList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return kindList.get(groupPosition).itemList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return kindList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return kindList.get(groupPosition).itemList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = getParentGenericView();
        }
        else {
            view = convertView;
        }

        TextView textView = view.findViewById(R.id.setItemKindText);
        ImageView imageView = view.findViewById(R.id.setItemKindImage);
        textView.setText(kindList.get(groupPosition).name);
        kindList.get(groupPosition).imageView = imageView;

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = getChildGenericView();
        }
        else {
            view = convertView;
        }

        TextView textView = view.findViewById(R.id.setItemName);
        textView.setText(kindList.get(groupPosition).itemList.get(childPosition).name);

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public View getChildGenericView() {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_setitem, null);
        return view;
    }

    public View getParentGenericView() {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_setitem_kind, null);
        return view;
    }
}
