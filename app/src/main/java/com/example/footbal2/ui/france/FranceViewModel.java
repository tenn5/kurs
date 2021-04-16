package com.example.footbal2.ui.france;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FranceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FranceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is France fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}