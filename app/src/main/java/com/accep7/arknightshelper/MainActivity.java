package com.accep7.arknightshelper;

import static com.accep7.arknightshelper.RecruitmentPool.*;

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

    private int activeButtonCounter = 0;

    private Button resetButton;

    private ConstraintLayout resultsLayout;
    private GroupRecyclerViewAdapter groupAdapter;
    private final RecyclerView.LayoutManager groupLayout = new LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false);

    /* This list is used for purposes of filtering the RecruitmentPool ArrayList and UX features,
     * such as locking other buttons when 5 of them already pressed. */
    private final List<ToggleButton> buttons = new ArrayList<>();

    // Button logic and initialization
    private void initToggleButton(int buttonId, String tag) {
        ToggleButton tb = findViewById(buttonId);
        tb.setText(tag);
        tb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                activeButtonCounter++;
                setSelectedFilterCounter();
                showResults();
                lockExcessFilters((ToggleButton) buttonView);
            } else {
                activeButtonCounter--;
                setSelectedFilterCounter();
                hideResults();
                unlockExcessFilters();
            }
            filterRecruitmentPool();
        });
        buttons.add(tb);
    }

    private void filterRecruitmentPool() {
        List<String> selectedTags = new ArrayList<>();
        for (ToggleButton toggleButton : buttons) {
            if (toggleButton.isChecked()) {
                selectedTags.add(toggleButton.getText().toString());
            }
        }
        groupAdapter.addAll(GroupRecycler.createResults(selectedTags));
//        new Thread(() -> {
//            List<OperatorRecycler> results = GroupRecycler.createResults(selectedTags);
//            new Handler(Looper.getMainLooper()).post(() -> groupAdapter.addAll(results));
//        }).start();
    }

    /* UX feature - When 5th button is checked, this method iterates over a list of buttons and locks
     * all other unchecked buttons. setAlpha is used to visually differentiate locked buttons. */
    private void lockExcessFilters(ToggleButton toggleButton) {
        if (activeButtonCounter == 5) {
            Toast.makeText(toggleButton.getContext(),
                    "You can only select a maximum of 5 tags. Other tags are locked now",
                    Toast.LENGTH_LONG).show();
            for (ToggleButton button : buttons) {
                if (!button.isChecked()) {
                    button.setEnabled(false);
                    button.getBackground().setAlpha(64);
                }
            }
        }
    }

    // UX feature - unlocks all other buttons when less than 5 buttons are pressed
    private void unlockExcessFilters() {
        if (activeButtonCounter < 5) {
            for (ToggleButton toggleButton : buttons) {
                if (!toggleButton.isChecked()) {
                    toggleButton.setEnabled(true);
                    toggleButton.getBackground().setAlpha(255);
                }
            }
        }
    }

    // UX feature - displays current number of active tags on reset button
    private void setSelectedFilterCounter() {
        resetButton.setText(resetButton.getContext().getString(R.string.reset_button_counter, activeButtonCounter));
    }

    private void showResults() {
        resultsLayout.setVisibility(View.VISIBLE);
    }

    private void hideResults() {
        if (activeButtonCounter == 0) {
            resultsLayout.setVisibility(View.GONE);
        }
    }

    /* Big red Reset button that iterates over list of buttons and returns checked buttons to their
     * initial unchecked state */
    private void resetSelection() {
        groupAdapter.clearAdapter();
        for (ToggleButton toggleButton : buttons) {
            if (toggleButton.isChecked()) {
                toggleButton.setChecked(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Filter Buttons
        initToggleButton(R.id.button_qualification_starter, QUALIFICATION_STARTER);
        initToggleButton(R.id.button_qualification_senior, QUALIFICATION_SENIOR);
        initToggleButton(R.id.button_qualification_top, QUALIFICATION_TOP);

        initToggleButton(R.id.button_attack_type_melee, ATTACK_TYPE_MELEE);
        initToggleButton(R.id.button_attack_type_ranged, ATTACK_TYPE_RANGED);

        initToggleButton(R.id.button_class_guard, CLASS_GUARD);
        initToggleButton(R.id.button_class_specialist, CLASS_SPECIALIST);
        initToggleButton(R.id.button_class_sniper, CLASS_SNIPER);
        initToggleButton(R.id.button_class_caster, CLASS_CASTER);
        initToggleButton(R.id.button_class_defender, CLASS_DEFENDER);
        initToggleButton(R.id.button_class_medic, CLASS_MEDIC);
        initToggleButton(R.id.button_class_vanguard, CLASS_VANGUARD);
        initToggleButton(R.id.button_class_supporter, CLASS_SUPPORTER);

        initToggleButton(R.id.button_affix_healing, AFFIX_HEALING);
        initToggleButton(R.id.button_affix_defense, AFFIX_DEFENSE);
        initToggleButton(R.id.button_affix_slow, AFFIX_SLOW);
        initToggleButton(R.id.button_affix_dp_recovery, AFFIX_DP_RECOVERY);
        initToggleButton(R.id.button_affix_aoe, AFFIX_AOE);
        initToggleButton(R.id.button_affix_dps, AFFIX_DPS);
        initToggleButton(R.id.button_affix_survival, AFFIX_SURVIVAL);
        initToggleButton(R.id.button_affix_shift, AFFIX_SHIFT);
        initToggleButton(R.id.button_affix_support, AFFIX_SUPPORT);
        initToggleButton(R.id.button_affix_debuff, AFFIX_DEBUFF);
        initToggleButton(R.id.button_affix_fast_redeploy, AFFIX_FAST_REDEPLOY);
        initToggleButton(R.id.button_affix_robot, AFFIX_ROBOT);
        initToggleButton(R.id.button_affix_summon, AFFIX_SUMMON);
        initToggleButton(R.id.button_affix_cc, AFFIX_CROWD_CONTROL);
        initToggleButton(R.id.button_affix_nuker, AFFIX_NUKER);
        //endregion

        resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(v -> resetSelection());

        resultsLayout = findViewById(R.id.results_layout);
        RecyclerView results = findViewById(R.id.parent_recycler);

        groupAdapter = new GroupRecyclerViewAdapter();

        results.setAdapter(groupAdapter);
        results.setLayoutManager(groupLayout);
    }
}