package com.example.kabarakuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.kabarakuniversity.databinding.ActivityAppliedBinding;
import com.example.kabarakuniversity.databinding.ActivityMissingMarksApplicationBinding;
import com.example.kabarakuniversity.model.MissingMarks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MissingMarksApplication extends AppCompatActivity {
    ActivityMissingMarksApplicationBinding binding;
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<MissingMarks> marks;
    AppliedUnitsAdapter.OnUnitClicked onUnitClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMissingMarksApplicationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageView = findViewById(R.id.IV_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MissingMarksApplication.this, StudentDashboardActivity.class));
            }
        });

        onUnitClicked = position -> startActivity(new Intent(MissingMarksApplication.this, AwardMarksActivity.class)
                .putExtra("regNo", marks.get(position).getRegNo())
                .putExtra("studentName", marks.get(position).getStudentName())
                .putExtra("unitName", marks.get(position).getUnitName())
                .putExtra("unitCode", marks.get(position).getUnitCode())
                .putExtra("stage", marks.get(position).getStage())
                .putExtra("lecturerName", marks.get(position).getLecturerName())
                .putExtra("examinationSemester", marks.get(position).getExaminationSemester())
                .putExtra("examYear", marks.get(position).getExamYear())
                .putExtra("examType", marks.get(position).getExamType())
                .putExtra("studentComment", marks.get(position).getStudentComment()));

        recyclerView = binding.appliedRecyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        marks = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Missing Marks Applications");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                marks.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    marks.add(ds.getValue(MissingMarks.class));

                }
                recyclerView.setAdapter(new AppliedUnitsAdapter(marks, MissingMarksApplication.this, onUnitClicked));
                binding.appliedRecyclerView.setVisibility(View.VISIBLE);
                binding.appliedProgress.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}