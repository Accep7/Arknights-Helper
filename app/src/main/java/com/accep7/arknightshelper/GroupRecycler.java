package com.accep7.arknightshelper;

import static com.accep7.arknightshelper.RecruitmentPool.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GroupRecycler {

    //Represents the max amount of tags user can select in the game and create combinations from
    final static int MAX_TAG_COMBO = 3;

    static List<String> selectedTags;

    public static List<ItemRecycler> getEntries(List<String> tags) {
        //selectedTags.clear();
        selectedTags = tags;
        int sample = MAX_TAG_COMBO;
        List<ItemRecycler> result = new ArrayList<>();

        for (int i = 0; i < MAX_TAG_COMBO; i++) {
            List<String[]> combinations = generateTagCombinations(selectedTags.size(), sample);
            for (String[] combination : combinations) {
                List<String> combo = Arrays.asList(combination);
                for (RecruitableOperator operator : recruitableOperators) {
                    if (operator.isExpandedDetails()) {
                        operator.setExpandedDetails(false);
                    }
                    if (!combo.contains(QUALIFICATION_TOP) && operator.qualification != null &&
                            operator.qualification.equals(QUALIFICATION_TOP)) {
                        continue;
                    }
                    List<String> intersectedTags = intersection(combo, operator.getTags());
                    if (!intersectedTags.isEmpty()) {
                        addOperator(result, intersectedTags, operator);
                    }
                }
                Collections.sort(result);            }
            sample--;
        }
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
        }
        if (!added) {
            resultList.add(new ItemRecycler(tags, operator));
        }
    }

    private static void generator(List<String[]> combinations, String[] data, int start, int end, int index) {
        if (index == data.length) {
            String[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = selectedTags.get(start);
            generator(combinations, data, start + 1, end, index + 1);
            generator(combinations, data, start + 1, end, index);
        }
    }

    private static List<String[]> generateTagCombinations(int n, int r) {
        List<String[]> combinations = new ArrayList<>();
        generator(combinations, new String[r], 0, n - 1, 0);
        return combinations;
    }
}
