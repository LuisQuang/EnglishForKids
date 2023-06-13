package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;

import com.leerb.englishforkids.databinding.M001FrmSplashBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M001SplashFrm extends BaseFragment<M001FrmSplashBinding, CommonVM> {
    public static String TAG = M001SplashFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.btnSignIn.setOnClickListener(view -> callback.showFragement(M002DisplayLangFrm.TAG, null, false));
    }

    @Override
    protected M001FrmSplashBinding initViewBinding(LayoutInflater inflater) {
        return M001FrmSplashBinding.inflate(inflater);
    }
}
