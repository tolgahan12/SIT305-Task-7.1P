package com.example.passtask71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newNoteButton = findViewById(R.id.createANewNoteButton);
        Button allNotesButton = findViewById(R.id.showAllNotesButton);

        //ListView notesListView = findViewById(R.id.notesListView);

        //db = new DatabaseHelper(this);

        newNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newNoteIntent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivity(newNoteIntent);
            }
        });


        allNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showIntent = new Intent(MainActivity.this, ShowAllNotesActivity.class);
                startActivity(showIntent);
            }
        });
    }
}