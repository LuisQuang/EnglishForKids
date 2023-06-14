package com.leerb.englishforkids.view.act;

import com.leerb.englishforkids.databinding.ActivityHomeBinding;
import com.leerb.englishforkids.view.frm.M001SplashFrm;
import com.leerb.englishforkids.view.frm.M003SignupFrm;
import com.leerb.englishforkids.viewmode.CommonVM;

public class MainAct extends BaseAct<ActivityHomeBinding, CommonVM> {

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override

    protected void initViews() {
        showFragement(M001SplashFrm.TAG, null, false);

    }

    @Override
    protected ActivityHomeBinding initViewBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void backPress() {
        onBackPressed();
    }
}