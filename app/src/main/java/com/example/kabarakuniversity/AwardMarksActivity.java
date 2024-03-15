package com.example.kabarakuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kabarakuniversity.model.GradedMarks;
import com.example.kabarakuniversity.model.MissingMarks;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AwardMarksActivity extends AppCompatActivity {
    TextView regno, student, name, code, unitstage, lecturer, semestersem, year, exam, comment;
    ArrayList<MissingMarks> arrayList;
    EditText edLecturerComment, edGrade;
    LinearLayout LL_reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award_marks);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        arrayList = new ArrayList<>();

        regno = findViewById(R.id.tvRegNo);
        student = findViewById(R.id.tvStudentName);
        name = findViewById(R.id.tvUnitname);
        code = findViewById(R.id.tvUnitcode);
        unitstage = findViewById(R.id.tvStage);
        lecturer = findViewById(R.id.tvLecturerName);
        semestersem = findViewById(R.id.tvExamSem);
        year = findViewById(R.id.tvExamYear);
        exam = findViewById(R.id.tvExamType);
        comment = findViewById(R.id.tvStudentComment);
        edGrade = findViewById(R.id.etGrade);
        edLecturerComment = findViewById(R.id.etLecturerComment);
        LL_reply = findViewById(R.id.LL_reply);


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
        semestersem.setText(examinationSemester);
        year.setText(examYear);
        exam.setText(examType);
        comment.setText(studentComment);

    LL_reply.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String grade = edGrade.toString();
        String leccomment = edLecturerComment.toString();

        if (TextUtils.isEmpty(grade)) {
            Toast.makeText(AwardMarksActivity.this, "Please enter Grade", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(leccomment)) {
            Toast.makeText(AwardMarksActivity.this, "Please write a comment", Toast.LENGTH_SHORT).show();
            return;
        }

        Awardgrade(regno, student, name, code, unitstage, lecturer, semestersem, year, exam, comment, edGrade, edLecturerComment);
        Toast.makeText(AwardMarksActivity.this, "Reply Sent", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(AwardMarksActivity.this, RepliedMissingMarks.class));
    }
    });
    }

    private void Awardgrade(TextView regno,TextView student, TextView name, TextView code, TextView unitstage, TextView lecturer,
                            TextView year, TextView semestersem,TextView exam, TextView comment, EditText marks, EditText lecturerCommentText) {

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

            GradedMarks gradedMarks = new GradedMarks(regno.getText().toString(),student.getText().toString(),
                    name.getText().toString(), code.getText().toString(), unitstage.getText().toString(), lecturer.getText().toString(),
                    semestersem.getText().toString(), year.getText().toString(), exam.getText().toString(),
                    comment.getText().toString(),marks.getText().toString(), lecturerCommentText.getText().toString());

            String key = ref.push().getKey();
            ref.child("Grades").child(key).setValue(gradedMarks).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {

            }
            });

    }
}

