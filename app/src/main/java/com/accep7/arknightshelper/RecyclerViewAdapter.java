package com.accep7.arknightshelper;

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
