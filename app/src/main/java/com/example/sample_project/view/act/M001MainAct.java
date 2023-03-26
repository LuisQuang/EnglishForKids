package com.example.sample_project.view.act;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sample_project.R;
import com.example.sample_project.databinding.ActivityHomeBinding;
import com.example.sample_project.viewmode.M001MainVM;

import java.io.InputStream;
import java.util.Arrays;

public class M001MainAct extends BaseAct<ActivityHomeBinding, M001MainVM> {


    private static final String TAG = M001MainAct.class.getName();

    @Override
    protected Class<M001MainVM> getClassVM() {
        return M001MainVM.class;
    }

    @Override
    protected void initViews() {

        AssetManager assetManager = getAssets();
        try {
            String[] listFileName = assetManager.list("photo/");
            Log.i(TAG, Arrays.toString(listFileName));
            binding.lnTopic.removeAllViews();

            for (String photoPath : listFileName) {

                View itemView = LayoutInflater.from(this).inflate(R.layout.item_topic, null);

                TextView tvName = itemView.findViewById(R.id.tv_topic);
                ImageView ivPhoto = itemView.findViewById(R.id.iv_topic);

                InputStream in = assetManager.open("photo/" + photoPath);
                Bitmap img = BitmapFactory.decodeStream(in);
                tvName.setText(photoPath.replace(".png", ""));
                ivPhoto.setImageBitmap(img);

                binding.lnTopic.addView(itemView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ActivityHomeBinding initViewBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void backPress() {

    }
}