package com.example.tiannanmcclanahan.project1todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class TodoDetailActivity extends AppCompatActivity {

    LinkedList<String> itemList;

    ArrayAdapter<String> iAdapter;
    EditText itemText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        String eggs = getIntent().getStringExtra("eggs");
        textView.setText(String.valueOf(eggs));
        iAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,itemList);

        ListView itemView = (ListView) findViewById(R.id.tododetail);
        textView = (TextView)findViewById(R.id.oldlist);
        itemView.setAdapter(iAdapter);

        itemView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemList.remove(position);
                iAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
