package com.example.kabarakuniversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kabarakuniversity.model.GradedMarks;

import java.util.ArrayList;

public class RepliedUnitsAdapter extends RecyclerView.Adapter<RepliedUnitsAdapter.ViewHolder> {

    private final ArrayList<GradedMarks> grades;
    Context context;
    static OnUnitClicked onUnitClicked;


    public RepliedUnitsAdapter(ArrayList<GradedMarks> grades, Context context, OnUnitClicked onMessageClicked) {
        this.grades = grades;
        this.context = context;
        RepliedUnitsAdapter.onUnitClicked = onMessageClicked;
    }

    interface OnUnitClicked {
        void onUnitClicked(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.applied_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView1.setText(grades.get(position).getUnitName());
        holder.textView2.setText(grades.get(position).getUnitCode());
        holder.textView3.setText(grades.get(position).getLecturerName());
        holder.textView4.setText(grades.get(position).getStage());
        holder.textView5.setText(grades.get(position).getStudentName());
        holder.textView6.setText(grades.get(position).getRegNo());

        holder.itemView.setOnClickListener(view -> {
            onUnitClicked.onUnitClicked(position);
        });


    }
    @Override
    public int getItemCount() {
        return grades.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3, textView4, textView5, textView6;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onUnitClicked.onUnitClicked(getAdapterPosition());

                }
            });
            textView1 = itemView.findViewById(R.id.line_a);
            textView2 = itemView.findViewById(R.id.line_b);
            textView3 = itemView.findViewById(R.id.line_c);
            textView4 = itemView.findViewById(R.id.line_d);
            textView5 = itemView.findViewById(R.id.line_e);
            textView6 = itemView.findViewById(R.id.line_f);
        }
    }

}


