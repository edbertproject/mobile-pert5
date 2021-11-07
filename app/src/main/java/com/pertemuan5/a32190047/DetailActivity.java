package com.pertemuan5.a32190047;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    CrudHelper crudHelper;
    Button backButton;
    TextView nameText, classText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        crudHelper = new CrudHelper(this);
        nameText = findViewById(R.id.nameTextView);
        classText = findViewById(R.id.classTextView);
        backButton = findViewById(R.id.backButton);

        StudentModel student = crudHelper.find(getIntent().getStringExtra("studentId"));
        nameText.setText(student.getName());
        classText.setText(student.getKelas());

        backButton.setOnClickListener(view -> finish());
    }
}