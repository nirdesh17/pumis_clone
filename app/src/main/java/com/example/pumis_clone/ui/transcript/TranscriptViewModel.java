package com.example.pumis_clone.ui.transcript;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TranscriptViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public TranscriptViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Trancsript fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}