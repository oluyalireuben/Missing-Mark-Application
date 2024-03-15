package com.example.kabarakuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kabarakuniversity.model.MissingMarks;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MissingMarkDetails extends AppCompatActivity {
    TextView regno, student, name, code, unitstage, lecturer, semester, year, exam, comment;
    ArrayList<MissingMarks> arrayList;

    LinearLayout llback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_mark_details);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        arrayList = new ArrayList<>();

        regno = findViewById(R.id.tvRegNo);
        student = findViewById(R.id.tvStudentName);
        name = findViewById(R.id.tvUnitname);
        code = findViewById(R.id.tvUnitcode);
        unitstage = findViewById(R.id.tvStage);
        lecturer = findViewById(R.id.tvLecturerName);
        semester = findViewById(R.id.tvExamSem);
        year = findViewById(R.id.tvExamYear);
        exam = findViewById(R.id.tvExamType);
        comment = findViewById(R.id.tvStudentComment);
        llback = findViewById(R.id.LL_grade);

        llback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MissingMarkDetails.this, AwardMarksActivity.class));

            }
        });

        String regNo = getIntent().getStringExtra("regNo");
        String studentName = getIntent().getStringExtra("studentName");
        String unitName = getIntent().getStringExtra("unitName");
        String unitCode = getIntent().getStringExtra("unitCode");
        String stage = getIntent().getStringExtra("stage");
        String lecturerName = getIntent().getStringExtra("lecturerName");
        String examinationSemester = getIntent().getStringExtra("examinationSemester");
        String examYear = getIntent().getStringExtra("examYear");
        String examType = getIntent().getStringExtra("examType");
        String studentComment = getIntent().getStringExtra("studentComment");

        regno.setText(regNo);
        student.setText(studentName);
        name.setText(unitName);
        code.setText(unitCode);
        unitstage.setText(stage);
        lecturer.setText(lecturerName);
        semester.setText(examinationSemester);
        year.setText(examYear);
        exam.setText(examType);
        comment.setText(studentComment);
    }
}