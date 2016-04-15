package com.example.tiannanmcclanahan.project1todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class TodoDetailActivity extends AppCompatActivity {

    LinkedList<String> itemList = new LinkedList<>();

    ArrayAdapter<String> iAdapter;
    EditText itemText;
    TextView textView;
    ImageButton iAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
//        String eggs = getIntent().getStringExtra("eggs");
//        textView.setText(String.valueOf(eggs));
        iAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,itemList);

        iAddButton = (ImageButton)findViewById(R.id.additembutton);
        itemText = (EditText)findViewById(R.id.detaillist);
        itemText.setText("");

        ListView itemView = (ListView) findViewById(R.id.tododetail);
        textView = (TextView)findViewById(R.id.oldlist);
        itemView.setAdapter(iAdapter);

        itemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentI = new Intent(getApplicationContext(), TodoDetailActivity.class);
                iAdapter.notifyDataSetChanged();
                startActivity(intentI);
                return;
            }
        });

        itemView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemList.remove(position);
                iAdapter.notifyDataSetChanged();
                return false;
            }
        });
        iAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = itemText.getText().toString();
                if (input.length() > 0) {
                    itemList.add(input);
                    iAdapter.notifyDataSetChanged();
                    itemText.setText("");
                }else {
                    Toast.makeText(getApplicationContext(), "Enter an item.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
