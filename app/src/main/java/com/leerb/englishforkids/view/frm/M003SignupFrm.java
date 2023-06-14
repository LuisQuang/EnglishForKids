package com.leerb.englishforkids.view.frm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.leerb.englishforkids.databinding.M003FrmSignupBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M003SignupFrm extends BaseFragment<M003FrmSignupBinding, CommonVM> {
    public static String TAG = M003SignupFrm.class.getName();
    private FirebaseAuth mAuth;

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            currentUser.reload();
        }

        binding.btnSignIn.setOnClickListener(view -> signIn());

    }

    private void signIn() {
        String mail = binding.edtMail.getText().toString();
        String pass = binding.edtPass.getText().toString();
        String confPass = binding.edtConfPass.getText().toString();

        if (mail.isEmpty() || pass.isEmpty() || confPass.isEmpty()) {
            Toast.makeText(context, "Please enter all required information!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass.isEmpty() && !confPass.isEmpty() && !pass.equals(confPass)) {
            Toast.makeText(context, "The password does not match!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass.isEmpty() && !confPass.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(requireActivity(), task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(requireContext(), "ANgon cơm", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(requireContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            });
        }
    }

    private void updateUI(FirebaseUser user) {
        Log.i(TAG, "anh: ");
    }


    @Override
    protected M003FrmSignupBinding initViewBinding(LayoutInflater inflater) {
        return M003FrmSignupBinding.inflate(inflater);
    }
}
