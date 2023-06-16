package com.leerb.englishforkids.view.frm;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
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
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            currentUser.reload();
//        }

        binding.btnSignIn.setOnClickListener(view -> signIn());

    }

    private void signIn() {
        String mail = binding.edtMail.getText().toString();
        String pass = binding.edtPass.getText().toString();
        String confPass = binding.edtConfPass.getText().toString();

        boolean isDataEmpty = mail.isEmpty() || pass.isEmpty() || confPass.isEmpty();
        if (isDataEmpty) {
            Toast.makeText(context, "Please enter all required information!", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isMatch = pass.equals(confPass);
        if (!isMatch) {
            Toast.makeText(context, "The password does not match!", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(requireActivity(), task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(requireContext(), "Ngon cơm", Toast.LENGTH_SHORT).show();
                    toVerify();
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(requireContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    private void toVerify() {
//        Chuyen sang man hinh nhap OTP
        callback.showFragement(M005VerifyFrm.TAG, null, true);
        verifyWithOTP();
    }

    private void verifyWithOTP() {
// Gui OTP ve Mail
//        Nhap OTP tu mail va kiem tra, neu dung thi thong bao DK thanh cong va chuyen sang man hinh dang nhap
    }


    @Override
    protected M003FrmSignupBinding initViewBinding(LayoutInflater inflater) {
        return M003FrmSignupBinding.inflate(inflater);
    }
}
