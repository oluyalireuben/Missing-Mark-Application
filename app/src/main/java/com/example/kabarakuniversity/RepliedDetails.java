package com.example.kabarakuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kabarakuniversity.model.GradedMarks;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RepliedDetails extends AppCompatActivity {
    TextView regno, student, name, code, unitstage, lecturer, semester, year, exam, comment, grade, leccomment;
    ArrayList<GradedMarks> arrayList;
    LinearLayout llback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replied_details);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        arrayList = new ArrayList<>();

        regno = findViewById(R.id.TV_RegNo);
        student = findViewById(R.id.TV_StudentName);
        name = findViewById(R.id.TV_Unitname);
        code = findViewById(R.id.TV_Unitcode);
        unitstage = findViewById(R.id.TV_UnitStage);
        lecturer = findViewById(R.id.TV_LecturerName);
        semester = findViewById(R.id.TV_ExamSemester);
        year = findViewById(R.id.TV_ExamYear);
        exam = findViewById(R.id.TV_ExamType);
        comment = findViewById(R.id.TV_StudentComment);
        grade = findViewById(R.id.TV_Grade);
        leccomment = findViewById(R.id.TV_LecturerComment);
        llback = findViewById(R.id.LL_reply);

        llback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RepliedDetails.this, RepliedMissingMarks.class));
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
        String marks = getIntent().getStringExtra("marks");
        String lecturerComment = getIntent().getStringExtra("lecturerComment");

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
        grade.setText(marks);
        leccomment.setText(lecturerComment);

    }
}