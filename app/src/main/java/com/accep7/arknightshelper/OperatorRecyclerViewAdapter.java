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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                parent, false);

        OperatorHolder operatorHolder = new OperatorHolder(view);
        view.setOnClickListener(v -> {
            OperatorWrapper item = operators.get(operatorHolder.getAdapterPosition());
            boolean expanded = !item.isExpanded();
            item.setExpanded(expanded);
            notifyItemChanged(operatorHolder.getAdapterPosition(), new ExpandItemAnimator
                    .ExpandedInfo(expanded));
        });
        return operatorHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OperatorHolder holder, int position) {
        holder.bind(operators.get(position));
    }

    @Override
    public int getItemCount() {
        return operators.size();
    }

    static class OperatorHolder extends RecyclerView.ViewHolder {
        CardView operatorInfo;
        TextView operatorName;

        ConstraintLayout expandedOperatorInfo;

        ImageView expandOperatorInfoButton, operatorPortraitCollapsed, operatorPortraitExpanded,
                operatorArchetypeIcon, operatorClassIcon;
        TextView operatorRarity, operatorArchetypeAndClass, operatorTags;

        public OperatorHolder(@NonNull View itemView) {
            super(itemView);
            operatorInfo = itemView.findViewById(R.id.recycler_item);
            operatorName = itemView.findViewById(R.id.operator_name);
            expandOperatorInfoButton = itemView.findViewById(R.id.expand_button);
            expandedOperatorInfo = itemView.findViewById(R.id.operator_info_expanded);

            operatorPortraitCollapsed = itemView.findViewById(R.id.operator_portrait_collapsed);
            operatorPortraitExpanded = itemView.findViewById(R.id.operator_portrait_expanded);
            operatorArchetypeIcon = itemView.findViewById(R.id.operator_info_archetype_icon);
            operatorClassIcon = itemView.findViewById(R.id.operator_info_class_icon);

            operatorRarity = itemView.findViewById(R.id.operator_info_rarity);
            operatorArchetypeAndClass = itemView.findViewById(R.id.operator_info_type_class);
            operatorTags = itemView.findViewById(R.id.operator_info_tags);
        }

        public void bind(OperatorWrapper operatorWrapper) {
            operatorPortraitCollapsed.setImageResource(
                    operatorWrapper.getOperator().getPortraitDrawableID());
            operatorPortraitCollapsed.setClipToOutline(true);

            operatorPortraitExpanded.setImageResource(
                    operatorWrapper.getOperator().getPortraitDrawableID());
            operatorPortraitExpanded.setClipToOutline(true);

            operatorName.setText(operatorWrapper.getOperator().getOperatorName());
            operatorRarity.setText(operatorRarity.getContext()
                    .getString(R.string.tv_operator_info_rarity, operatorWrapper.getOperator().getRarity()));

            operatorArchetypeAndClass.setText(Stream.of(
                    operatorWrapper.getOperator().getOperatorArchetype(),
                    operatorWrapper.getOperator().getOperatorClass())
                    .collect(Collectors.joining(" ")));

            operatorTags.setText(Stream.of(
                    "Tags:",
                    operatorWrapper.getOperator().getQualification(),
                    operatorWrapper.getOperator().getAttackType(),
                    operatorWrapper.getOperator().getAffix1(),
                    operatorWrapper.getOperator().getAffix2(),
                    operatorWrapper.getOperator().getAffix3())
                    .filter(s -> s != null && !s.isEmpty())
                    .collect(Collectors.joining("\n")));

            operatorArchetypeIcon.setImageResource(
                    operatorWrapper.getOperator().getArchetypeIconDrawableID());

            operatorClassIcon.setImageResource(
                    operatorWrapper.getOperator().getClassIconDrawableID());

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

            expandedOperatorInfo.setVisibility
                    (operatorWrapper.isExpanded() ? View.VISIBLE : View.GONE);

            operatorPortraitCollapsed.setVisibility
                    (operatorWrapper.isExpanded() ? View.GONE : View.VISIBLE);

            expandOperatorInfoButton.animate()
                    .setDuration(200)
                    .rotation(operatorWrapper.isExpanded() ? 180 : 0);
        }
    }
}
