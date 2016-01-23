package com.apollo_lib.textplug;

import android.text.Editable;
import android.widget.EditText;

public class TransformationData {
    private EditText editText;
    private Editable previousText;
    private Editable newText;
    private String newPart;
    private String removedPart;
    private String previousRawText;
    private String newRawText;
    private int previousCursorPosition;
    private int newCursorPosition;
    private boolean stopTransformation = false;

    private TextPlugManager manager;

    public TransformationData(TextPlugManager manager, EditText editText, Editable previousText,
                              Editable newText, String removedPart, String newPart,
                              String previousRawText, String newRawText, int previousCursorPosition,
                              int newCursorPosition) {

        this.manager = manager;
        this.editText = editText;
        this.previousText = previousText;
        this.newText = newText;
        this.newPart = newPart;
        this.removedPart = removedPart;
        this.previousRawText = previousRawText;
        this.newRawText = newRawText;
        this.previousCursorPosition = previousCursorPosition;
        this.newCursorPosition = newCursorPosition;
    }

    public TextPlugManager getManager() {
        return manager;
    }

    public EditText getEditText() {
        return editText;
    }

    public Editable getPreviousText() {
        return previousText;
    }

    public Editable getNewText() {
        return newText;
    }

    public String getNewPart() {
        return newPart;
    }

    public String getRemovedPart() {
        return removedPart;
    }

    public String getPreviousRawText() {
        return previousRawText;
    }

    public String getNewRawText() {
        return newRawText;
    }

    public int getPreviousCursorPosition() {
        return previousCursorPosition;
    }

    public int getNewCursorPosition() {
        return newCursorPosition;
    }

    public void setNewText(Editable newText) {
        this.newText = newText;
    }

    public void stopTransformation() {
        stopTransformation = true;
    }

    public boolean stoped() {
        return stopTransformation;
    }

    public void setCursorPosition(int position) {
        newCursorPosition = position;
    }
}
