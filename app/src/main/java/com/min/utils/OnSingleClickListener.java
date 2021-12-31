package com.min.utils;

import android.os.SystemClock;
import android.view.View;

public abstract class OnSingleClickListener implements View.OnClickListener {
    private static final long CLICK_DELAY = 1000;
    private long mLastClickTime = 0;

    public abstract void onSingleClick(View v);

    @Override
    public void onClick(View v) {
        // 연속 클릭 방지
        if (SystemClock.elapsedRealtime() - mLastClickTime < CLICK_DELAY){
            return;
        }

        mLastClickTime = SystemClock.elapsedRealtime();
        onSingleClick(v);
    }
}