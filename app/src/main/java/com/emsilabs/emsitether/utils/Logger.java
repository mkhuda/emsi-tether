package com.emsilabs.emsitether.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by emsi on 25/02/16.
 */
public class Logger {

    public static final int MODE_LOGCAT = 0;
    public static final int MODE_TOAST  = 1;
    private int mMode = 0;
    private Context mContext;

    public Logger(Context context) {
        mContext = context;
    }

    public void setMode(int mode) {
        mMode = mode;
    }

    public void log(String tag, String msg) {
        switch (mMode) {
            case MODE_LOGCAT:
                Log.i(tag, msg);
                break;
            case MODE_TOAST:
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
