package com.example.passtask71;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.passtask71.data.DatabaseHelper;
import com.example.passtask71.model.Notes;

public class NewNoteActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        EditText addNoteEditText = findViewById(R.id.updateDeleteNoteEditText);
        Button saveButton = findViewById(R.id.saveButton);
        db = new DatabaseHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String note = addNoteEditText.getText().toString();
                Notes note = new Notes(addNoteEditText.getText().toString());

                //long result = db.insertUser(new Notes(note));
                long result = db.insertUser(note);

                if (result > 0)
                {
                    Toast.makeText(NewNoteActivity.this, "Note stored successfully!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(NewNoteActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}