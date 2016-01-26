package com.appolo_lib.textplug_samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.apollo_lib.textplug.TextPlugManager;
import com.apollo_lib.textplug.plugins.LogPlugin;
import com.apollo_lib.textplug.plugins.WordsPlugin;
import com.appolo_lib.textplug_samples.plugins.BluePlugin;
import com.appolo_lib.textplug_samples.plugins.RedPlugin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText)findViewById(R.id.edit_text);

        TextPlugManager manager = new TextPlugManager(editText);

        LogPlugin log = new LogPlugin();

        manager.add(log);

        RedPlugin red = new RedPlugin(
                (TextView)findViewById(R.id.red_previous),
                (TextView)findViewById(R.id.red_next));

        manager.add(red);

        BluePlugin blue = new BluePlugin(
                (TextView)findViewById(R.id.blue_previous),
                (TextView)findViewById(R.id.blue_next));

        manager.add(blue);
    }
}
