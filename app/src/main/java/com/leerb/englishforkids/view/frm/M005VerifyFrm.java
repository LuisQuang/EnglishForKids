package com.leerb.englishforkids.view.frm;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.leerb.englishforkids.databinding.M004FrmSignInBinding;
import com.leerb.englishforkids.databinding.M005FrmVerifyBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M005VerifyFrm extends BaseFragment<M005FrmVerifyBinding, CommonVM> {
    public static String TAG = M005VerifyFrm.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {

        HandleSequentialInput();
        binding.cell1.setOnClickListener(this);
        binding.cell2.setOnClickListener(this);
        binding.cell3.setOnClickListener(this);
        binding.cell4.setOnClickListener(this);
        binding.cell5.setOnClickListener(this);
        binding.cell6.setOnClickListener(this);

        binding.btnConfirm.setOnClickListener(view -> {
            Toast.makeText(context, "Verification successful!", Toast.LENGTH_SHORT).show();
//            Hien progress, Neu xac thuc thanh cong thi thong bao dang ky thanh cong va chuyen den man hinh dang nhap
            callback.showFragement(M004SignInFrm.TAG, null, true);
        });
    }

    private void HandleSequentialInput() {
        OnTextWatcher watcher = (s, i, i1, i2) -> {
            if (s.length() == 1) {
                if (binding.cell1.isFocused()) {
                    binding.cell2.requestFocus();
                } else if (binding.cell2.isFocused()) {
                    binding.cell3.requestFocus();
                } else if (binding.cell3.isFocused()) {
                    binding.cell4.requestFocus();
                } else if (binding.cell4.isFocused()) {
                    binding.cell5.requestFocus();
                } else if (binding.cell5.isFocused()) {
                    binding.cell6.requestFocus();
                }
            }
        };
        binding.cell1.addTextChangedListener(watcher);
        binding.cell2.addTextChangedListener(watcher);
        binding.cell3.addTextChangedListener(watcher);
        binding.cell4.addTextChangedListener(watcher);
        binding.cell5.addTextChangedListener(watcher);
        binding.cell6.addTextChangedListener(watcher);
    }

    @Override
    protected void clickView(View view) {
        super.clickView(view);
        EditText v = (EditText) view;
        v.setText("");
    }

    @Override
    protected M005FrmVerifyBinding initViewBinding(LayoutInflater inflater) {
        return M005FrmVerifyBinding.inflate(inflater);
    }


}
