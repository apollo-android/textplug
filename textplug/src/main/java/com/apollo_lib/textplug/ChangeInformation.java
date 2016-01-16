package com.apollo_lib.textplug;

import android.widget.EditText;

public class ChangeInformation {
    private EditText editText;
    private String previousText;
    private String newText;
    private String newPart;
    private String previousRawText;
    private String newRawText;
    private int cursorPosition;
    private int newCursorPosition;
    private boolean stop = false;

    public ChangeInformation(EditText editText, String previousText, String newText, String newPart,
                             String previousRawText, String newRawText, int cursorPosition,
                             int newCursorPosition) {

        this.editText = editText;
        this.previousText = previousText;
        this.newText = newText;
        this.newPart = newPart;
        this.previousRawText = previousRawText;
        this.newRawText = newRawText;
        this.cursorPosition = cursorPosition;
        this.newCursorPosition = newCursorPosition;
    }

    public EditText getEditText() {
        return editText;
    }

    public String getPreviousText() {
        return previousText;
    }

    public String getNewText() {
        return newText;
    }

    public String getNewPart() {
        return newPart;
    }

    public String getPreviousRawText() {
        return previousRawText;
    }

    public String getNewRawText() {
        return newRawText;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public int getNewCursorPosition() {
        return newCursorPosition;
    }

    public boolean getStop() {
        return stop;
    }

    public void setNewText(String newText) {
        this.newText = newText;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
