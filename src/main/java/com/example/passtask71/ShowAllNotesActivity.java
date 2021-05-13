package com.example.passtask71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.passtask71.data.DatabaseHelper;
import com.example.passtask71.model.Notes;

import java.util.ArrayList;
import java.util.List;

public class ShowAllNotesActivity extends AppCompatActivity {

    ListView notesListView;

    ArrayList<String> noteArrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_notes);

        notesListView = findViewById(R.id.notesListView);
        noteArrayList = new ArrayList<>();
        DatabaseHelper db = new DatabaseHelper(ShowAllNotesActivity.this);

        List<Notes> notesList = db.fetchAllNotes();
        for (Notes note :notesList)
        {
            noteArrayList.add(note.getNote_description());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteArrayList);
        notesListView.setAdapter(adapter);


        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Going from MainActivity to NotesEditorActivity
                Intent intent = new Intent(ShowAllNotesActivity.this, UpdateDeleteActivity.class);
                //intent.putExtra("noteId", i);

                intent.putExtra("id", notesList.get(i).getNote_id());
                intent.putExtra("description", notesList.get(i).getNote_description());

                //Toast.makeText(ShowAllNotesActivity.this, notesList.get(i).getNote_id(), Toast.LENGTH_SHORT).show();

                startActivity(intent);
                finish();

            }
        });


    }
}