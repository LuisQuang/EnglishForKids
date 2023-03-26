package com.example.sample_project.view.frm;

import android.view.LayoutInflater;

import com.example.sample_project.databinding.M001MainScreenBinding;
import com.example.sample_project.viewmode.CommonVM;

public class M001_Main_Screen extends BaseFragment<M001MainScreenBinding, CommonVM> {
    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected M001MainScreenBinding initViewBinding(LayoutInflater inflater) {
        return M001MainScreenBinding.inflate(inflater);
    }
}
