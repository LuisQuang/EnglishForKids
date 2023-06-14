package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;

import com.leerb.englishforkids.CommonUtils;
import com.leerb.englishforkids.databinding.M001FrmSplashBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M001SplashFrm extends BaseFragment<M001FrmSplashBinding, CommonVM> {
    public static final String KEY_LANG = "KEY_LANG";
    public static String TAG = M001SplashFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.btnSignIn.setOnClickListener(view -> {

            if (CommonUtils.getInstance().getPref(KEY_LANG).isEmpty()) {
                callback.showFragement(M002DisplayLangFrm.TAG, null, false);
            } else {
                callback.showFragement(M004SignInFrm.TAG, null, true);
            }
        });
    }

    @Override
    protected M001FrmSplashBinding initViewBinding(LayoutInflater inflater) {
        return M001FrmSplashBinding.inflate(inflater);
    }
}
