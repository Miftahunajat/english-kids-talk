package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayout;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class WritingControl {
    private FlexboxLayout flexboxLayout;
    private String question;
    private List<LinearLayout> linearLayouts;
    private String[] strings;
    private Context context;

    public WritingControl(FlexboxLayout flexboxLayout, String question, Context context) {
        this.flexboxLayout = flexboxLayout;
        this.question = question;
        strings = question.split(" ");
        linearLayouts = new ArrayList<LinearLayout>();
        this.context = context;
 }

    public void buildLinearLayout(){
        for (int i = 0; i < strings.length; i++){
            LinearLayout linearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            layoutParams.setMargins(68,0,0,0);
            linearLayout.setLayoutParams(layoutParams);
            int sex = 0;
            for( int j =0; j < strings[i].length();j++){
                Log.d("Debug",sex + "");
                sex++;
                EditText editText = new EditText(context);
                    editText.setText(strings[i].charAt(j) + "");
                editText.setKeyListener(null);
                linearLayout.addView(editText);

            }
            flexboxLayout.addView(linearLayout);
        }

    }

}
