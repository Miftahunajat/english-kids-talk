package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking;


import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLearningSpeakingBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LearningSpeakingFragment extends BaseFragment implements RecognitionListener{

    private final int REQ_CODE_SPEECH_INPUT = 100;
    private SpeechRecognizer mSpeechRecognizer;
    FragmentLearningSpeakingBinding binding;
    OnSpeakingResponse onSpeakingResponse;

    public LearningSpeakingFragment() {

        // Required empty public constructor
    }
    public static LearningSpeakingFragment newInstance(LearningItem learningItem){
        LearningSpeakingFragment learningSpeakingFragment = new LearningSpeakingFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("learning-item", learningItem);
        learningSpeakingFragment.setArguments(bundle);
        return learningSpeakingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_learning_speaking,container,false);
        LearningItem learningItem = (LearningItem) getArguments().getSerializable("learning-item");
        binding.setLearningItem(learningItem);

        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());
        mSpeechRecognizer.setRecognitionListener(this);

        onSpeakingResponse = (OnSpeakingResponse) getBaseActivity();

        // hide the action bar
        binding.btnSpeaking.setOnClickListener(v -> promptSpeechInput());
        return binding.getRoot();
    }

    private void promptSpeechInput() {
        ActivityCompat.requestPermissions(getBaseActivity(),new String[]{Manifest.permission.RECORD_AUDIO},1);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                this.getContext().getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS,true);
        mSpeechRecognizer.startListening(intent);
    }

    @Override
    public void onReadyForSpeech(Bundle params) {
        showLoading();
    }

    @Override
    public void onBeginningOfSpeech() {
        Toast.makeText(getContext(), "E kita Listening", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRmsChanged(float rmsdB) {

    }

    @Override
    public void onBufferReceived(byte[] buffer) {

    }

    @Override
    public void onEndOfSpeech() {
        hideLoading();
    }

    @Override
    public void onError(int error) {
        hideLoading();
        Toast.makeText(getContext(), "Maaf Kata Tidak Ditemukan", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onResults(Bundle results) {
        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (matches != null && matches.size() != 0) {
            binding.tvUsersvoice.setText(matches.get(0));
            checkAnswer(binding.tvUsersvoice.getText().toString());
        }else{
            showMessage("Maaf tidak bisa menemukan");
        }
    }

    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }

    public void showLoading(){
        binding.btnSpeaking.setVisibility(View.INVISIBLE);
        binding.progressBar.setVisibility(View.VISIBLE);
    }
    public void hideLoading(){
        binding.btnSpeaking.setVisibility(View.VISIBLE);
        binding.progressBar.setVisibility(View.INVISIBLE);
    }
    void checkAnswer(String answer){
        String correctAnswer = binding.tvSpeaking.getText().toString().toLowerCase();
        Log.d("ANSWERS", correctAnswer+" "+answer);
        if(answer.toLowerCase().equalsIgnoreCase(correctAnswer)){
            onSpeakingResponse.onSuccess();
        }
        else {
            getBaseActivity().showFailedPrompt();
        }
    }

    interface OnSpeakingResponse{
        void onSuccess();
    }
}
