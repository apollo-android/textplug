package com.appolo_lib.textplug_samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.apollo_lib.textplug.TextPlugManager;
import com.apollo_lib.textplug.plugins.LogPlugin;
import com.apollo_lib.textplug.plugins.WordsPlugin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText)findViewById(R.id.edit_text);

        TextPlugManager manager = new TextPlugManager(editText);

        LogPlugin log = new LogPlugin(
                LogPlugin.TransformationDataProperty.PreviousRawText,
                LogPlugin.TransformationDataProperty.NewRawText);

        manager.add(log);

        WordsPlugin words = new WordsPlugin();

        manager.add(words);
    }
}
