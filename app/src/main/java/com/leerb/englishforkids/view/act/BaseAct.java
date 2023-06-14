package com.leerb.englishforkids.view.act;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.leerb.englishforkids.R;
import com.leerb.englishforkids.view.OnMainCallBack;
import com.leerb.englishforkids.view.frm.BaseFragment;

import java.lang.reflect.Constructor;

public abstract class BaseAct<V extends ViewBinding, M extends ViewModel> extends AppCompatActivity implements View.OnClickListener, OnMainCallBack {
    protected V binding;
    protected M viewModel;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding();
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(getClassVM());
        initViews();
    }

    protected abstract Class<M> getClassVM();

    protected abstract void initViews();

    protected abstract V initViewBinding();

    @Override
    public void onClick(View v) {
        v.setAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
    }

    protected void notify(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void notify(int msgID) {
        Toast.makeText(this, msgID, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFragement(String tag, Object data, boolean isBacked) {
        try {
            Class<?> clazz = Class.forName(tag);
            Constructor<?> constructor = clazz.getConstructor();
            BaseFragment<?, ?> baseFragment = (BaseFragment<?, ?>) constructor.newInstance();
            baseFragment.setCallback(this);
            baseFragment.setData(data);
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            if (isBacked) {
                trans.addToBackStack(null);
            }
            trans.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.ln_main, baseFragment, tag).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
