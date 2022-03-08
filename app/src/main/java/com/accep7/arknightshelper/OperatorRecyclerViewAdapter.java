package com.accep7.arknightshelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Group;
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
        view.setOnClickListener(new OperatorRecyclerClickListener() {
            @Override
            public void onSingleClick(View v) {
                OperatorWrapper item = operators.get(operatorHolder.getAdapterPosition());
                item.setExpanded(!item.isExpanded());
                notifyItemChanged(operatorHolder.getAdapterPosition());
            }
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

        Group expandableOperatorInfo;

        ImageView expandInfoButton, operatorPortrait, operatorPortraitExpanded,
                operatorArchetypeIcon, operatorClassIcon;
        TextView operatorInfoRarity, operatorInfoArchetypeAndClass, operatorInfoTags;

        public OperatorHolder(@NonNull View itemView) {
            super(itemView);
            operatorInfo = itemView.findViewById(R.id.recycler_item);
            operatorName = itemView.findViewById(R.id.operator_name);
            expandInfoButton = itemView.findViewById(R.id.expand_button);
            expandableOperatorInfo = itemView.findViewById(R.id.operator_info_expanded);

            operatorPortrait = itemView.findViewById(R.id.operator_portrait);
            operatorPortraitExpanded = itemView.findViewById(R.id.operator_portrait_expanded);
            operatorArchetypeIcon = itemView.findViewById(R.id.operator_info_archetype_icon);
            operatorClassIcon = itemView.findViewById(R.id.operator_info_class_icon);

            operatorInfoRarity = itemView.findViewById(R.id.operator_info_rarity);
            operatorInfoArchetypeAndClass = itemView.findViewById(R.id.operator_info_type_class);
            operatorInfoTags = itemView.findViewById(R.id.operator_info_tags);
        }

        public void bind(OperatorWrapper operatorWrapper) {
            operatorPortrait.setImageResource(
                    operatorWrapper.getOperator().getPortraitDrawableID());
            operatorPortrait.setClipToOutline(true);

            operatorPortraitExpanded.setImageResource(
                    operatorWrapper.getOperator().getPortraitDrawableID());
            operatorPortraitExpanded.setClipToOutline(true);

            operatorName.setText(operatorWrapper.getOperator().getOperatorName());
            operatorInfoRarity.setText(operatorInfoRarity.getContext()
                    .getString(R.string.tv_operator_info_rarity, operatorWrapper.getOperator().getRarity()));

            operatorInfoArchetypeAndClass.setText(Stream.of(
                    operatorWrapper.getOperator().getOperatorArchetype(),
                    operatorWrapper.getOperator().getOperatorClass())
                    .collect(Collectors.joining(" ")));

            operatorInfoTags.setText(Stream.of(
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

            expandableOperatorInfo.setVisibility(operatorWrapper.isExpanded() ? View.VISIBLE : View.GONE);
            operatorPortrait.setVisibility(operatorWrapper.isExpanded() ? View.GONE : View.VISIBLE);
            expandInfoButton.animate().setDuration(200).rotation(operatorWrapper.isExpanded() ? 180 : 0);
        }
    }
}
