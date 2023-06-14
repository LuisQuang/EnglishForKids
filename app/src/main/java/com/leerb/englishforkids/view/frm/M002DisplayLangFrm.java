package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.leerb.englishforkids.CommonUtils;
import com.leerb.englishforkids.R;
import com.leerb.englishforkids.databinding.M002FrmLanguageBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M002DisplayLangFrm extends BaseFragment<M002FrmLanguageBinding, CommonVM> {
    public static String TAG = M002DisplayLangFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {

        binding.trViet.setOnClickListener(view -> {
            CommonUtils.getInstance().savePref(M001SplashFrm.KEY_LANG, "vietnamese");
            view.setVisibility(View.INVISIBLE);
//            Chuyen ngon ngu sang tieng Viet
        });
        binding.trEng.setOnClickListener(view -> {
            CommonUtils.getInstance().savePref(M001SplashFrm.KEY_LANG, "english");
            view.setVisibility(View.INVISIBLE);
        });

        binding.btnDone.setOnClickListener(view -> {
            view.setAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
            callback.showFragement(M004SignInFrm.TAG, null, true);
        });
    }

    @Override
    protected M002FrmLanguageBinding initViewBinding(LayoutInflater inflater) {
        return M002FrmLanguageBinding.inflate(inflater);
    }


}
