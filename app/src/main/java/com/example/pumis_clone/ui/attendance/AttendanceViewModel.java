package com.example.pumis_clone.ui.attendance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AttendanceViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AttendanceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Attendance fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}