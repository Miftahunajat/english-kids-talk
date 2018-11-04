package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayout;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WritingControl {
    private FlexboxLayout flexboxLayout;
    private String question;
    private List<LinearLayout> linearLayouts;
    private String[] strings;
    private BaseActivity context;
    private Random random;
    private List<EditText> editTexts;
    private OnWritingSubmit mCallback;

    public WritingControl(FlexboxLayout flexboxLayout, String question, BaseFragment context) {
        this.flexboxLayout = flexboxLayout;
        this.question = question;
        strings = question.split(" ");
        linearLayouts = new ArrayList<LinearLayout>();
        this.context = context.getBaseActivity();
        random = new Random();
        editTexts = new ArrayList<EditText>();
        mCallback = (OnWritingSubmit) context;
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
                    editText.setTag("1");
                    editText.setKeyListener(null);
                }
                else {
                    editText.setTag("0");
                }
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                editTexts.add(editText);
                linearLayout.addView(editText);
            }
            flexboxLayout.addView(linearLayout);
        }
        addValidation(editTexts);
    }

    void addValidation(List<EditText> editTexts){
        for (int i = 0; i < editTexts.size(); i++) {
            int finalI = i;


            editTexts.get(i).setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus){
                    if (v.getTag().equals("1")){
                        if (finalI == editTexts.size() - 1) {
                            context.hideKeyboard();
                            mCallback.onSubmit();
                        }else
                            editTexts.get(finalI + 1).requestFocus();
                    }else{
                    }
                }
            });

            editTexts.get(i).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (finalI == editTexts.size() - 1) {
                        context.hideKeyboard();
                        mCallback.onSubmit();
                    }
                    else
                        editTexts.get(finalI +1).requestFocus();
                }
            });


            editTexts.get(i).setOnEditorActionListener((v, actionId, event) -> {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    if (finalI == editTexts.size() - 1) {
                        context.hideKeyboard();
                        mCallback.onSubmit();
                    }
                    else
                        editTexts.get(finalI +1).requestFocus();
                }
                return true;
            });
        }
    }

    interface OnWritingSubmit{
        void onSubmit();
    }

}
