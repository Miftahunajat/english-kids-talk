package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentChallengeItemCBinding;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLearningSpeakingBinding;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking.LearningSpeakingFragment;

import java.util.ArrayList;

import io.reactivex.annotations.Nullable;

public class ChallengeItemCFragment extends BaseChallengeItemFragment implements RecognitionListener {

    private static final String TAG = "ChallengeItemCFragment";
    FragmentChallengeItemCBinding binding;
    private SpeechRecognizer mSpeechRecognizer;

    public static ChallengeItemCFragment newInstance(Challenge challenge) {
        Bundle args = new Bundle();
        args.putSerializable("challenge", challenge);
        ChallengeItemCFragment fragment = new ChallengeItemCFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge_item_c, container, false);
        constructChallengeTimer(binding.fillLoading, binding.tvTimer);
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());
        mSpeechRecognizer.setRecognitionListener(this);
        binding.btnSpeaking.setOnClickListener(v -> promptSpeechInput());
        binding.setChallenge(mChallenge);
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
    protected void setUp(View view) {
        binding.btnSpeaking.setOnClickListener(v -> promptSpeechInput());
    }

    @Override
    public void onReadyForSpeech(Bundle params) { showLoading(); }

    @Override
    public void onBeginningOfSpeech() {
        Toast.makeText(getContext(), "English Kids Talk is listening ...", Toast.LENGTH_SHORT).show();
        stopChallengeTimer();
    }

    @Override
    public void onRmsChanged(float rmsdB) {}

    @Override
    public void onBufferReceived(byte[] buffer) {}

    @Override
    public void onEndOfSpeech() { hideLoading(); }

    @Override
    public void onResults(Bundle results) {
        binding.executePendingBindings();
        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (matches != null && matches.size() != 0) {
            binding.tvUsersvoice.setText(matches.get(0));
            Log.d("answer", matches.get(0));
            onUserAnswer (
                binding.tvUsersvoice.getText().toString().toLowerCase(),
                mChallenge.getAnswers().get(0).getAnswerText(),
                mChallenge.getChallengeStar()
            );
        } else {
            Log.d("Matches", "Tidak ada suara ter-record!");
        }
    }

    @Override
    public void onPartialResults(Bundle partialResults) {}

    @Override
    public void onEvent(int eventType, Bundle params) {}

    public void showLoading(){
        binding.btnSpeaking.setVisibility(View.INVISIBLE);
        binding.progressBar.setVisibility(View.VISIBLE);
    }
    public void hideLoading(){
        binding.btnSpeaking.setVisibility(View.VISIBLE);
        binding.progressBar.setVisibility(View.INVISIBLE);
    }
}
