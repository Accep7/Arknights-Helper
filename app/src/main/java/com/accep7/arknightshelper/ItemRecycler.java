package com.accep7.arknightshelper;

import java.util.ArrayList;
import java.util.List;

// Inner recycler that adds elements (operators) to a larger group recycler (tag groups)
public class ItemRecycler implements Comparable<ItemRecycler> {
    private final List<String> tagList;
    private final List<OperatorWrapper> operatorList = new ArrayList<>();

    public ItemRecycler(List<String> tagList, OperatorWrapper operator) {
        this.tagList = tagList;
        operatorList.add(operator);
    }

    public List<String> getTagList() {
        return tagList;
    }

    public List<OperatorWrapper> getOperatorList() {
        return operatorList;
    }

    public void addOperator(OperatorWrapper operator) {
        if (!operatorList.contains(operator)) {
            operatorList.add(operator);
        }
        operatorList.sort((operator1, operator2) -> operator2.getOperator().rarity - operator1.getOperator().rarity);
    }

    @Override
    public int compareTo(ItemRecycler itemRecycler) {
        return Integer.compare(itemRecycler.tagList.size(), this.tagList.size());
    }
}
