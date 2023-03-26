package com.example.sample_project.view.frm;

import android.view.LayoutInflater;

import com.example.sample_project.databinding.FragmentMenuBinding;
import com.example.sample_project.viewmode.CommonVM;

public class M001_Menu extends BaseFragment<FragmentMenuBinding, CommonVM> {
    public static final String TAG = M001_Menu.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected FragmentMenuBinding initViewBinding(LayoutInflater inflater) {
        return FragmentMenuBinding.inflate(inflater);
    }
}
