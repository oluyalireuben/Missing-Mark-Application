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

public class GradedUnitsAdapter extends RecyclerView.Adapter<GradedUnitsAdapter.ViewHolder> {

    private final ArrayList<GradedMarks> registeredunits;
    Context context;
    static OnUnitClicked onUnitClicked;


    public GradedUnitsAdapter(ArrayList<GradedMarks> registeredunits, Context context, OnUnitClicked onMessageClicked) {
        this.registeredunits = registeredunits;
        this.context = context;
        GradedUnitsAdapter.onUnitClicked = onMessageClicked;
    }

    interface OnUnitClicked {
        void onUnitClicked(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.graded_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GradedMarks model = registeredunits.get(position);
        holder.textView1.setText(model.getUnitName());
        holder.textView2.setText(model.getUnitCode());
        holder.textView3.setText(model.getLecturerName());
        holder.textView4.setText(model.getStage());
        holder.textView5.setText(model.getStudentName());
        holder.textView6.setText(model.getRegNo());
        holder.textView7.setText(model.getMarks());

    }

    @Override
    public int getItemCount() {
        return registeredunits.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;

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
            textView7 = itemView.findViewById(R.id.line_g);
        }
    }

}




