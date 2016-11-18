/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * DeclareActivity.java
 *
 * A page to announces declaration.
 *
 * Author huanghaiqi, Created at 2016-11-18
 *
 * Ver 1.0, 2016-11-18, huanghaiqi, Create file.
 */

package com.tplink.overlay_setupwizard.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.setupwizardlib.SetupWizardLayout;
import com.android.setupwizardlib.util.ResultCodes;
import com.android.setupwizardlib.util.WizardManagerHelper;
import com.android.setupwizardlib.view.NavigationBar;
import com.tplink.overlay_setupwizard.R;

public class DeclareActivity extends FullScreenBaseActivity implements NavigationBar
        .NavigationBarListener, View.OnClickListener {

    private LayoutInflater mInflater;
    private NavigationBar mNavigationBar;
    private SetupWizardLayout mSetupWizardLayout;
    private TextView mTvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mSetupWizardLayout = (SetupWizardLayout) mInflater.inflate(R.layout.declare_layout, null);
        mNavigationBar = mSetupWizardLayout.getNavigationBar();
        mNavigationBar.setNavigationBarListener(this);
        mTvNote = (TextView) mSetupWizardLayout.findViewById(R.id.tv_note);
        mTvNote.setOnClickListener(this);
        setContentView(mSetupWizardLayout);
        Toast.makeText(this, "DeclareActivity onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNavigateBack() {
        onBackPressed();
    }

    public void finish(int resultCode) {
        setResult(resultCode);
//	    finish();
    }

    private boolean skipOrNot = false;

    @Override
    public void onNavigateNext() {
        Toast.makeText(this, "onNavigateNext", Toast.LENGTH_SHORT).show();
        if (!skipOrNot) {
            finish(RESULT_OK);
            done(true);
        } else {
            finish(RESULT_SKIP);
            done(false);
        }
    }

    private void setNextButtonEnabled(boolean enabled) {
        if (mNavigationBar != null) {
            mNavigationBar.getNextButton().setEnabled(enabled);
        }
    }

    private void setNextButtonText(int resId) {
        if (mNavigationBar != null) {
            mNavigationBar.getNextButton().setText(resId);
        }
    }

    private static final int NEXT_REQUEST_CODE = 1; // Can be anything
    private static final int RESULT_SKIP = ResultCodes.RESULT_SKIP;

    public void done(boolean success) {
        int resultCode = success ? Activity.RESULT_OK : RESULT_SKIP;
        Intent intent = WizardManagerHelper.getNextIntent(getIntent(), resultCode);
        startActivityForResult(intent, NEXT_REQUEST_CODE);
        // finish(); // Optional. Calling finish will remove this activity from the
        // back stack, such that this activity will be skipped if the
        // user clicks back from the next screen.
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_note:
                if (skipOrNot) {
                    skipOrNot = !skipOrNot;
                    mTvNote.setText("" + skipOrNot);
                } else {
                    skipOrNot = !skipOrNot;
                    mTvNote.setText("" + skipOrNot);
                }
                break;
            default:
                break;
        }

    }

    public void crash(View view) {
        throw new RuntimeException();
    }

}