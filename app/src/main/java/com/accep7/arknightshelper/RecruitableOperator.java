package com.accep7.arknightshelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class RecruitableOperator {
    private final String operatorName;
    private final String attackType;
    private final String qualification;
    private final int rarity;
    private final String operatorArchetype;
    private final String operatorClass;
    private final String affix1;
    private final String affix2;
    private final String affix3;
    private final int archetypeIconDrawableID;
    private final int classIconDrawableID;
    private final int portraitDrawableID;

    RecruitableOperator(String operatorName, String attackType, String qualification, int rarity,
                        String operatorArchetype, String operatorClass, String affix1, String affix2, String affix3,
                        int archetypeIconDrawableID, int classIconDrawableID, int portraitDrawableID) {
        this.operatorName = operatorName;
        this.attackType = attackType;
        this.qualification = qualification;
        this.rarity = rarity;
        this.operatorArchetype = operatorArchetype;
        this.operatorClass = operatorClass;
        this.affix1 = affix1;
        this.affix2 = affix2;
        this.affix3 = affix3;
        this.archetypeIconDrawableID = archetypeIconDrawableID;
        this.classIconDrawableID = classIconDrawableID;
        this.portraitDrawableID = portraitDrawableID;
    }

    public List<String> getOperatorTags() {
        List<String> result = new ArrayList<>();
        result.add(attackType);
        result.add(qualification);
        result.add("" + rarity);
        result.add(operatorClass);
        result.add(affix1);
        result.add(affix2);
        result.add(affix3);
        return result;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getAttackType() {
        return attackType;
    }

    public String getQualification() {
        return qualification;
    }

    public int getRarity() {
        return rarity;
    }

    public String getOperatorArchetype() {
        return operatorArchetype;
    }

    public String getOperatorClass() {
        return operatorClass;
    }

    public String getAffix1() {
        return affix1;
    }

    public String getAffix2() {
        return affix2;
    }

    public String getAffix3() {
        return affix3;
    }

    public int getArchetypeIconDrawableID() {
        return archetypeIconDrawableID;
    }

    public int getClassIconDrawableID() {
        return classIconDrawableID;
    }

    public int getPortraitDrawableID() {
        return portraitDrawableID;
    }

    @Override
    @NonNull
    public String toString() {
        return "RecruitableOperator{" +
                "name='" + operatorName + '\'' +
                ", attackType='" + attackType + '\'' +
                ", tv_operator_qualification='" + qualification + '\'' +
                ", rarity=" + rarity +
                ", tv_operator_class='" + operatorArchetype + '\'' +
                ", tv_operator_class='" + operatorClass + '\'' +
                ", affix1='" + affix1 + '\'' +
                ", affix2='" + affix2 + '\'' +
                ", affix3='" + affix3 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecruitableOperator that = (RecruitableOperator) o;
        return rarity == that.rarity && Objects.equals(operatorName, that.operatorName) &&
                Objects.equals(attackType, that.attackType) &&
                Objects.equals(qualification, that.qualification) &&
                Objects.equals(operatorClass, that.operatorClass) &&
                Objects.equals(affix1, that.affix1) && Objects.equals(affix2, that.affix2) &&
                Objects.equals(affix3, that.affix3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operatorName, attackType, qualification, rarity, operatorClass,
                affix1, affix2, affix3);
    }
}