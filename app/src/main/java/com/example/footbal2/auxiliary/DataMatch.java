package com.example.footbal2.auxiliary;

import android.widget.Spinner;

import com.example.footbal2.constants.Country;

public class DataMatch {
    private Spinner spinner;
    private Country country;

    public DataMatch(Spinner spinner, Country country) {
        this.spinner = spinner;
        this.country = country;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public Country getCountry() {
        return country;
    }
}
