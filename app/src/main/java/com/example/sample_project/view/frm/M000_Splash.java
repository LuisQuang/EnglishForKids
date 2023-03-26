package com.example.sample_project.view.frm;

import android.os.Handler;
import android.view.LayoutInflater;

import com.example.sample_project.databinding.FragmentSplashBinding;
import com.example.sample_project.viewmode.CommonVM;

public class M000_Splash extends BaseFragment<FragmentSplashBinding, CommonVM> {
    public static final String TAG = M000_Splash.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        new Handler().postDelayed(() -> gotoMenuStory(), 2000);
    }

    private void gotoMenuStory() {
        callback.showFragement(M001_Menu.TAG, null, false);
    }

    @Override
    protected FragmentSplashBinding initViewBinding(LayoutInflater inflater) {
        return FragmentSplashBinding.inflate(inflater);
    }


}
