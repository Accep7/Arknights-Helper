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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperatorRecyclerViewAdapter extends RecyclerView.Adapter<OperatorRecyclerViewAdapter.OperatorHolder> {

    protected final List<OperatorWrapper> operators;

    public OperatorRecyclerViewAdapter(List<OperatorWrapper> operators) {
        this.operators = operators;
    }

    @NonNull
    @Override
    public OperatorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new OperatorHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OperatorHolder holder, int position) {
        holder.bind(operators.get(position));

        holder.itemView.setOnClickListener(v -> {
            OperatorWrapper item = operators.get(holder.getAdapterPosition());
            boolean expanded = !item.isExpanded();
            item.setExpanded(expanded);
            notifyItemChanged(holder.getAdapterPosition(), expanded);
        });
    }

    @Override
    public int getItemCount() {
        return operators.size();
    }

    static class OperatorHolder extends RecyclerView.ViewHolder {
        ViewGroup parent;

        CardView operatorInfo;
        TextView operatorName;

        ConstraintLayout expandedOperatorInfo;

        ImageView expandOperatorInfoButton, operatorPortraitCollapsed, operatorPortraitExpanded,
                operatorArchetypeIcon, operatorClassIcon;
        TextView operatorRarity, operatorArchetypeAndClass, operatorTags;

        public OperatorHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.recycler_vg);

            operatorInfo = itemView.findViewById(R.id.recycler_item);
            operatorName = itemView.findViewById(R.id.operator_name);
            expandOperatorInfoButton = itemView.findViewById(R.id.expand_button);
            expandedOperatorInfo = itemView.findViewById(R.id.operator_info_expanded);

            operatorPortraitCollapsed = itemView.findViewById(R.id.operator_portrait_collapsed_icon);
            operatorPortraitExpanded = itemView.findViewById(R.id.operator_portrait_expanded_icon);
            operatorArchetypeIcon = itemView.findViewById(R.id.operator_archetype_icon);
            operatorClassIcon = itemView.findViewById(R.id.operator_class_icon);

            operatorRarity = itemView.findViewById(R.id.operator_info_rarity);
            operatorArchetypeAndClass = itemView.findViewById(R.id.operator_info_type_class);
            operatorTags = itemView.findViewById(R.id.operator_tags);
        }

        public void bind(OperatorWrapper operatorWrapper) {
            operatorPortraitCollapsed.setImageResource(operatorWrapper.getOperator()
                    .getPortraitDrawableID());
            operatorPortraitCollapsed.setClipToOutline(true);

            operatorPortraitExpanded.setImageResource(operatorWrapper.getOperator()
                    .getPortraitDrawableID());
            operatorPortraitExpanded.setClipToOutline(true);

            operatorName.setText(operatorWrapper.getOperator().getOperatorName());
            operatorRarity.setText(operatorRarity.getContext()
                    .getString(R.string.operatorDetails_Rarity, operatorWrapper.getOperator().getRarity()));

            operatorArchetypeAndClass.setText(String.join(" ",
                    operatorWrapper.getOperator().getOperatorArchetype(),
                    operatorWrapper.getOperator().getOperatorClass()));

            operatorTags.setText(Stream.of(
                    operatorWrapper.getOperator().getQualification(),
                    operatorWrapper.getOperator().getAttackType(),
                    operatorWrapper.getOperator().getAffix1(),
                    operatorWrapper.getOperator().getAffix2(),
                    operatorWrapper.getOperator().getAffix3())
                    .filter(s -> s != null && !s.isEmpty())
                    .collect(Collectors.joining("\n")));

            operatorArchetypeIcon.setImageResource(operatorWrapper.getOperator()
                    .getArchetypeIconDrawableID());

            operatorClassIcon.setImageResource(operatorWrapper.getOperator()
                    .getClassIconDrawableID());

            switch (operatorWrapper.getOperator().getRarity()) {
                case 6:
                    operatorInfo.setCardBackgroundColor(operatorInfo.getContext().getResources()
                            .getColor(R.color.six_star_card_bg, null));
                    break;
                case 5:
                    operatorInfo.setCardBackgroundColor(operatorInfo.getContext().getResources()
                            .getColor(R.color.five_star_card_bg, null));
                    break;
                case 4:
                    operatorInfo.setCardBackgroundColor(operatorInfo.getContext().getResources()
                            .getColor(R.color.four_star_card_bg, null));
                    break;
                case 3:
                    operatorInfo.setCardBackgroundColor(operatorInfo.getContext().getResources()
                            .getColor(R.color.three_star_card_bg, null));
                    break;
                case 2:
                    operatorInfo.setCardBackgroundColor(operatorInfo.getContext().getResources()
                            .getColor(R.color.two_star_card_bg, null));
                    break;
                case 1:
                    operatorInfo.setCardBackgroundColor(operatorInfo.getContext().getResources()
                            .getColor(R.color.one_star_card_bg, null));
                    break;
            }

            expandedOperatorInfo.setVisibility(operatorWrapper.isExpanded() ? View.VISIBLE : View.GONE);
            operatorPortraitCollapsed.setVisibility(operatorWrapper.isExpanded() ? View.GONE : View.VISIBLE);
            expandOperatorInfoButton.animate().setDuration(200).rotation(operatorWrapper.isExpanded() ? 180 : 0);
        }
    }
}
