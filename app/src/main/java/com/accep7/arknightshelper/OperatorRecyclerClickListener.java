package com.accep7.arknightshelper;

import android.os.SystemClock;
import android.view.View;

// Prevents ddos-clicking on recycler element, thus causing app crash with IllegalArgumentException
public abstract class OperatorRecyclerClickListener implements View.OnClickListener {

    private static final long MIN_CLICK_INTERVAL = 400;
    private long mLastClickTime;

    public abstract void onSingleClick(View v);

    @Override
    public final void onClick(View v) {
        long currentClickTime = SystemClock.uptimeMillis();
        long elapsedTime = currentClickTime - mLastClickTime;
        mLastClickTime = currentClickTime;
        if (elapsedTime <= MIN_CLICK_INTERVAL)
            return;
        onSingleClick(v);
    }
}