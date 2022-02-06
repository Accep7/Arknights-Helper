package com.accep7.arknightshelper;

import static com.accep7.arknightshelper.RecruitmentPool.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// External recycler, handles recruitment pool filtering logic and creation of tag groups of operators
public class GroupRecycler {

    // Represents the max amount of tags user can select in the game and create combinations from
    private final static int MAX_TAG_COMBO = 3;

    private static List<String> selectedTags;

    /**
     * The recruitment pool filtering algorithm is based on generating combinations from selected
     * tags. These combinations (also referred to as "groups" (GroupRecycler)) of operators are then
     * used to find operators from recruitment pool that have ALL of the tags in respective group.
     * Amount of combinations to be generated determined by nCr formula, more on that further below
     */
    public static List<ItemRecycler> createResults(List<String> tags) {
        selectedTags = tags;
        int sample = MAX_TAG_COMBO;
        List<ItemRecycler> result = new ArrayList<>();

        for (int i = 0; i < MAX_TAG_COMBO; i++) {
            List<String[]> combinations = makeTagCombinations(selectedTags.size(), sample);
            for (String[] combination : combinations) {
                List<String> combinationsList = Arrays.asList(combination);
                for (RecruitableOperator operator : recruitableOperators) {
                    /* Excludes top operators from results when top op tag is not selected, since
                     * they are not obtainable without this tag selected */
                    if (!combinationsList.contains(QUALIFICATION_TOP)
                            && operator.qualification != null
                            && operator.qualification.equals(QUALIFICATION_TOP)) {
                        continue;
                    }
                    List<String> intersectedTags = intersection(combinationsList, operator.getTags());
                    if (!intersectedTags.isEmpty()) {
                        addOperator(result, intersectedTags, operator);
                    }
                }
            }
            sample--;
        }
        for (ItemRecycler tagsGroup : result) {
            tagsGroup.sortByRarity();
        }
        Collections.sort(result);
        return result;
    }

    /**
     * Creates tag combination using nCr formula: n! / (r! * (n - r)! )
     * The formula show us the number of ways a sample of "r" elements can be obtained from a larger
     * set of "n" distinguishable objects where order does not matter and repetitions are not allowed.
     * "n" is the larger set, amount of tags selected by user, and "r" is the "sample" variable from
     * createResults method - it determines how many tags will be in generated combination. In case
     * of this algorithm, "r" belongs to a range from 1 to 3. When all possible combinations of three
     * tags are generated, "sample" is decremented and combinations of 2 tags are generated next.
     * In case when 5 tags are selected, n = 5, r = 3, 10 combinations will be generated, provided
     * there are element (item, operator) that can satisfy all of those 10 combinations.
     * In case with 5 tags, according to formula, 10 combinations of 3 tags, 10 combinations of 2,
     * and 5 groups of single tags will be generated, total of 25 groups.
     * To check this, select tags "Guard", "Melee", "Survival", "AoE", "Senior Operator"
     * Algorithm source: https://www.baeldung.com/java-combinations-algorithm
     */
    private static List<String[]> makeTagCombinations(int n, int r) {
        List<String[]> combinations = new ArrayList<>();
        generateCombination(combinations, new String[r], 0, n - 1, 0);
        return combinations;
    }

    /* Recursive algorithm to generate combinations.
     * The first call includes the current element.
     * The second call discards the current element */
    private static void generateCombination(List<String[]> combinations, String[] data, int start, int end, int index) {
        if (index == data.length) {
            String[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = selectedTags.get(start);
            generateCombination(combinations, data, start + 1, end, index + 1);
            generateCombination(combinations, data, start + 1, end, index);
        }
    }

    /**
     * Compares groups (lists) of selected tags (let's say we got AoE and Slow selected)
     * When an intersection is found (operators that have both AoE and Slow tags),
     * creates and returns a new corresponding group of items (operators), that consists
     * ONLY of operators with both AoE and Slow tags
     */
    private static List<String> intersection(List<String> firstList, List<String> secondList) {
        List<String> result = new ArrayList<>();
        for (String string : firstList) {
            if (secondList.contains(string)) {
                result.add(string);
            }
        }
        return result;
    }

    private static void addOperator(List<ItemRecycler> groupsList, List<String> tags,
                                    RecruitableOperator operator) {
        boolean added = false;
        for (int i = 0; i < groupsList.size(); i++) {
            ItemRecycler tagsGroup = groupsList.get(i);
            if (tagsGroup.getTagList().equals(tags)) {
                tagsGroup.addOperator(new OperatorWrapper(operator));
                added = true;
            }
        }
        if (!added) {
            groupsList.add(new ItemRecycler(tags, new OperatorWrapper(operator)));
        }
    }
}
