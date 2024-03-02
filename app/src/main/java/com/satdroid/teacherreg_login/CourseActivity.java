package com.satdroid.teacherreg_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CourseActivity extends AppCompatActivity {

    TextView courseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        courseName=findViewById(R.id.courseName);

        Intent CourseIntent=getIntent();
        courseName.setText(CourseIntent.getStringExtra("course_name"));

    }
}