package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;

import com.leerb.englishforkids.databinding.M007FrmResetPassBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M007ResetPassFrm extends BaseFragment<M007FrmResetPassBinding, CommonVM> {
    public static String TAG = M007ResetPassFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected M007FrmResetPassBinding initViewBinding(LayoutInflater inflater) {
        return M007FrmResetPassBinding.inflate(inflater);
    }
}
