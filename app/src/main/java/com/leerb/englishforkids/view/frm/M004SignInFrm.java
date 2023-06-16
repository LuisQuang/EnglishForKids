package com.leerb.englishforkids.view.frm;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.leerb.englishforkids.R;
import com.leerb.englishforkids.databinding.M004FrmSignInBinding;
import com.leerb.englishforkids.viewmode.CommonVM;

public class M004SignInFrm extends BaseFragment<M004FrmSignInBinding, CommonVM> {
    private static final int RC_SIGN_IN = 123;
    public static String TAG = M004SignInFrm.class.getName();
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        binding.tvSignup.setOnClickListener(this);
        binding.tvForgetPass.setOnClickListener(this);
        binding.trGg.setOnClickListener(this);
        binding.trSignWithFb.setOnClickListener(this);
        binding.checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
//              Luu thong tin dang nhap
            }
        });
        binding.btnBack.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        // Cấu hình đăng nhập bằng Google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso);
        // Đặt onClickListener cho nút đăng nhập bằng Google
    }

    @Override
    protected M004FrmSignInBinding initViewBinding(LayoutInflater inflater) {
        return M004FrmSignInBinding.inflate(inflater);
    }

    @Override
    protected void clickView(View v) {
        super.clickView(v);
        if (v.getId() == R.id.tv_signup) {
            callback.showFragement(M005VerifyFrm.TAG, null, true);
        } else if (v.getId() == R.id.tv_forget_pass) {
            callback.showFragement(M007ResetPassFrm.TAG, null, true);
        } else if (v.getId() == R.id.btn_back) {
            callback.backPress();
        } else if (v.getId() == R.id.tr_gg) {
            signIn();
        } else if (v.getId() == R.id.tr_sign_with_fb) {
            signWithFacebook();
        }
    }

    private void signWithFacebook() {
        Toast.makeText(context, "FB", Toast.LENGTH_SHORT).show();
    }

    // Xử lý kết quả trả về từ màn hình đăng nhập của Google
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Đăng nhập thành công, lấy token và đăng nhập vào Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Đăng nhập thất bại, hiển thị thông báo lỗi
                Log.e(TAG, "Anh: Google sign in failed", e);
                Toast.makeText(getActivity(), "Đăng nhập bằng Google thất bại", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Đăng nhập bằng tài khoản Google
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    // Đăng nhập vào Firebase bằng token của tài khoản Google
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(requireActivity(), task -> {
            if (task.isSuccessful()) {
                // Đăng nhập thành công, chuyển sang màn hình chính
                Toast.makeText(context, "Dang nhap thanh cong, chuyen sang man hinh chinh!", Toast.LENGTH_SHORT).show();
                String mail = mAuth.getCurrentUser().getEmail().trim();
                callback.showFragement(M008MainAppUI.TAG, mail, false);
                requireActivity().finish();
            } else {
                // Đăng nhập thất bại, hiển thị thông báo lỗi
                Log.i(TAG, "anh2222222: failure", task.getException());
                Toast.makeText(getActivity(), "Đăng nhập bằng Google thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
