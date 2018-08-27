package com.example.chauhn.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final List<String> list = new ArrayList<>();

        list.add("Value");

        final MyListView myListView = findViewById(R.id.list);
        myListView.setListView(list);
        myListView.setOnItemClickListener(new MyListView.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(MainActivity.this, list.get(position), Toast.LENGTH_SHORT).show();

                list.add("Value" + position);
                myListView.notifyDataSetChange(list);
            }
        });
    }
}
