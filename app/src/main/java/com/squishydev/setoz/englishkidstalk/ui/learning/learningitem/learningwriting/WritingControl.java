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
import java.util.Random;

public class WritingControl {
    private FlexboxLayout flexboxLayout;
    private String question;
    private List<LinearLayout> linearLayouts;
    private String[] strings;
    private Context context;
    private Random random;
    private List<EditText> editTexts;

    public WritingControl(FlexboxLayout flexboxLayout, String question, Context context) {
        this.flexboxLayout = flexboxLayout;
        this.question = question;
        strings = question.split(" ");
        linearLayouts = new ArrayList<LinearLayout>();
        this.context = context;
        random = new Random();
        editTexts = new ArrayList<EditText>();
 }

    public String getAnswer(){
        StringBuilder sb = new StringBuilder();
        for (EditText et:editTexts) {
            sb.append(et.getText().toString());
        }
        return sb.toString();
    }

    public void buildLinearLayout(){
        for (int i = 0; i < strings.length; i++){
            LinearLayout linearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            layoutParams.setMargins(34,0,0,0);
            linearLayout.setLayoutParams(layoutParams);
            for( int j =0; j < strings[i].length();j++){
                EditText editText = new EditText(context);
                if(random.nextDouble() > 0.5){
                    editText.setText(strings[i].charAt(j) + "");
                    editText.setKeyListener(null);
                }
                else {
                }
                editTexts.add(editText);
                linearLayout.addView(editText);
            }
            flexboxLayout.addView(linearLayout);
        }

    }

}
