package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;

import com.leerb.englishforkids.CommonUtils;
import com.leerb.englishforkids.R;
import com.leerb.englishforkids.databinding.M003FrmSignupBinding;
import com.leerb.englishforkids.databinding.M004FrmSignInBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M004SignInFrm extends BaseFragment<M004FrmSignInBinding, CommonVM> {
    public static String TAG = M004SignInFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.tvSignup.setOnClickListener(this);
        binding.tvForgetPass.setOnClickListener(this);
        binding.checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
//              Luu thong tin dang nhap
            }
        });
        binding.btnBack.setOnClickListener(this);
    }

    @Override
    protected M004FrmSignInBinding initViewBinding(LayoutInflater inflater) {
        return M004FrmSignInBinding.inflate(inflater);
    }

    @Override
    protected void clickView(View v) {
        super.clickView(v);
        if (v.getId() == R.id.tv_signup) {
            callback.showFragement(M003SignupFrm.TAG, null, true);
        } else if (v.getId() == R.id.tv_forget_pass) {
            callback.showFragement(M007ResetPassFrm.TAG, null, true);
        }
        if (v.getId() == R.id.btn_back) {
            callback.backPress();
        }
    }
}
