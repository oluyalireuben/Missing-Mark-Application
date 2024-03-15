package com.example.kabarakuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kabarakuniversity.databinding.ActivityApplyDetailsBinding;
import com.example.kabarakuniversity.model.MissingMarks;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ApplyDetails extends AppCompatActivity {

    TextView regno, student, name, code, unitstage, lecturer;
    public EditText year, comment;
    public Spinner spinner1, spinner2;
    public LinearLayout submit;
    public ProgressBar progressBar;

    String[] Semester = {"Select Semester", "January - April", "May - August", "September - December"};
    String[] ExamType = {"Select Exam Type", "Normal", "Supplementary", "Special", "Retake"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_details);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        regno = findViewById(R.id.tvRegNo);
        student = findViewById(R.id.tvStudentName);
        name = findViewById(R.id.tvUnitname);
        code = findViewById(R.id.tvUnitcode);
        unitstage = findViewById(R.id.tvStage);
        lecturer = findViewById(R.id.tvLecturerName);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        year = findViewById(R.id.ET_ExamYear);
        comment = findViewById(R.id.ET_StudentComment);
        submit = findViewById(R.id.LL_submit);


        String regNo = getIntent().getStringExtra("regNo");
        String studentName = getIntent().getStringExtra("studentName");
        String unitName = getIntent().getStringExtra("unitName");
        String unitCode = getIntent().getStringExtra("unitCode");
        String stage = getIntent().getStringExtra("stage");
        String lecturerName = getIntent().getStringExtra("lecturerName");


        regno.setText(regNo);
        student.setText(studentName);
        name.setText(unitName);
        code.setText(unitCode);
        unitstage.setText(stage);
        lecturer.setText(lecturerName);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Semester);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ExamType);
        adapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String examsem = spinner1.getSelectedItem().toString();
                String examtype = spinner2.getSelectedItem().toString();
                String examYear = year.getText().toString();
                String sTudent = comment.toString();

                if (TextUtils.isEmpty(examsem)) {
                    Toast.makeText(ApplyDetails.this, "Please choose Examination Semester", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(examYear)) {
                    Toast.makeText(ApplyDetails.this, "Please enter Exam Year", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(examtype)) {
                    Toast.makeText(ApplyDetails.this, "Please choose Exam Type", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(sTudent)) {
                    Toast.makeText(ApplyDetails.this, "Please enter Your Comment", Toast.LENGTH_SHORT).show();
                    return;
                }

                applyMarks(regno, student, name, code, unitstage, lecturer, spinner1, year, spinner2, comment);
                Toast.makeText(ApplyDetails.this, "You have successfully applied for Missing Mark", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ApplyDetails.this, AppliedActivity.class));
            }
        });
    }

    private void applyMarks(TextView regno,TextView student, TextView name, TextView code, TextView unitstage, TextView lecturer,
                       Spinner spinner1, EditText year, Spinner spinner2, EditText comment) {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        MissingMarks missingMarks = new MissingMarks(regno.getText().toString(),student.getText().toString(), name.getText().toString(),
                code.getText().toString(), unitstage.getText().toString(), lecturer.getText().toString(),spinner1.getSelectedItem().toString(),
                year.getText().toString(), spinner2.getSelectedItem().toString(), comment.getText().toString());

        String key = ref.push().getKey();

        ref.child("Missing Marks Applications").child(key).setValue(missingMarks).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(ApplyDetails.this,"Insertion Complete",Toast.LENGTH_SHORT).show();
            }
        });
    }
}