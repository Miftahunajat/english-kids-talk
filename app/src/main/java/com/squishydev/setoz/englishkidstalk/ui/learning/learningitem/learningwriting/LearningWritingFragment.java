package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLearningWritingBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking.LearningSpeakingFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LearningWritingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningWritingFragment extends BaseFragment {

    FragmentLearningWritingBinding binding;
    OnWritingResponse onWritingResponse;


    public LearningWritingFragment() {
        // Required empty public constructor
    }

    public static LearningWritingFragment newInstance(LearningItem learningItem){
        LearningWritingFragment learningWritingFragment = new LearningWritingFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("learning-item", learningItem);
        learningWritingFragment.setArguments(bundle);
        return learningWritingFragment;
    }

    public static LearningWritingFragment newInstance() {
        LearningWritingFragment fragment = new LearningWritingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_learning_writing,container,false);
        WritingControl writingControl = new WritingControl(binding.fbQuestion, "Good Morning",getContext() );
        writingControl.buildLinearLayout();
        binding.writingSend.setOnClickListener(v -> {
            checkAnswer(writingControl.getAnswer());
            Toast.makeText(getContext(),writingControl.getAnswer(), Toast.LENGTH_SHORT).show();
        });
        LearningItem learningItem = (LearningItem) getArguments().getSerializable("learning-item");
        binding.setLearningItem(learningItem);
        
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    void checkAnswer(String answer){
        String correctAnswer = binding.textView10.getText().toString().replace(" ","").toLowerCase();
        Log.d("ANSWERS", correctAnswer+" "+answer);
        if(answer.toLowerCase().equalsIgnoreCase(correctAnswer)){
            getBaseActivity().showSuccessPrompt();
            onWritingResponse.onSuccess();
        }
        else {
            getBaseActivity().showFailedPrompt();
        }
    }

    @Override
    protected void setUp(View view) {

    }

    interface OnWritingResponse{
        void onSuccess();
    }
}
