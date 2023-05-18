package com.example.funstory.view.frm;

import android.os.Handler;
import android.view.LayoutInflater;

import com.example.funstory.viewmode.CommonVM;
import com.example.sample_project.databinding.M000SplashBinding;

public class M000_Splash extends BaseFragment<M000SplashBinding, CommonVM> {
    public static final String TAG = M000_Splash.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        new Handler().postDelayed(() -> gotoMenuStory(), 500);
    }

    private void gotoMenuStory() {
        callback.showFragement(M001_Menu.TAG, null, false);
    }

    @Override
    protected M000SplashBinding initViewBinding(LayoutInflater inflater) {
        return M000SplashBinding.inflate(inflater);
    }


}
