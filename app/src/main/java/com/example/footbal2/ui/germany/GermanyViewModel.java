package com.example.footbal2.ui.germany;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GermanyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GermanyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Germany fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}