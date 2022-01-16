package com.accep7.arknightshelper;

import com.accep7.arknightshelper.RecruitmentPool.RecruitableOperator;

import java.util.ArrayList;
import java.util.List;

public class ItemRecycler implements Comparable<ItemRecycler> {
    private final List<String> tagList;
    private final List<RecruitableOperator> operatorList = new ArrayList<>();

    public ItemRecycler(List<String> tagList, RecruitableOperator operator) {
        this.tagList = tagList;
        operatorList.add(operator);
    }

    public List<String> getTagList() {
        return tagList;
    }

    public List<RecruitableOperator> getOperatorList() {
        return operatorList;
    }

    public void addOperator(RecruitableOperator operator) {
        if (!operatorList.contains(operator)) {
            operatorList.add(operator);
        }
        operatorList.sort((operator1, operator2) -> operator2.rarity - operator1.rarity);
    }

    @Override
    public int compareTo(ItemRecycler itemRecycler) {
        return Integer.compare(itemRecycler.tagList.size(), this.tagList.size());
    }
}
