package com.accep7.arknightshelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.GroupHolder> {

    final List<OperatorRecycler> operators = new ArrayList<>();

    @NonNull
    @Override
    public GroupHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_group, parent, false);
        return new GroupHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupHolder holder, int position) {
        holder.bind(operators.get(position));
    }

    @Override
    public int getItemCount() {
        return operators.size();
    }

    public void addAll(List<OperatorRecycler> entries) {
        clearAdapter();
        operators.addAll(entries);
        notifyDataSetChanged();
    }

    public void clearAdapter(){
        operators.clear();
    }

    static class GroupHolder extends RecyclerView.ViewHolder {
        TextView selectedTag;
        RecyclerView itemRecycler;


        public GroupHolder(View itemView) {
            super(itemView);
            selectedTag = itemView.findViewById(R.id.selectedTag);
            itemRecycler = itemView.findViewById(R.id.group_items);
        }

        public void bind(OperatorRecycler operatorRecycler) {
            selectedTag.setText(String.join(",\n", operatorRecycler.getTagList()));
            this.itemRecycler.setAdapter(new OperatorRecyclerViewAdapter(operatorRecycler.getOperatorList()));
        }
    }
}
