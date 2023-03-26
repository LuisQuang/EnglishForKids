package com.example.sample_project.view.frm;

import android.view.LayoutInflater;

import com.example.sample_project.databinding.M000FragmentBinding;
import com.example.sample_project.viewmode.CommonVM;

public class M000_Splash extends BaseFragment<M000FragmentBinding, CommonVM> {
    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected M000FragmentBinding initViewBinding(LayoutInflater inflater) {
        return M000FragmentBinding.inflate(inflater);
    }
}
