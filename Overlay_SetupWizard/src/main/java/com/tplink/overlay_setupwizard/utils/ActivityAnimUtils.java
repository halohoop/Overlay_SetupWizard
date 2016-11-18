package com.tplink.overlay_setupwizard.utils;

import android.app.ActivityOptions;
import android.content.Context;

public class ActivityAnimUtils {
   /**
    * activity切换过场动画
    */
    public static ActivityOptions getOptions(Context context) {
        ActivityOptions options =
                ActivityOptions.makeCustomAnimation(context,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out);
        return options;
    }
}