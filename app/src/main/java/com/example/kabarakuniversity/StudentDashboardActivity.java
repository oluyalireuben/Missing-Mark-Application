package com.example.kabarakuniversity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        CardView register = findViewById(R.id.cardRegisterUnit);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboardActivity.this, ViewUnits.class));
            }
        });

        CardView apply = findViewById(R.id.cardApply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboardActivity.this, ApplyMissingMarksActivity.class));
            }
        });

        CardView applied = findViewById(R.id.cardApplied);
        applied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboardActivity.this, AppliedActivity.class));
            }
        });

        CardView view = findViewById(R.id.cardViewGrade);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboardActivity.this, ViewGradeActivity.class));
            }
        });

        CardView registered = findViewById(R.id.cardRegisteredUnits);
        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboardActivity.this, RegisteredUnits.class));
            }
        });

        CardView logout = findViewById(R.id.cardExit);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboardActivity.this, LoginActivity.class));
            }
        });

    }
}