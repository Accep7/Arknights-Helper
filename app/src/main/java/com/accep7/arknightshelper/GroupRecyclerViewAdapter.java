package com.accep7.arknightshelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.GroupHolder> {

    final List<OperatorRecycler> operators = new ArrayList<>();

    @NonNull
    @Override
    public GroupHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_group,
                parent, false);
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

    public void clearAdapter() {
        operators.clear();
    }

    static class GroupHolder extends RecyclerView.ViewHolder {
        TextView selectedTag;
        RecyclerView operatorRecycler;

        public GroupHolder(View itemView) {
            super(itemView);
            selectedTag = itemView.findViewById(R.id.group_selected_tags);
            operatorRecycler = itemView.findViewById(R.id.group_items);
            //operatorRecycler.setItemAnimator(new ExpandItemAnimator());
        }

        public void bind(OperatorRecycler operatorRecycler) {
            selectedTag.setText(operatorRecycler.getTagList()
                    .stream()
                    .collect(Collectors.joining(",\n")));
            this.operatorRecycler.setAdapter(new OperatorRecyclerViewAdapter
                    (operatorRecycler.getOperatorList()));
        }
    }
}
