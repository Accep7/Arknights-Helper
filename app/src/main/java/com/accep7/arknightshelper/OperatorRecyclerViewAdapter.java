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

        boolean isExpanded = operators.get(position).isExpanded();
        holder.expandedOperatorInfo.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.operatorPortraitCollapsedCard.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
        holder.expandOperatorInfoButton.animate().setDuration(200).rotation(isExpanded ? 180 : 0);

        holder.itemView.setOnClickListener(v -> {
            OperatorWrapper item = operators.get(position);
            item.setExpanded(!item.isExpanded());
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return operators.size();
    }

    static class OperatorHolder extends RecyclerView.ViewHolder {
        TextView operatorName;

        ConstraintLayout expandedOperatorInfo;
        CardView operator, operatorArchetypeCard, operatorClassCard,
                operatorPortraitExpandedCard, operatorPortraitCollapsedCard;
        ImageView expandOperatorInfoButton, operatorArchetypeIcon, operatorClassIcon,
                operatorPortraitExpanded, operatorPortraitCollapsed;
        TextView operatorRarity, operatorArchetypeAndClass, operatorInfoTV;

        public OperatorHolder(@NonNull View itemView) {
            super(itemView);

            operator = itemView.findViewById(R.id.recycler_item);

            operatorName = itemView.findViewById(R.id.operator_name);
            operatorPortraitCollapsedCard = itemView.findViewById(R.id.operator_portrait_collapsed_card);
            expandOperatorInfoButton = itemView.findViewById(R.id.expand_button);

            expandedOperatorInfo = itemView.findViewById(R.id.operator_info_expanded);
            operatorPortraitExpandedCard = itemView.findViewById(R.id.operator_portrait_expanded_card);
            operatorPortraitExpanded = itemView.findViewById(R.id.operator_portrait_expanded_icon);
            operatorArchetypeCard = itemView.findViewById(R.id.operator_archetype_card);
            operatorArchetypeIcon = itemView.findViewById(R.id.operator_archetype_icon);
            operatorClassCard = itemView.findViewById(R.id.operator_class_card);
            operatorClassIcon = itemView.findViewById(R.id.operator_class_icon);
            operatorPortraitCollapsed = itemView.findViewById(R.id.operator_portrait_collapsed_icon);

            operatorRarity = itemView.findViewById(R.id.operator_info_rarity);
            operatorArchetypeAndClass = itemView.findViewById(R.id.operator_info_type_class);
            operatorInfoTV = itemView.findViewById(R.id.operator_info);
        }

        public void bind(OperatorWrapper operatorWrapper) {
            operatorPortraitCollapsed.setImageResource(operatorWrapper.getOperator()
                    .getPortraitDrawableID());
            operatorPortraitExpanded.setImageResource(operatorWrapper.getOperator()
                    .getPortraitDrawableID());

            operatorName.setText(operatorWrapper.getOperator().getOperatorName());
            operatorRarity.setText(operatorRarity.getContext()
                    .getString(R.string.operatorDetails_Rarity, operatorWrapper.getOperator().getRarity()));

            operatorArchetypeAndClass.setText(String.join(" ",
                    operatorWrapper.getOperator().getOperatorArchetype(),
                    operatorWrapper.getOperator().getOperatorClass()));

            operatorInfoTV.setText(Stream.of(
                    operatorWrapper.getOperator().getQualification(),
                    operatorWrapper.getOperator().getAttackType(),
                    operatorWrapper.getOperator().getAffix1(),
                    operatorWrapper.getOperator().getAffix2(),
                    operatorWrapper.getOperator().getAffix3())
                    .filter(s -> s != null && !s.isEmpty())
                    .collect(Collectors.joining("   ")));

            operatorArchetypeIcon.setImageResource(operatorWrapper.getOperator()
                    .getArchetypeIconDrawableID());
            operatorClassIcon.setImageResource(operatorWrapper.getOperator()
                    .getClassIconDrawableID());

            switch (operatorWrapper.getOperator().getRarity()) {
                case 6:
                    operator.setCardBackgroundColor(operator.getContext().getResources()
                            .getColor(R.color.six_star_card_bg, null));
                    break;
                case 5:
                    operator.setCardBackgroundColor(operator.getContext().getResources()
                            .getColor(R.color.five_star_card_bg, null));
                    break;
                case 4:
                    operator.setCardBackgroundColor(operator.getContext().getResources()
                            .getColor(R.color.four_star_card_bg, null));
                    break;
                case 3:
                    operator.setCardBackgroundColor(operator.getContext().getResources()
                            .getColor(R.color.three_star_card_bg, null));
                    break;
                case 2:
                    operator.setCardBackgroundColor(operator.getContext().getResources()
                            .getColor(R.color.two_star_card_bg, null));
                    break;
                case 1:
                    operator.setCardBackgroundColor(operator.getContext().getResources()
                            .getColor(R.color.one_star_card_bg, null));
                    break;
            }
        }
    }
}
