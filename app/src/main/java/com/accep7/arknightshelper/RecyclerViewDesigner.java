package com.accep7.arknightshelper;

import android.view.View;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

class RecyclerViewDesigner {

    protected void setListItemBackground(RecyclerViewAdapter.OperatorHolder holder,
                                         List<OperatorWrapper> operators, int position)  {

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

    protected void setOperatorDetails(RecyclerViewAdapter.OperatorHolder holder,
                                      List<OperatorWrapper> operators, int position) {

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
    }

    protected void setSelectedFilterCounter(Button button, int counter) {
        button.setText(button.getContext().getString(R.string.resetButton, counter));
    }

    protected void showResults(ConstraintLayout layout) {
        layout.setVisibility(View.VISIBLE);
    }

    protected void hideResults(ConstraintLayout layout, int counter) {
        if (counter == 0) {
            layout.setVisibility(View.GONE);
        }
    }
}
