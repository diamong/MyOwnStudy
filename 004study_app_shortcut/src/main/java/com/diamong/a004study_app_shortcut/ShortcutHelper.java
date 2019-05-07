package com.diamong.a004study_app_shortcut;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class ShortcutHelper {
    private static final String TAG = MainActivity.TAG;
    private static final String EXTRA_LAST_REFRESH = "com.diamong.a004study_app_shortcut.EXTRA_LAST_REFRESH";
    private static final long REFRESH_INTERVAL_MS = 60 * 60 * 1000;
    private final Context mContext;
    private final ShortcutManager mShortcutManager;

    @TargetApi(Build.VERSION_CODES.N_MR1)
    @RequiresApi(api = Build.VERSION_CODES.M)
    public ShortcutHelper(Context context) {
        this.mContext = context;
        this.mShortcutManager = mContext.getSystemService(ShortcutManager.class);
    }
}
