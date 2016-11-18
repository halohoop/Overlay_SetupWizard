package com.tplink.overlay_setupwizard.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.setupwizardlib.util.ResultCodes;
import com.android.setupwizardlib.util.WizardManagerHelper;
import com.tplink.overlay_setupwizard.R;

public class WelcomeActivity extends FullScreenBaseActivity implements View.OnClickListener {

    private TextView mTvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        mTvNote = (TextView) findViewById(R.id.tv_note);
        mTvNote.setOnClickListener(this);
        Toast.makeText(this, "WelcomeActivity onCreate", Toast.LENGTH_SHORT).show();
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
                setResult(RESULT_OK);
                done(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
//		super.onBackPressed();
    }
    public void crash(View view){
        throw new RuntimeException();
    }

}
