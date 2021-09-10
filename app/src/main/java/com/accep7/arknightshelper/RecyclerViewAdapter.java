package com.accep7.arknightshelper;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.OperatorHolder> {

    final List<OperatorWrapper> operators = new ArrayList<>();

    @NonNull
    @Override
    public OperatorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new OperatorHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OperatorHolder holder, int position) {
        holder.bind(operators.get(position));
        if (operators.get(position).getOperator().getRarity() == 6) {
            holder.itemView.setBackgroundResource(R.color.sixStar_background);
        }
        if (operators.get(position).getOperator().getRarity() == 5) {
            holder.itemView.setBackgroundResource(R.color.fiveStar_background);
        }
        if (operators.get(position).getOperator().getRarity() == 4) {
            holder.itemView.setBackgroundResource(R.color.fourStar_background);
        }
        if (operators.get(position).getOperator().getRarity() == 3) {
            holder.itemView.setBackgroundResource(R.color.threeStar_background);
        }
        if (operators.get(position).getOperator().getRarity() == 2) {
            holder.itemView.setBackgroundResource(R.color.twoStar_background);
        }
        if (operators.get(position).getOperator().getRarity() == 1) {
            holder.itemView.setBackgroundResource(R.color.oneStar_background);
        }
    }

    @Override
    public int getItemCount() {
        return operators.size();
    }

    public OperatorWrapper getItem(int position) {
        return operators.get(position);
    }

    public int getPosition(RecruitmentPool.RecruitableOperator operator) {
        for (int i = 0; i < getItemCount(); i++) {
            if (getItem(i).getOperator().equals(operator)) {
                return i;
            }
        }
        return -1;
    }

    public void clearItems() {
        operators.clear();
        notifyDataSetChanged();
    }

    public void remove(OperatorWrapper item) {
        int lastPos = operators.indexOf(item);
        operators.remove(item);
        notifyItemRemoved(lastPos);
    }

    public void insert(OperatorWrapper newItem, int position) {
        operators.add(position, newItem);
        notifyItemInserted(position);
    }

    public void add(OperatorWrapper newItem) {
        insert(newItem, operators.size());
    }

    static class OperatorHolder extends RecyclerView.ViewHolder {
        TextView selectedTag;
        TextView operatorName;

        public OperatorHolder(View itemView) {
            super(itemView);
            selectedTag = itemView.findViewById(R.id.selectedTag);
            operatorName = itemView.findViewById(R.id.operatorName);
        }

        public void bind(OperatorWrapper wrapper) {
            operatorName.setText(wrapper.getOperator().operatorName);
            selectedTag.setText(wrapper.tagsToString());
        }
    }
}
