package com.example.footbal2.ui.spain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SpainViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SpainViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Spain fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}