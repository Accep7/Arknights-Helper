package com.accep7.arknightshelper;

import java.util.Objects;

@Deprecated
public class OperatorWrapper {
    private final RecruitableOperator operator;
    private boolean isExpanded = false;

    public OperatorWrapper(RecruitableOperator operator) {
        this.operator = operator;
    }

    public RecruitableOperator getOperator() {
        return operator;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public boolean isExpanded() {
        return isExpanded;
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
        return Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}
