package com.example.passtask71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.passtask71.data.DatabaseHelper;
import com.example.passtask71.model.Notes;

public class UpdateDeleteActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        Button UpdateButton = findViewById(R.id.UpdateButton);
        Button DeleteButton = findViewById(R.id.DeleteButton);

        EditText updateDeleteNoteEditText = findViewById(R.id.updateDeleteNoteEditText);

        db = new DatabaseHelper(this);

        Intent intent = getIntent();

        long nId = intent.getLongExtra("id",0);
        db = new DatabaseHelper(this);
        //Notes note = db.fetchNote(nId);

        final String notePre = intent.getStringExtra("description");
        updateDeleteNoteEditText.setText(notePre);


        //String id = intent.getStringExtra("id");


        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noteDes = updateDeleteNoteEditText.getText().toString();

                Notes note = new Notes(nId, noteDes);
                long updateRow = db.updateNote(note);

                if (updateRow > 0)
                {
                    Toast.makeText(UpdateDeleteActivity.this, "Note stored successfully!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(UpdateDeleteActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }

                Intent UpdateNoteIntent = new Intent(UpdateDeleteActivity.this, ShowAllNotesActivity.class);

                startActivity(UpdateNoteIntent);
                finish();
            }
        });

        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.deleteNote(nId);

                Intent DeleteNoteIntent = new Intent(UpdateDeleteActivity.this, ShowAllNotesActivity.class);

                Toast.makeText(UpdateDeleteActivity.this, "Note deleted successfully!", Toast.LENGTH_SHORT).show();

                startActivity(DeleteNoteIntent);
                finish();
            }
        });

    }
}