package com.appolo_lib.textplug_samples.plugins;

import android.widget.CheckedTextView;
import android.widget.TextView;

import com.apollo_lib.textplug.TextPlugin;
import com.apollo_lib.textplug.TransformationData;
import com.appolo_lib.textplug_samples.MainActivity;
import com.appolo_lib.textplug_samples.R;

public class DotPlugin implements TextPlugin {

    private MainActivity mainActivity;

    private static final String DOT = ".";

    public DotPlugin(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public TransformationData transform(TransformationData data) {

        if (data.inserting() || data.insertingAndRemoving()) {
            if (data.getNewPart().length() == 1) {

                data.getNewText()
                        .insert(
                                data.getNewCursorPosition(),
                                DOT);

                data.setCursorPosition(data.getNewCursorPosition() + DOT.length());
            } else {

            }
        } else {
            if (data.getRemovedPart().length() == 1) {
                if (data.getRemovedPart().equals(DOT)) {
                    data.getNewText()
                            .delete(data.getNewCursorPosition() - 1,
                                    data.getNewCursorPosition());

                    data.setCursorPosition(data.getNewCursorPosition() - 1);
                } else {
                    data.getNewText()
                            .delete(data.getNewCursorPosition(),
                                    data.getNewCursorPosition() + 1);

                    data.setCursorPosition(data.getNewCursorPosition() - 1);
                }
            }
        }

        TextView removedPart = (TextView)mainActivity.findViewById(R.id.removed_part_value);
        TextView newPart = (TextView)mainActivity.findViewById(R.id.new_part_value);
        TextView previousText = (TextView)mainActivity.findViewById(R.id.previous_text_value);
        TextView newText = (TextView)mainActivity.findViewById(R.id.new_text_value);
        TextView previousCursorPosition = (TextView)mainActivity.findViewById(R.id.previous_cursor_position_value);
        TextView newCursorPosition = (TextView)mainActivity.findViewById(R.id.new_cursor_position_value);
        CheckedTextView inserting = (CheckedTextView)mainActivity.findViewById(R.id.inserting);
        CheckedTextView removing = (CheckedTextView)mainActivity.findViewById(R.id.removing);
        CheckedTextView inserting_removing = (CheckedTextView)mainActivity.findViewById(R.id.inserting_removing);

        removedPart.setText("\"" + data.getRemovedPart() + "\"");
        newPart.setText("\"" + data.getNewPart() + "\"");
        previousText.setText("\"" + data.getPreviousText() + "\"");
        newText.setText("\"" + data.getNewText() + "\"");
        previousCursorPosition.setText(String.valueOf(data.getPreviousCursorPosition()));
        newCursorPosition.setText(String.valueOf(data.getNewCursorPosition()));
        inserting.setChecked(data.inserting());
        removing.setChecked(data.removing());
        inserting_removing.setChecked(data.insertingAndRemoving());

        return data;
    }
}
