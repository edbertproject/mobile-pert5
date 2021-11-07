package com.pertemuan5.a32190047;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    CrudHelper crudHelper;
    Button submitButton, backButton;
    TextView nameText, classText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        crudHelper = new CrudHelper(this);
        nameText = findViewById(R.id.nameTextView);
        classText = findViewById(R.id.classTextView);
        submitButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);

        StudentModel student = crudHelper.find(getIntent().getStringExtra("studentId"));
        nameText.setText(student.getName());
        classText.setText(student.getKelas());

        submitButton.setOnClickListener(view -> {
            crudHelper.update(new StudentModel(student.getId(), nameText.getText().toString(), classText.getText().toString()));
            Toast.makeText(getApplicationContext(), "Successfully update student", Toast.LENGTH_LONG).show();
            ListActivity.current.RefreshList();
            finish();
        });

        backButton.setOnClickListener(view -> finish());
    }
}