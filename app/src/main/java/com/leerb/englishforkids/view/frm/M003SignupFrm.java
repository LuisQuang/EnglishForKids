package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;

import com.leerb.englishforkids.databinding.M002FrmLanguageBinding;
import com.leerb.englishforkids.databinding.M003FrmSignupBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M003SignupFrm extends BaseFragment<M003FrmSignupBinding, CommonVM> {
    public static String TAG = M003SignupFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.btnSignIn.setOnClickListener(view -> callback.showFragement(M004SignInFrm.TAG, null, true));
    }

    @Override
    protected M003FrmSignupBinding initViewBinding(LayoutInflater inflater) {
        return M003FrmSignupBinding.inflate(inflater);
    }
}
