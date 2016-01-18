package com.apollo_lib.textplug.plugins;

import com.apollo_lib.textplug.TextPlugin;
import com.apollo_lib.textplug.TransformationData;

public class WordsPlugin implements TextPlugin{
    @Override
    public TransformationData transform(TransformationData data) {
        return data;
    }
}
