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
//Declaring variables
    LinkedList<String> itemList = new LinkedList<>();
    ArrayAdapter<String> iAdapter;
    EditText itemText;
    TextView textView;
    ImageButton iAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        //Creating objects, assigning variables, and referencing them from xml file
        iAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,itemList);

        iAddButton = (ImageButton)findViewById(R.id.additembutton);
        itemText = (EditText)findViewById(R.id.detaillist);
        itemText.setText("");

        ListView itemView = (ListView) findViewById(R.id.tododetail);
        itemView.setAdapter(iAdapter);
        textView = (TextView)findViewById(R.id.oldlist);

        //Set OnItemClickListener to EditText to enter items to the list
        itemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentI = new Intent(getApplicationContext(), TodoDetailActivity.class);
                iAdapter.notifyDataSetChanged();
                startActivity(intentI);
                return;
            }
        });

        //Set OnItemLongClickListener to delete items
        itemView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemList.remove(position);
                iAdapter.notifyDataSetChanged();
                return true;
            }
        });

        //set OnClickListener to add button to add to the list
        iAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = itemText.getText().toString();
                if (input.length() > 0) {
                    itemList.add(input);
                    iAdapter.notifyDataSetChanged();
                    itemText.setText("");
                }else {
                    //Toast to prompt the user that no text was entered
                    Toast.makeText(getApplicationContext(), "Enter an item.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
