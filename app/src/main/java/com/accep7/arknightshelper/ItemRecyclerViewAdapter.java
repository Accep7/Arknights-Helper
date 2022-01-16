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

import com.accep7.arknightshelper.RecruitmentPool.RecruitableOperator;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemHolder> {

    protected final List<RecruitableOperator> items;

    public ItemRecyclerViewAdapter(List<RecruitableOperator> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ItemHolder(v, items);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.bind(items.get(position));

        boolean isExpanded = items.get(position).isExpandedDetails();
        holder.operatorInfoLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.expandOperatorInfoButton.animate().setDuration(200).rotation(isExpanded ? 180 : 0);

        holder.itemView.setOnClickListener(v -> {
            RecruitableOperator item = items.get(position);
            item.setExpandedDetails(!item.isExpandedDetails());
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ItemHolder extends RecyclerView.ViewHolder {
        TextView operatorName;

        ConstraintLayout operatorInfoLayout;
        CardView listItem, operatorArchetypeCard, operatorClassCard;
        ImageView expandOperatorInfoButton, operatorArchetypeIcon, operatorClassIcon;
        TextView operatorRarity, operatorArchetypeAndClass, operatorAttackType, operatorQualification,
                operatorAffix1, operatorAffix2, operatorAffix3;

        public ItemHolder(@NonNull View itemView, List<RecruitableOperator> items) {
            super(itemView);

            operatorName = itemView.findViewById(R.id.operatorName);

            expandOperatorInfoButton = itemView.findViewById(R.id.expand_button);

            operatorInfoLayout = itemView.findViewById(R.id.expandableOperatorDetails);
            listItem = itemView.findViewById(R.id.recyclerview_entry);
            operatorArchetypeCard = itemView.findViewById(R.id.operator_archetype_card);
            operatorArchetypeIcon = itemView.findViewById(R.id.operator_archetype_icon);
            operatorClassCard = itemView.findViewById(R.id.operator_class_card);
            operatorClassIcon = itemView.findViewById(R.id.operator_class_icon);

            operatorRarity = itemView.findViewById(R.id.operatorDetails_Rarity);
            operatorArchetypeAndClass = itemView.findViewById(R.id.operatorDetails_ArchetypeAndClass);
            operatorAttackType = itemView.findViewById(R.id.operatorDetails_AttackType);
            operatorQualification = itemView.findViewById(R.id.operatorDetails_Qualification);
            operatorAffix1 = itemView.findViewById(R.id.operatorDetails_Affix1);
            operatorAffix2 = itemView.findViewById(R.id.operatorDetails_Affix2);
            operatorAffix3 = itemView.findViewById(R.id.operatorDetails_Affix3);
        }

        public void bind(RecruitableOperator operator) {
            operatorName.setText(operator.operatorName);
            operatorRarity.setText(operatorRarity.getContext()
                    .getString(R.string.operatorDetails_Rarity, operator.rarity));
            operatorArchetypeAndClass.setText(String.join(" ", operator.archetype,
                    operator.inGameClass));
            operatorAttackType.setText(operator.attackType);
            operatorQualification.setText(operator.qualification);
            operatorArchetypeIcon.setImageResource(operator.archetypeIconResourceID);
            operatorClassIcon.setImageResource(operator.classIconResourceID);

            switch (operator.rarity) {
                case 6:
                    listItem.setCardBackgroundColor(listItem.getContext().getResources()
                            .getColor(R.color.sixStar_background, null));
                    break;
                case 5:
                    listItem.setCardBackgroundColor(listItem.getContext().getResources()
                            .getColor(R.color.fiveStar_background, null));
                    break;
                case 4:
                    listItem.setCardBackgroundColor(listItem.getContext().getResources()
                            .getColor(R.color.fourStar_background, null));
                    break;
                case 3:
                    listItem.setCardBackgroundColor(listItem.getContext().getResources()
                            .getColor(R.color.threeStar_background, null));
                    break;
                case 2:
                    listItem.setCardBackgroundColor(listItem.getContext().getResources()
                            .getColor(R.color.twoStar_background, null));
                    break;
                case 1:
                    listItem.setCardBackgroundColor(listItem.getContext().getResources()
                            .getColor(R.color.oneStar_background, null));
                    break;
            }

            //Prevents layout fuck-ups when operator affix is null
            if (operator.affix1 == null) {
                operatorAffix1.setVisibility(View.GONE);
            } else {
                operatorAffix1.setText(operator.affix1);
                operatorAffix1.setVisibility(View.VISIBLE);
            }
            if (operator.affix2 == null) {
                operatorAffix2.setVisibility(View.GONE);
            } else {
                operatorAffix2.setText(operator.affix2);
                operatorAffix2.setVisibility(View.VISIBLE);
            }
            if (operator.affix3 == null) {
                operatorAffix3.setVisibility(View.GONE);
            } else {
                operatorAffix3.setText(operator.affix3);
                operatorAffix3.setVisibility(View.VISIBLE);
            }
        }
    }
}
