package com.accep7.arknightshelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

@Deprecated
//Was used as adapter for a ListView in one of the early versions. Deprecated since now RecyclerView is used instead.
public class OperatorAdapter extends ArrayAdapter<OperatorWrapper> {

    public OperatorAdapter(Context context) {
        super(context, 0);
    }

/*    public boolean contains(RecruitmentPool.RecruitableOperator recruitableOperator) {
        for (int i = 0; i < getCount(); i++) {
            if (getItem(i).equals(recruitableOperator)) {
                return true;
            }
        }
        return false;
    }*/

    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView operatorName = convertView.findViewById(R.id.operatorName);
        TextView showSelectedTags = convertView.findViewById(R.id.selectedTag);
        OperatorWrapper operatorWrapper = getItem(position);
        operatorName.setText(operatorWrapper.getOperator().operatorName);
        String selectedTags = convertList(operatorWrapper.getSelectedTagsList());
        showSelectedTags.setText(selectedTags);
        return convertView;
    }

    private String convertList(List<String> selectedTagsList) {
        String converted = "";
        for (String selectedTag : selectedTagsList) {
            converted = selectedTag + " " + converted;
        }
        return converted;
    }

    public int getPosition(RecruitmentPool.RecruitableOperator operator) {
        for (int i = 0; i < getCount(); i++) {
            if (getItem(i).getOperator().equals(operator)) {
                return i;
            }
        }
        return -1;
    }
}
