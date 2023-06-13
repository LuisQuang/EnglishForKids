package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;

import com.leerb.englishforkids.databinding.M004FrmSignInBinding;
import com.leerb.englishforkids.databinding.M005FrmVerifyBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M005VerifyFrm extends BaseFragment<M005FrmVerifyBinding, CommonVM> {
    public static String TAG = M005VerifyFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.btnConfirm.setOnClickListener(view -> callback.showFragement(M006NewPassFrm.TAG, null, true));
    }

    @Override
    protected M005FrmVerifyBinding initViewBinding(LayoutInflater inflater) {
        return M005FrmVerifyBinding.inflate(inflater);
    }
}
