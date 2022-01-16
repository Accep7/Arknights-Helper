package com.accep7.arknightshelper;

import static com.accep7.arknightshelper.RecruitmentPool.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupRecycler {
    public static List<ItemRecycler> getEntries(List<String> tags) {
        List<ItemRecycler> result = new ArrayList<>();
        for (RecruitableOperator operator : recruitableOperators) {
            if (operator.isExpandedDetails()) {
                operator.setExpandedDetails(false);
            }
            if (!tags.contains(QUALIFICATION_TOP) && operator.qualification != null &&
                    operator.qualification.equals(QUALIFICATION_TOP)) {
                continue;
            }
            List<String> intersectedTags = intersection(tags, operator.getTags());
            if (!intersectedTags.isEmpty()) {
                addOperator(result, intersectedTags, operator);
            }
        }
        Collections.sort(result);
        return result;
    }

    private static List<String> intersection(List<String> firstList, List<String> secondList) {
        List<String> result = new ArrayList<>();
        for (String string : firstList) {
            if (secondList.contains(string)) {
                result.add(string);
            }
        }
        return result;
    }

    private static void addOperator(List<ItemRecycler> resultList, List<String> tags,
                                    RecruitableOperator operator) {
        boolean added = false;
        for (int i = 0; i < resultList.size(); i++) {
            if (!tags.contains(RecruitmentPool.QUALIFICATION_TOP) && operator.qualification != null
                    && operator.qualification.equals(QUALIFICATION_TOP)) {
                added = true;
                continue;
            }
            ItemRecycler itemRecycler = resultList.get(i);
            if (itemRecycler.getTagList().equals(tags)) {
                itemRecycler.addOperator(operator);
                added = true;
            }
            if (tags.size() > 1) {
                for (String tag : tags) {
                    addOperator(resultList, Collections.singletonList(tag), operator);
                }
            }
        }
        if (!added) {
            resultList.add(new ItemRecycler(tags, operator));
        }
    }
}
