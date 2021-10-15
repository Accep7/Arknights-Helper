package com.accep7.arknightshelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OperatorWrapper {
    private final RecruitmentPool.RecruitableOperator operator;
    private final List<String> selectedTagsList = new ArrayList<>();
    private boolean isExpanded;

    public OperatorWrapper(RecruitmentPool.RecruitableOperator operator) {
        this.operator = operator;
    }

    public RecruitmentPool.RecruitableOperator getOperator() {
        return operator;
    }

    public List<String> getSelectedTagsList() {
        return selectedTagsList;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    //When multiple tags selected, they will be printed on the left side of a ListItem
    public String tagsToString() {
        String multipleMatchedTags = "";
        for (String selectedTag : selectedTagsList) {
            multipleMatchedTags = selectedTag + "\n" + multipleMatchedTags;
        }
        return multipleMatchedTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OperatorWrapper that = (OperatorWrapper) o;
        return Objects.equals(operator, that.operator) && Objects.equals(selectedTagsList, that.selectedTagsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, selectedTagsList);
    }
}
