package com.example.sample_project.view.act;

import androidx.lifecycle.ViewModelProvider;

import com.example.sample_project.databinding.ActivityMainBinding;
import com.example.sample_project.viewmode.M001MainVM;

public class M001MainAct extends BaseAct<ActivityMainBinding, M001MainVM> {
    private final String Tag = M001MainAct.class.getName();

    private M001MainVM m001VM;

    @Override
    protected Class<M001MainVM> getClassVM() {
        return M001MainVM.class;
    }

    @Override
    protected void initViews() {
        m001VM = new ViewModelProvider(this).get(M001MainVM.class);
    }


    @Override
    protected ActivityMainBinding initViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}