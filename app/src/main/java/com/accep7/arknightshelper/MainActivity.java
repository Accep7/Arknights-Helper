package com.accep7.arknightshelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declaring views and buttons. This int is used to keep a track of active buttons.
    private int activeTagCounter = 0;

    private Button resetButton;

    private ConstraintLayout resultsLayout;
    private GroupRecyclerViewAdapter groupAdapter;
    private final RecyclerView.LayoutManager groupLayout = new LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false);

    /* This hashmap is used to iterate over for purposes of filtering the RecruitmentPool ArrayList
     * and locking excess buttons.
     * OperatorPredicate is used to assign each button to its corresponding filtering parameter.
     * E.g. "Melee" toggle button is paired with String type "ATTACK_TYPE_MELEE" predicate.
     * Pressing "Melee" button will output all of the operators with "ATTACK_TYPE_MELEE". */
    private final HashMap<ToggleButton, OperatorPredicate> buttonLockAndReset = new HashMap<>();

    //Button behaviour and initialization
    private void initToggleButton(int buttonId, OperatorPredicate filteringParameter) {
        ToggleButton tb = findViewById(buttonId);
        tb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                activeTagCounter++;
                setSelectedFilterCounter();
                showResults();
                lockExcessFilters((ToggleButton) buttonView);
            } else {
                activeTagCounter--;
                setSelectedFilterCounter();
                hideResults();
                unlockExcessFilters();
            }
            filterRecruitmentPool();
        });
        buttonLockAndReset.put(tb, filteringParameter);
    }

    //Filtering the RecruitmentPool ArrayList, and passing filtered contents to the RecyclerView
    private void filterRecruitmentPool() {
        groupAdapter.clearItems();
        List<String> selectedTags = new ArrayList<>();
        for (ToggleButton toggleButton : buttonLockAndReset.keySet()) {
            if (toggleButton.isChecked()) {
                selectedTags.add(toggleButton.getText().toString());
            }
        }
        groupAdapter.addAll(GroupRecycler.getEntries(selectedTags));
    }

    /* UX feature - When 5th button is checked, this method iterates over Map of buttons and locks
     * all other unchecked buttons. setAlpha is used to visually differentiate locked buttons. */
    private void lockExcessFilters(ToggleButton toggleButton) {
        if (activeTagCounter == 5) {
            Toast.makeText(toggleButton.getContext(),
                    "You can only select a maximum of 5 tags. Other tags are locked now",
                    Toast.LENGTH_LONG).show();
            for (ToggleButton button : buttonLockAndReset.keySet()) {
                if (!button.isChecked()) {
                    button.setEnabled(false);
                    button.getBackground().setAlpha(64);
                }
            }
        }
    }

    // UX feature - unlocks all other buttons when less than 5 buttons are pressed
    private void unlockExcessFilters() {
        if (activeTagCounter < 5) {
            for (ToggleButton toggleButton : buttonLockAndReset.keySet()) {
                if (!toggleButton.isChecked()) {
                    toggleButton.setEnabled(true);
                    toggleButton.getBackground().setAlpha(255);
                }
            }
        }
    }

    // UX feature - displays current number of active tags on reset button
    protected void setSelectedFilterCounter() {
        resetButton.setText(resetButton.getContext().getString(R.string.resetButtonCounter, activeTagCounter));
    }

    protected void showResults() {
        resultsLayout.setVisibility(View.VISIBLE);
    }

    protected void hideResults() {
        if (activeTagCounter == 0) {
            resultsLayout.setVisibility(View.GONE);
        }
    }


    /* Big red Reset button that iterates over Map of buttons and returns checked buttons to their
    * initial unchecked state */
    private void resetSelection() {
        for (ToggleButton toggleButton : buttonLockAndReset.keySet()) {
            if (toggleButton.isChecked()) {
                toggleButton.setChecked(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Results views and Reset selection Button
        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(v -> resetSelection());
        resultsLayout = findViewById(R.id.resultsLayout);

        //region Qualification Filter Buttons
        initToggleButton(R.id.qualification_starter, operator ->
                RecruitmentPool.QUALIFICATION_STARTER.equals(operator.qualification));
        initToggleButton(R.id.qualification_seniorOp, operator ->
                RecruitmentPool.QUALIFICATION_SENIOR.equals(operator.qualification));
        initToggleButton(R.id.qualification_topOp, operator ->
                RecruitmentPool.QUALIFICATION_TOP.equals(operator.qualification));
        //endregion

        //region Attack type Filter Buttons
        initToggleButton(R.id.atk_type_melee, operator ->
                operator.attackType.equals(RecruitmentPool.ATTACK_TYPE_MELEE));
        initToggleButton(R.id.atk_type_ranged, operator ->
                operator.attackType.equals(RecruitmentPool.ATTACK_TYPE_RANGED));
        //endregion

        //region Class Filter Buttons
        initToggleButton(R.id.class_guard, operator ->
                operator.inGameClass.equals(RecruitmentPool.CLASS_GUARD));
        initToggleButton(R.id.class_specialist, operator ->
                operator.inGameClass.equals(RecruitmentPool.CLASS_SPECIALIST));
        initToggleButton(R.id.class_sniper, operator ->
                operator.inGameClass.equals(RecruitmentPool.CLASS_SNIPER));
        initToggleButton(R.id.class_caster, operator ->
                operator.inGameClass.equals(RecruitmentPool.CLASS_CASTER));
        initToggleButton(R.id.class_defender, operator ->
                operator.inGameClass.equals(RecruitmentPool.CLASS_DEFENDER));
        initToggleButton(R.id.class_medic, operator ->
                operator.inGameClass.equals(RecruitmentPool.CLASS_MEDIC));
        initToggleButton(R.id.class_vanguard, operator ->
                operator.inGameClass.equals(RecruitmentPool.CLASS_VANGUARD));
        initToggleButton(R.id.class_supporter, operator ->
                operator.inGameClass.equals(RecruitmentPool.CLASS_SUPPORTER));
        //endregion

        //region Affix Filter Buttons
        initToggleButton(R.id.affix_healing, operator ->
                RecruitmentPool.AFFIX_HEALING.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_HEALING.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_HEALING.equals(operator.affix3));

        initToggleButton(R.id.affix_defense, operator ->
                RecruitmentPool.AFFIX_DEFENSE.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_DEFENSE.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_DEFENSE.equals(operator.affix3));

        initToggleButton(R.id.affix_slow, operator ->
                RecruitmentPool.AFFIX_SLOW.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_SLOW.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_SLOW.equals(operator.affix3));

        initToggleButton(R.id.affix_dprec, operator ->
                RecruitmentPool.AFFIX_DP_RECOVERY.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_DP_RECOVERY.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_DP_RECOVERY.equals(operator.affix3));

        initToggleButton(R.id.affix_aoe, operator ->
                RecruitmentPool.AFFIX_AOE.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_AOE.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_AOE.equals(operator.affix3));

        initToggleButton(R.id.affix_dps, operator ->
                RecruitmentPool.AFFIX_DPS.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_DPS.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_DPS.equals(operator.affix3));

        initToggleButton(R.id.affix_survival, operator ->
                RecruitmentPool.AFFIX_SURVIVAL.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_SURVIVAL.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_SURVIVAL.equals(operator.affix3));

        initToggleButton(R.id.affix_shift, operator ->
                RecruitmentPool.AFFIX_SHIFT.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_SHIFT.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_SHIFT.equals(operator.affix3));

        initToggleButton(R.id.affix_support, operator ->
                RecruitmentPool.AFFIX_SUPPORT.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_SUPPORT.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_SUPPORT.equals(operator.affix3));

        initToggleButton(R.id.affix_debuff, operator ->
                RecruitmentPool.AFFIX_DEBUFF.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_DEBUFF.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_DEBUFF.equals(operator.affix3));

        initToggleButton(R.id.affix_fastred, operator ->
                RecruitmentPool.AFFIX_FAST_REDEPLOY.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_FAST_REDEPLOY.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_FAST_REDEPLOY.equals(operator.affix3));

        initToggleButton(R.id.affix_robot, operator ->
                RecruitmentPool.AFFIX_ROBOT.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_ROBOT.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_ROBOT.equals(operator.affix3));

        initToggleButton(R.id.affix_summon, operator ->
                RecruitmentPool.AFFIX_SUMMON.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_SUMMON.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_SUMMON.equals(operator.affix3));

        initToggleButton(R.id.affix_cc, operator ->
                RecruitmentPool.AFFIX_CROWD_CONTROL.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_CROWD_CONTROL.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_CROWD_CONTROL.equals(operator.affix3));

        initToggleButton(R.id.affix_nuker, operator ->
                RecruitmentPool.AFFIX_NUKER.equals(operator.affix1)
                        || RecruitmentPool.AFFIX_NUKER.equals(operator.affix2)
                        || RecruitmentPool.AFFIX_NUKER.equals(operator.affix3));
        //endregion

        //Initializing filtered output views
        RecyclerView results = findViewById(R.id.recyclerview_group);
        groupAdapter = new GroupRecyclerViewAdapter();

        results.setAdapter(groupAdapter);
        results.setLayoutManager(groupLayout);

    }
}