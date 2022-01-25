package com.accep7.arknightshelper;

import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_AOE;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_CROWD_CONTROL;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_DEBUFF;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_DEFENSE;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_DPS;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_DP_RECOVERY;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_FAST_REDEPLOY;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_HEALING;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_NUKER;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_ROBOT;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_SHIFT;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_SLOW;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_SUMMON;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_SUPPORT;
import static com.accep7.arknightshelper.RecruitmentPool.AFFIX_SURVIVAL;
import static com.accep7.arknightshelper.RecruitmentPool.ATTACK_TYPE_MELEE;
import static com.accep7.arknightshelper.RecruitmentPool.ATTACK_TYPE_RANGED;
import static com.accep7.arknightshelper.RecruitmentPool.CLASS_CASTER;
import static com.accep7.arknightshelper.RecruitmentPool.CLASS_DEFENDER;
import static com.accep7.arknightshelper.RecruitmentPool.CLASS_GUARD;
import static com.accep7.arknightshelper.RecruitmentPool.CLASS_MEDIC;
import static com.accep7.arknightshelper.RecruitmentPool.CLASS_SNIPER;
import static com.accep7.arknightshelper.RecruitmentPool.CLASS_SPECIALIST;
import static com.accep7.arknightshelper.RecruitmentPool.CLASS_SUPPORTER;
import static com.accep7.arknightshelper.RecruitmentPool.CLASS_VANGUARD;
import static com.accep7.arknightshelper.RecruitmentPool.QUALIFICATION_SENIOR;
import static com.accep7.arknightshelper.RecruitmentPool.QUALIFICATION_STARTER;
import static com.accep7.arknightshelper.RecruitmentPool.QUALIFICATION_TOP;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int activeTagCounter = 0;

    private Button resetButton;

    private ConstraintLayout resultsLayout;
    private GroupRecyclerViewAdapter groupAdapter;
    private final RecyclerView.LayoutManager groupLayout = new LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false);

    /* This list is used for purposes of filtering the RecruitmentPool ArrayList and UX features,
     * such as locking other buttons when 5 of them already pressed. */
    private final List<ToggleButton> buttonList = new ArrayList<>();

    // Button logic and initialization
    private void initToggleButton(int buttonId, String tag) {
        ToggleButton tb = findViewById(buttonId);
        tb.setText(tag);
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
        buttonList.add(tb);
    }

    private void filterRecruitmentPool() {
        List<String> selectedTags = new ArrayList<>();
        for (ToggleButton toggleButton : buttonList) {
            if (toggleButton.isChecked()) {
                selectedTags.add(toggleButton.getText().toString());
            }
        }
        groupAdapter.addAll(GroupRecycler.createResults(selectedTags));
        new Thread(() -> {
            List<OperatorRecycler> results = GroupRecycler.createResults(selectedTags);
            new Handler(Looper.getMainLooper()).post(() -> groupAdapter.addAll(results));
        }).start();
    }

    /* UX feature - When 5th button is checked, this method iterates over a list of buttons and locks
     * all other unchecked buttons. setAlpha is used to visually differentiate locked buttons. */
    private void lockExcessFilters(ToggleButton toggleButton) {
        if (activeTagCounter == 5) {
            Toast.makeText(toggleButton.getContext(),
                    "You can only select a maximum of 5 tags. Other tags are locked now",
                    Toast.LENGTH_LONG).show();
            for (ToggleButton button : buttonList) {
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
            for (ToggleButton toggleButton : buttonList) {
                if (!toggleButton.isChecked()) {
                    toggleButton.setEnabled(true);
                    toggleButton.getBackground().setAlpha(255);
                }
            }
        }
    }

    // UX feature - displays current number of active tags on reset button
    private void setSelectedFilterCounter() {
        resetButton.setText(resetButton.getContext().getString(R.string.resetButtonCounter, activeTagCounter));
    }

    private void showResults() {
        resultsLayout.setVisibility(View.VISIBLE);
    }

    private void hideResults() {
        if (activeTagCounter == 0) {
            resultsLayout.setVisibility(View.GONE);
        }
    }


    /* Big red Reset button that iterates over list of buttons and returns checked buttons to their
     * initial unchecked state */
    private void resetSelection() {
        for (ToggleButton toggleButton : buttonList) {
            if (toggleButton.isChecked()) {
                toggleButton.setChecked(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Results views and Reset selection Button
        resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(v -> resetSelection());
        resultsLayout = findViewById(R.id.results_layout);

        // Qualification Filter Buttons
        initToggleButton(R.id.qualification_starter, QUALIFICATION_STARTER);
        initToggleButton(R.id.qualification_senior_operator, QUALIFICATION_SENIOR);
        initToggleButton(R.id.qualification_top_operator, QUALIFICATION_TOP);

        // Attack type Filter Buttons
        initToggleButton(R.id.attack_type_melee, ATTACK_TYPE_MELEE);
        initToggleButton(R.id.attack_type_ranged, ATTACK_TYPE_RANGED);

        // Class Filter Buttons
        initToggleButton(R.id.class_guard, CLASS_GUARD);
        initToggleButton(R.id.class_specialist, CLASS_SPECIALIST);
        initToggleButton(R.id.class_sniper, CLASS_SNIPER);
        initToggleButton(R.id.class_caster, CLASS_CASTER);
        initToggleButton(R.id.class_defender, CLASS_DEFENDER);
        initToggleButton(R.id.class_medic, CLASS_MEDIC);
        initToggleButton(R.id.class_vanguard, CLASS_VANGUARD);
        initToggleButton(R.id.class_supporter, CLASS_SUPPORTER);

        //region Affix Filter Buttons
        initToggleButton(R.id.affix_healing, AFFIX_HEALING);
        initToggleButton(R.id.affix_defense, AFFIX_DEFENSE);
        initToggleButton(R.id.affix_slow, AFFIX_SLOW);
        initToggleButton(R.id.affix_dp_recovery, AFFIX_DP_RECOVERY);
        initToggleButton(R.id.affix_aoe, AFFIX_AOE);
        initToggleButton(R.id.affix_dps, AFFIX_DPS);
        initToggleButton(R.id.affix_survival, AFFIX_SURVIVAL);
        initToggleButton(R.id.affix_shift, AFFIX_SHIFT);
        initToggleButton(R.id.affix_support, AFFIX_SUPPORT);
        initToggleButton(R.id.affix_debuff, AFFIX_DEBUFF);
        initToggleButton(R.id.affix_fast_redeploy, AFFIX_FAST_REDEPLOY);
        initToggleButton(R.id.affix_robot, AFFIX_ROBOT);
        initToggleButton(R.id.affix_summon, AFFIX_SUMMON);
        initToggleButton(R.id.affix_cc, AFFIX_CROWD_CONTROL);
        initToggleButton(R.id.affix_nuker, AFFIX_NUKER);
        //endregion

        RecyclerView results = findViewById(R.id.recycler_view_group);
        groupAdapter = new GroupRecyclerViewAdapter();

        results.setAdapter(groupAdapter);
        results.setLayoutManager(groupLayout);

    }
}