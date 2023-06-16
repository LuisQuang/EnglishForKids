package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;

import com.leerb.englishforkids.databinding.M008FrmMainAppUiBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

class M008MainAppUI extends BaseFragment<M008FrmMainAppUiBinding, CommonVM> {


    public static final String TAG = M008MainAppUI.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected M008FrmMainAppUiBinding initViewBinding(LayoutInflater inflater) {
        return M008FrmMainAppUiBinding.inflate(inflater);
    }
}