package com.apollo_lib.textplug;

import android.text.Editable;
import android.widget.EditText;

public class TransformationData {
    private EditText editText;
    private Editable previousText;
    private Editable newText;
    private CharSequence newPart;
    private Editable previousRawText;
    private Editable newRawText;
    private int cursorPosition;
    private int newCursorPosition;
    private boolean stop = false;

    public TransformationData(EditText editText, Editable previousText, Editable newText, CharSequence newPart,
                              Editable previousRawText, Editable newRawText, int cursorPosition,
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

    public Editable getPreviousText() {
        return previousText;
    }

    public Editable getNewText() {
        return newText;
    }

    public CharSequence getNewPart() {
        return newPart;
    }

    public Editable getPreviousRawText() {
        return previousRawText;
    }

    public Editable getNewRawText() {
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

    public void setNewText(Editable newText) {
        this.newText = newText;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
