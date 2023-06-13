package com.leerb.englishforkids.view.frm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.leerb.englishforkids.view.OnMainCallBack;


public abstract class BaseFragment<V extends ViewBinding, M extends ViewModel> extends Fragment implements View.OnClickListener {

    protected Context context;
    protected V binding;
    protected M viewModel;
    protected OnMainCallBack callback;
    private Object data;
    protected OnRunUI updateUI;

    public void setUpdateUI(OnRunUI updateUI) {
        this.updateUI = updateUI;
    }

    public void setCallback(OnMainCallBack callback) {
        this.callback = callback;
    }

    public void setData(Object data) {
        this.data = data;
    }

    protected void notify(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    protected void notify(int msgID) {
        Toast.makeText(context, msgID, Toast.LENGTH_SHORT).show();
    }

    @Override
    public final void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBinding(inflater);
        viewModel = new ViewModelProvider(this).get(getClassVM());
        return binding.getRoot();
    }

    protected abstract Class<M> getClassVM();

    @Override
    public final void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public final void onClick(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
        clickView(view);
    }

    protected abstract void initViews();

    protected abstract V initViewBinding(LayoutInflater inflater);

    protected void clickView(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
    }


}
