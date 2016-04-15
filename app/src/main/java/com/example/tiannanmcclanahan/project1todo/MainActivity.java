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
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    //Declaring variables
    LinkedList <String> toDoList;
    ArrayAdapter<String> lAdapter;
    EditText inputText;
    ImageButton lAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating objects, assigning the variables, and referencing them from the xml file
        toDoList = new LinkedList<>();
        toDoList.add("Grocery List");
        toDoList.add("To-Do List");
        lAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,toDoList);

        ListView listView = (ListView)findViewById(R.id.existinglist);
        listView.setAdapter(lAdapter);

        lAddButton = (ImageButton)findViewById(R.id.addbutton);

        inputText = (EditText)findViewById(R.id.inputlist);
        inputText.setText("");

        //Set OnItemClickListener to EditText to enter a list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TodoDetailActivity.class);
                startActivity(intent);
                lAdapter.notifyDataSetChanged();
                return;
            }
        });

        //Set OnClickListener to add button to add a new list
        lAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();
                if (input.length() > 0) {
                    toDoList.add(input);
                    lAdapter.notifyDataSetChanged();
                    inputText.setText("");
                    //toast to prompt the user when they try to add without any text
                } else {
                    Toast.makeText(getApplicationContext(), "You didn't make a list.", Toast.LENGTH_LONG).show();
                }
            }
        });

        //set OnItemLongClickListener to delete list
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
