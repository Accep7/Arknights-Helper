package com.accep7.arknightshelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.OperatorHolder> {

    final List<ItemRecycler> operators = new ArrayList<>();

    @NonNull
    @Override
    public OperatorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_group, parent, false);
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

    public void addAll(List<ItemRecycler> entries) {
        operators.clear();
        operators.addAll(entries);
        notifyDataSetChanged();
    }

    static class OperatorHolder extends RecyclerView.ViewHolder {
        TextView selectedTag;
        RecyclerView itemRecycler;


        public OperatorHolder(View itemView) {
            super(itemView);
            selectedTag = itemView.findViewById(R.id.selectedTag);
            itemRecycler = itemView.findViewById(R.id.group_items);
        }

        public void bind(ItemRecycler item) {
            selectedTag.setText(String.join(",\n", item.getTagList()));
            this.itemRecycler.setAdapter(new ItemRecyclerViewAdapter(item.getOperatorList()));

        }
    }
}
