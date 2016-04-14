package com.example.tiannanmcclanahan.project1todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList <String> toDoList;
    ArrayAdapter<String> lAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoList = new LinkedList<>();
        toDoList.add("Grocery List");
        toDoList.add("To-Do List");
        lAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,toDoList);

        ListView listView = (ListView)findViewById(R.id.existinglist);
        listView.setAdapter(lAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                toDoList.remove(position);
                lAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
