package com.apollo_lib.textplug;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class TextPlugManager implements TextWatcher {
    private final static String TAG = "TextPlugManager";
    private EditText editText;
    private List<TextPlugin> plugins;

    private Editable previousText;
    private Editable.Factory editableFactory;
    private String removedPart;
    private int newCursorPosition;

    public TextPlugManager(EditText editText) {
        this.editText = editText;
        this.plugins = new ArrayList<>();

        editText.addTextChangedListener(this);

        editableFactory = Editable.Factory.getInstance();
    }

    public TextPlugManager add(TextPlugin pluging) {
        plugins.add(pluging);
        return this;
    }

    public TextPlugManager remove(TextPlugin pluging) {
        plugins.remove(pluging);
        return this;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        removedPart = s.subSequence(start, start + count).toString();
        previousText = editableFactory.newEditable(editText.getText());
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        editText.removeTextChangedListener(this);

        int previousCursorPosition = newCursorPosition;
        newCursorPosition = start + count;

        String newPart;

        if (start < newCursorPosition) {
            newPart = s.subSequence(start, newCursorPosition).toString();
        } else {
            newPart = "";
        }

        Editable newText = editText.getText();

        TransformationData data = new TransformationData(
                this,
                editText,
                previousText,
                newText,
                removedPart,
                newPart,
                previousCursorPosition,
                newCursorPosition);

        for (TextPlugin plugin: plugins) {
            plugin.transform(data);

            if (data.stoped()) {
                break;
            }
        }

        editText.setText(data.getNewText());
        editText.setSelection(data.getNewCursorPosition());
        
        editText.addTextChangedListener(this);

        newCursorPosition = data.getNewCursorPosition();
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
