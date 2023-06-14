package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;
import android.view.View;

import com.leerb.englishforkids.R;
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
        binding.btnBack.setOnClickListener(this);
        binding.btnSendMail.setOnClickListener(this);
    }

    @Override
    protected M007FrmResetPassBinding initViewBinding(LayoutInflater inflater) {
        return M007FrmResetPassBinding.inflate(inflater);
    }

    @Override
    protected void clickView(View v) {
        super.clickView(v);
        if (v.getId() == R.id.btn_back) {
            callback.backPress();
        } else if (v.getId() == R.id.btn_send_mail) {
// Xu ly gui mail
        }
    }
}
