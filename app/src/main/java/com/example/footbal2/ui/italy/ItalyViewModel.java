package com.example.footbal2.ui.italy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItalyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ItalyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Italy fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}