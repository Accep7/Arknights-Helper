package com.accep7.arknightshelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
        RecruitmentPool.RecruitableOperator operator = operators.get(position).getOperator();

        holder.operatorDetailsRarity.setText(holder.operatorDetailsRarity.getContext()
                .getString(R.string.operatorDetails_Rarity, operator.rarity));
        holder.operatorDetailsClass.setText(operator.inGameClass);
        holder.operatorDetailsAttackType.setText(operator.attackType);
        holder.operatorDetailsQualification.setText(operator.qualification);

        if (operator.affix1 == null) {
            holder.operatorDetailsAffix1.setVisibility(View.GONE);
        } else {
            holder.operatorDetailsAffix1.setText(operator.affix1);
            holder.operatorDetailsAffix1.setVisibility(View.VISIBLE);
        }

        if (operator.affix2 == null) {
            holder.operatorDetailsAffix2.setVisibility(View.GONE);
        } else {
            holder.operatorDetailsAffix2.setText(operator.affix2);
            holder.operatorDetailsAffix2.setVisibility(View.VISIBLE);
        }

        if (operator.affix3 == null) {
            holder.operatorDetailsAffix3.setVisibility(View.GONE);
        } else {
            holder.operatorDetailsAffix3.setText(operator.affix3);
            holder.operatorDetailsAffix3.setVisibility(View.VISIBLE);
        }

        boolean isExpanded = operators.get(position).getOperator().isExpanded();
        holder.expandOperatorDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.expandButton.animate().setDuration(200).rotation(isExpanded ? 180 : 0);

        if (operators.get(position).getOperator().rarity == 6) {
            holder.listItem.setCardBackgroundColor(holder.listItem.getContext().getResources()
                    .getColor(R.color.sixStar_background, null));
        }
        if (operators.get(position).getOperator().rarity == 5) {
            holder.listItem.setCardBackgroundColor(holder.listItem.getContext().getResources()
                    .getColor(R.color.fiveStar_background, null));
        }
        if (operators.get(position).getOperator().rarity == 4) {
            holder.listItem.setCardBackgroundColor(holder.listItem.getContext().getResources()
                    .getColor(R.color.fourStar_background, null));
        }
        if (operators.get(position).getOperator().rarity == 3) {
            holder.listItem.setCardBackgroundColor(holder.listItem.getContext().getResources()
                    .getColor(R.color.threeStar_background, null));
        }
        if (operators.get(position).getOperator().rarity == 2) {
            holder.listItem.setCardBackgroundColor(holder.listItem.getContext().getResources()
                    .getColor(R.color.twoStar_background, null));
        }
        if (operators.get(position).getOperator().rarity == 1) {
            holder.listItem.setCardBackgroundColor(holder.listItem.getContext().getResources()
                    .getColor(R.color.oneStar_background, null));
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

/*    public void remove(OperatorWrapper item) {
        int lastPos = operators.indexOf(item);
        operators.remove(item);
        notifyItemRemoved(lastPos);
    }*/

    public void insert(OperatorWrapper newItem, int position) {
        operators.add(position, newItem);
        notifyItemInserted(position);
    }

    public void add(OperatorWrapper newItem) {
        insert(newItem, operators.size());
    }

    class OperatorHolder extends RecyclerView.ViewHolder {
        TextView selectedTag, operatorName;

        ConstraintLayout expandOperatorDetails;
        CardView listItem;
        ImageView expandButton;
        TextView operatorDetailsRarity, operatorDetailsClass, operatorDetailsAttackType,
                operatorDetailsQualification, operatorDetailsAffix1, operatorDetailsAffix2,
                operatorDetailsAffix3;

        public OperatorHolder(View itemView) {
            super(itemView);

            selectedTag = itemView.findViewById(R.id.selectedTag);
            operatorName = itemView.findViewById(R.id.operatorName);

            expandButton = itemView.findViewById(R.id.expand_button);
            expandOperatorDetails = itemView.findViewById(R.id.expandableOperatorDetails);
            listItem = itemView.findViewById(R.id.list_item);

            operatorDetailsRarity = itemView.findViewById(R.id.operatorDetails_Rarity);
            operatorDetailsClass = itemView.findViewById(R.id.operatorDetails_Class);
            operatorDetailsAttackType = itemView.findViewById(R.id.operatorDetails_AttackType);
            operatorDetailsQualification = itemView.findViewById(R.id.operatorDetails_Qualification);
            operatorDetailsAffix1 = itemView.findViewById(R.id.operatorDetails_Affix1);
            operatorDetailsAffix2 = itemView.findViewById(R.id.operatorDetails_Affix2);
            operatorDetailsAffix3 = itemView.findViewById(R.id.operatorDetails_Affix3);

            operatorName.setOnClickListener(v -> {
                OperatorWrapper operator = operators.get(getAdapterPosition());
                operator.getOperator().setExpanded(!operator.getOperator().isExpanded());
                notifyItemChanged(getAdapterPosition());
            });
        }

        public void bind(OperatorWrapper wrapper) {
            operatorName.setText(wrapper.getOperator().operatorName);
            selectedTag.setText(wrapper.tagsToString());
        }
    }
}
