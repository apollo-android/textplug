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
    private String previousRawText;
    private Editable.Factory editableFactory;
    private String removedPart;


    public TextPlugManager(EditText editText) {
        this.editText = editText;
        this.plugins = new ArrayList<>();

        editText.addTextChangedListener(this);

        editableFactory = Editable.Factory.getInstance();

        previousRawText = editText.getText().toString();
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
        previousText = editText.getText();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        editText.removeTextChangedListener(this);

        Editable blank = editableFactory.newEditable("");

        int previousCursorPosition = start;
        int newCursorPosition = start + count;

        String newPart = s.subSequence(previousCursorPosition, newCursorPosition).toString();

        String newRawText = previousRawText.substring(0, previousCursorPosition) +
                newPart +
                previousRawText.substring(previousCursorPosition);

        if (!removedPart.isEmpty()) {
            newRawText = newRawText.substring(0, start) +
                    newRawText.substring(start + before);
        }

        Editable newText = editText.getText();

        TransformationData data = new TransformationData(
                this,
                editText,
                previousText,
                newText,
                removedPart,
                newPart,
                previousRawText,
                newRawText,
                previousCursorPosition,
                newCursorPosition);

        for (TextPlugin plugin: plugins) {
            plugin.transform(data);

            if (data.stoped()) {
                break;
            }
        }

        previousRawText = newRawText;

        editText.setText(data.getNewText());
        editText.setSelection(data.getNewCursorPosition());
        
        editText.addTextChangedListener(this);
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
