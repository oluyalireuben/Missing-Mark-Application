package com.example.kabarakuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.kabarakuniversity.databinding.ActivityViewGradeBinding;
import com.example.kabarakuniversity.model.GradedMarks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewGradeActivity extends AppCompatActivity {
    ActivityViewGradeBinding binding;
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<GradedMarks> grades;
    RepliedUnitsAdapter.OnUnitClicked onUnitClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewGradeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageView = findViewById(R.id.IV_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewGradeActivity.this, LecturerDashboardActivity.class));
            }
        });

        onUnitClicked = position -> startActivity(new Intent(ViewGradeActivity.this, ViewGradeDetails.class)
                .putExtra("regNo", grades.get(position).getRegNo())
                .putExtra("studentName", grades.get(position).getStudentName())
                .putExtra("unitName", grades.get(position).getUnitName())
                .putExtra("unitCode", grades.get(position).getUnitCode())
                .putExtra("stage", grades.get(position).getStage())
                .putExtra("lecturerName", grades.get(position).getLecturerName())
                .putExtra("examinationSemester", grades.get(position).getExaminationSemester())
                .putExtra("examYear", grades.get(position).getExamYear())
                .putExtra("examType", grades.get(position).getExamType())
                .putExtra("studentComment", grades.get(position).getStudentComment())
                .putExtra("marks", grades.get(position).getMarks())
                .putExtra("lecturerComment", grades.get(position).getLecturerComment()));

        recyclerView = binding.repliedRecyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        grades = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Grades");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                grades.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    grades.add(ds.getValue(GradedMarks.class));

                }
                recyclerView.setAdapter(new RepliedUnitsAdapter(grades, ViewGradeActivity.this, onUnitClicked));
                binding.repliedRecyclerView.setVisibility(View.VISIBLE);
                binding.repliedProgress.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}