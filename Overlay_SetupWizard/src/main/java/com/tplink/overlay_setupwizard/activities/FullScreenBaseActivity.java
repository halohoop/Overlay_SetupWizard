/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * FullScreenBaseActivity.java
 *
 * Full screen activity
 *
 * Author huanghaiqi, Created at 2016-11-18
 *
 * Ver 1.0, 2016-11-18, huanghaiqi, Create file.
 */

package com.tplink.overlay_setupwizard.activities;

import com.tplink.overlay_setupwizard.utils.ActivityAnimUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class FullScreenBaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode,
                                       Bundle options) {
        super.startActivityForResult(intent, requestCode, ActivityAnimUtils.getOptions(this).toBundle());
    }
}
