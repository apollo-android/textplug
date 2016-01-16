package com.apollo_lib.textplug;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class TextPlugManager implements TextWatcher {
    private EditText editText;
    private List<TextPlugin> plugins;

    public TextPlugManager(EditText editText) {
        this.editText = editText;
        this.plugins = new ArrayList<>();
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
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
