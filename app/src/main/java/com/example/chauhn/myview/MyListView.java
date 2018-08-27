package com.example.chauhn.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class MyListView extends LinearLayout {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> lists;

    public interface OnItemClickListener {
        void onItemClickListener(int position);
    }

    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public MyListView(Context context) {
        super(context);
        create(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        create(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        create(context);
    }

    private void create(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.mylistview, this);
            listView = findViewById(R.id.myListView);
        }
    }

    public void setListView(List<String> list){
        this.lists = list;

        adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, lists);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClickListener.onItemClickListener(position);
            }
        });
    }

    public void notifyDataSetChange(List<String> list){
        this.lists = list;
        adapter.notifyDataSetChanged();
    }
}
