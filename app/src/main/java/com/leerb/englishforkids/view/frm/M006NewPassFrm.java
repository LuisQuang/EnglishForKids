package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;

import com.leerb.englishforkids.databinding.M006FrmNewPassBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M006NewPassFrm extends BaseFragment<M006FrmNewPassBinding, CommonVM> {
    public static String TAG = M006NewPassFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.btnSignIn.setOnClickListener(view -> callback.showFragement(M007ResetPassFrm.TAG, null, true));
    }

    @Override
    protected M006FrmNewPassBinding initViewBinding(LayoutInflater inflater) {
        return M006FrmNewPassBinding.inflate(inflater);
    }
}
