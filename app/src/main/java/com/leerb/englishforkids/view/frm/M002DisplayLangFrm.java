package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;
import android.view.View;

import com.leerb.englishforkids.databinding.M002FrmLanguageBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M002DisplayLangFrm extends BaseFragment<M002FrmLanguageBinding, CommonVM> {
    public static String TAG = M002DisplayLangFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.btnDone.setOnClickListener(view -> callback.showFragement(M003SignupFrm.TAG, null, true));

    }

    @Override
    protected M002FrmLanguageBinding initViewBinding(LayoutInflater inflater) {
        return M002FrmLanguageBinding.inflate(inflater);
    }
}
