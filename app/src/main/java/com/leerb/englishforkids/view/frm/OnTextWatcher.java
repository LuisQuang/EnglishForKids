package com.leerb.englishforkids.view.frm;

import android.text.Editable;
import android.text.TextWatcher;

public interface OnTextWatcher extends TextWatcher {

    @Override
    void onTextChanged(CharSequence charSequence, int i, int i1, int i2);


    @Override
    default void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    default void afterTextChanged(Editable editable) {

    }
}
