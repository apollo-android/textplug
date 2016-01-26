package com.appolo_lib.textplug_samples.plugins;

import android.graphics.Color;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.apollo_lib.textplug.TextPlugin;
import com.apollo_lib.textplug.TransformationData;

public class RedPlugin implements TextPlugin {

    private boolean skip;

    private TextView previous;
    private TextView next;

    public RedPlugin(TextView previous, TextView next) {
        this.previous = previous;
        this.next = next;
    }

    @Override
    public TransformationData transform(TransformationData data) {

        previous.setText(data.getPreviousText());

        if (!skip) {
            if (data.getRemovedPart().isEmpty()) {
                data.getNewText().setSpan(
                        new ForegroundColorSpan(Color.RED),
                        data.getPreviousCursorPosition(),
                        data.getNewCursorPosition(),
                        0);
            }

            skip = true;
        } else {
            skip = false;
        }

        next.setText(data.getNewText());

        return data;
    }
}
