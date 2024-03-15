package com.example.kabarakuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LecturerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_dashboard);

        CardView add = findViewById(R.id.cardAddUnit);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LecturerDashboardActivity.this, AddUnit.class));
            }
        });

        CardView added = findViewById(R.id.cardAddedUnit);
        added.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LecturerDashboardActivity.this, AddedUnits.class));
            }
        });

        CardView applications = findViewById(R.id.cardApplied);
        applications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LecturerDashboardActivity.this, MissingMarksApplication.class));
            }
        });

        CardView replied = findViewById(R.id.cardReplied);
        replied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LecturerDashboardActivity.this, RepliedMissingMarks.class));
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navHome:
                            // Start HomeActivity or perform relevant action
                            startActivity(new Intent(LecturerDashboardActivity.this, LecturerDashboardActivity.class));
                            Toast.makeText(LecturerDashboardActivity.this, "Home", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.navAddMarks:
                            // Start ProfileActivity or perform relevant action
                            startActivity(new Intent(LecturerDashboardActivity.this, AwardMarksActivity.class));
                            Toast.makeText(LecturerDashboardActivity.this, "Add Marks", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.navChangePass:
                            // Start VaccinationActivity or perform relevant action
                            startActivity(new Intent(LecturerDashboardActivity.this, ForgotPasswordActivity.class));
                            Toast.makeText(LecturerDashboardActivity.this, "Change Password", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.navLogout:
                            // Start ChangePasswordActivity or perform relevant action
                            startActivity(new Intent(LecturerDashboardActivity.this, LoginActivity.class));
                            Toast.makeText(LecturerDashboardActivity.this, "You have successfully Logged out", Toast.LENGTH_SHORT).show();
                            return true;
                    }
                    return false;
                }
            };
}

