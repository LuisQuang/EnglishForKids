package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;

import com.leerb.englishforkids.databinding.M003FrmSignupBinding;
import com.leerb.englishforkids.databinding.M004FrmSignInBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M004SignInFrm extends BaseFragment<M004FrmSignInBinding, CommonVM> {
    public static String TAG = M004SignInFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.btnSignIn.setOnClickListener(view -> callback.showFragement(M005VerifyFrm.TAG, null, true));
    }

    @Override
    protected M004FrmSignInBinding initViewBinding(LayoutInflater inflater) {
        return M004FrmSignInBinding.inflate(inflater);
    }
}
