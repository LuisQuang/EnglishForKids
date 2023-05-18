package com.example.funstory.view.act;

import com.example.funstory.view.frm.M000_Splash;
import com.example.funstory.viewmode.M001MainVM;
import com.example.sample_project.databinding.ActivityHomeBinding;

public class M001MainAct extends BaseAct<ActivityHomeBinding, M001MainVM> {


    private static final String TAG = M001MainAct.class.getName();

    @Override
    protected Class<M001MainVM> getClassVM() {
        return M001MainVM.class;
    }

    @Override
    protected void initViews() {
        showFragement(M000_Splash.TAG, null, false);
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