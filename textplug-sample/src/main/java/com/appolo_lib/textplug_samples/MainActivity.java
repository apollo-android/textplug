package com.appolo_lib.textplug_samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.apollo_lib.textplug.TextPlugManager;
import com.apollo_lib.textplug.plugins.LogPlugin;
import com.appolo_lib.textplug_samples.plugins.DotPlugin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText)findViewById(R.id.edit_text);

        TextPlugManager manager = new TextPlugManager(editText);

        LogPlugin log = new LogPlugin();

        manager.add(log);

        DotPlugin dot = new DotPlugin(this);

        manager.add(dot);
    }
}
