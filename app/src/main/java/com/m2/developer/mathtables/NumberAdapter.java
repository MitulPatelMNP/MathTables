package com.m2.developer.mathtables;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {

    String number;
    ArrayList num;

    public NumberAdapter(String number, ArrayList number1to10) {
        this.number = number;
        this.num = number1to10;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_design, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            int a = Integer.valueOf(number);
            int b = position + 1;
            int mut = a * b;
            holder.textView.setText(String.format("%s%s%s%s%s", number, " * ", b, " = ", mut));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public int getItemCount() {
        return num.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.TableTV);
            textView.setSelected(true);
        }
    }
}
