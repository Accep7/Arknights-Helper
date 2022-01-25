package com.accep7.arknightshelper;

import java.util.ArrayList;
import java.util.List;

// Inner recycler that adds elements (operators) to a larger group recycler (tag groups)
public class OperatorRecycler implements Comparable<OperatorRecycler> {
    private final List<String> tagList;
    private final List<OperatorWrapper> operatorList = new ArrayList<>();

    public OperatorRecycler(List<String> tagList, OperatorWrapper operator) {
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
    }

    public void sortByRarity() {
        operatorList.sort((operator1, operator2) ->
                operator2.getOperator().getRarity() - operator1.getOperator().getRarity());
    }

    @Override
    public int compareTo(OperatorRecycler operatorRecycler) {
        return Integer.compare(operatorRecycler.tagList.size(), this.tagList.size());
    }
}
