package com.apollo_lib.textplug.plugins;

import android.util.Log;

import com.apollo_lib.textplug.TextPlugin;
import com.apollo_lib.textplug.TransformationData;

public class WordsPlugin implements TextPlugin{
    private static final String TAG = "WordsPlugin";

    @Override
    public TransformationData transform(TransformationData data) {
        Log.d(TAG, "Transform");
        return data;
    }
}
