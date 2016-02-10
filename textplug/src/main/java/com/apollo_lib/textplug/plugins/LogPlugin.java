package com.apollo_lib.textplug.plugins;

import android.util.Log;

import com.apollo_lib.textplug.TextPlugin;
import com.apollo_lib.textplug.TransformationData;

import java.util.EnumSet;

public class LogPlugin implements TextPlugin {
    private static final String TAG = "LogPlugin";

    private EnumSet<TransformationDataProperty> properties;

    public enum TransformationDataProperty {
        RemovedPart,
        NewPart,
        PreviousText,
        NewText,
        PreviousCursorPosition,
        NewCursorPosition,
        Inserting,
        Removing,
        InsertingAndRemoving
    }

    public LogPlugin() {
        this.properties = EnumSet.allOf(TransformationDataProperty.class);
    }

    public LogPlugin(TransformationDataProperty firstProperty, TransformationDataProperty... othersProperties) {
        this.properties = EnumSet.of(firstProperty, othersProperties);
    }

    @Override
    public TransformationData transform(TransformationData data) {

        if (properties.contains(TransformationDataProperty.RemovedPart)) {
            Log.i(TAG, "RemovedPart: " + data.getRemovedPart().toString());
        }

        if (properties.contains(TransformationDataProperty.NewPart)) {
            Log.i(TAG, "NewPart: " + data.getNewPart().toString());
        }

        if (properties.contains(TransformationDataProperty.PreviousText)) {
            Log.i(TAG, "PreviousText: " + data.getPreviousText().toString());
        }

        if (properties.contains(TransformationDataProperty.NewText)) {
            Log.i(TAG, "NewText: " + data.getNewText().toString());
        }

        if (properties.contains(TransformationDataProperty.PreviousCursorPosition)) {
            Log.i(TAG, "PreviousCursorPosition: " + data.getPreviousCursorPosition());
        }

        if (properties.contains(TransformationDataProperty.NewCursorPosition)) {
            Log.i(TAG, "NewCursorPosition: " + data.getNewCursorPosition());
        }

        if (properties.contains(TransformationDataProperty.Inserting)) {
            Log.i(TAG, "Inserting: " + (data.inserting() ? "true" : "false"));
        }

        if (properties.contains(TransformationDataProperty.Removing)) {
            Log.i(TAG, "Removing: " + (data.removing() ? "true" : "false"));
        }

        if (properties.contains(TransformationDataProperty.InsertingAndRemoving)) {
            Log.i(TAG, "InsertingAndRemoving: " + (data.insertingAndRemoving() ? "true" : "false"));
        }

        return data;
    }
}
