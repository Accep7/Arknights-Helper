package com.accep7.arknightshelper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JustBucket on 31.01.2022
 */
public class ExpandItemAnimator extends DefaultItemAnimator {

    private static final float TRANSPARENT_ALPHA = 0.0f;
    private static final float VISIBLE_ALPHA = 1.0f;
    private static final String ALPHA_PROPERTY_NAME = "alpha";
    private static final TimeInterpolator interpolator = new AccelerateDecelerateInterpolator();

    private final Map<RecyclerView.ViewHolder, AnimatorSet> animationMap = new HashMap<>();

    @Override
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder) {
        return true;
    }


    @NonNull
    @Override
    public ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView.State state,
                                                     @NonNull RecyclerView.ViewHolder viewHolder,
                                                     int changeFlags,
                                                     @NonNull List<Object> payloads) {
        if (changeFlags == RecyclerView.ItemAnimator.FLAG_CHANGED) {
            for (Object payload : payloads) {
                if (payload instanceof ExpandedInfo) {
                    return ((ExpandedInfo) payload);
                }
            }
        }
        return super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads);
    }

    @Override
    public void endAnimation(RecyclerView.ViewHolder item) {
        super.endAnimation(item);
        AnimatorSet set = animationMap.get(item);
        if (set != null) {
            set.cancel();
        }
    }

    @Override
    public void endAnimations() {
        super.endAnimations();
        for (AnimatorSet value : animationMap.values()) {
            if (value != null) {
                value.cancel();
            }
        }
    }

    @Override
    public boolean animateChange(@NonNull RecyclerView.ViewHolder oldHolder,
                                 @NonNull RecyclerView.ViewHolder newHolder,
                                 @NonNull ItemHolderInfo preInfo,
                                 @NonNull ItemHolderInfo postInfo) {
        cancelCurrentAnimationIfExists(newHolder);
        if (preInfo instanceof ExpandedInfo) {
            OperatorRecyclerViewAdapter.OperatorHolder holder = (OperatorRecyclerViewAdapter.OperatorHolder) newHolder;
            ExpandedInfo info = (ExpandedInfo) preInfo;
            if (info.expanded) {
                animateExpand(holder);
            } else {
                animateCollapse(holder);
            }
        }
        return false;
    }

    private void animateExpand(OperatorRecyclerViewAdapter.OperatorHolder holder) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                holder.expandedOperatorInfo,
                ALPHA_PROPERTY_NAME,
                TRANSPARENT_ALPHA,
                VISIBLE_ALPHA
        );
        animator.setDuration(getAddDuration());
        animator.setStartDelay(getAddDuration());
        animator.setInterpolator(interpolator);
        set.play(animator);
        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animationMap.remove(holder);
                dispatchChangeFinishedIfAllAnimationsEnded(holder);
            }
        });
        set.start();
        animationMap.put(holder, set);
    }

    private void animateCollapse(OperatorRecyclerViewAdapter.OperatorHolder holder) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                holder.expandedOperatorInfo,
                ALPHA_PROPERTY_NAME,
                VISIBLE_ALPHA,
                TRANSPARENT_ALPHA
        );
        animator.setDuration(getAddDuration());
        animator.setStartDelay(getAddDuration());
        animator.setInterpolator(interpolator);
        set.play(animator);
        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animationMap.remove(holder);
                dispatchChangeFinishedIfAllAnimationsEnded(holder);
            }
        });
        set.start();
        animationMap.put(holder, set);
    }

    private void dispatchChangeFinishedIfAllAnimationsEnded(RecyclerView.ViewHolder holder) {
        if (!animationMap.containsKey(holder)) {
            dispatchAnimationFinished(holder);
        }
    }

    private void cancelCurrentAnimationIfExists(@NonNull RecyclerView.ViewHolder viewHolder) {
        AnimatorSet set = animationMap.get(viewHolder);
        if (set != null) {
            set.cancel();
        }
    }

    static final class ExpandedInfo extends RecyclerView.ItemAnimator.ItemHolderInfo {

        private final boolean expanded;

        public ExpandedInfo(boolean expanded) {
            this.expanded = expanded;
        }

        public boolean isExpanded() {
            return expanded;
        }
    }
}
