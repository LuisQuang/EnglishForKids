package com.example.funstory.view.frm;

import android.view.LayoutInflater;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.funstory.App;
import com.example.funstory.adapter.MyPagerAdapter;
import com.example.funstory.viewmode.CommonVM;
import com.example.sample_project.databinding.M002ReadStoryBinding;

public class M002_ReadStory extends BaseFragment<M002ReadStoryBinding, CommonVM> {
    public static final String TAG = M002_ReadStory.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        setVisible();
        binding.actionBarMenu.ivBack.setOnClickListener(view -> callback.backPress());
        binding.actionBarMenu.tvTopic.setText(App.getInstance().getStorage().topicName);
        setAdapterViewpager();
        setOnPageChange();
    }

    private void setVisible() {
        binding.actionBarMenu.trIndex.setVisibility(View.VISIBLE);
        binding.actionBarMenu.ivMenu.setVisibility(View.INVISIBLE);
        binding.actionBarMenu.ivBack.setVisibility(View.VISIBLE);
    }

    private void setAdapterViewpager() {
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(App.getInstance().getStorage().mStories, context);
        binding.vpStory.setAdapter(pagerAdapter);
        int selectedStory = App.getInstance().getStorage().mStories.indexOf(App.getInstance().getStorage().mstory);
        binding.vpStory.setCurrentItem(selectedStory, true);
        binding.actionBarMenu.tvIndex.setText((String.format("%s%s/%s", (selectedStory < 9 ? "0" : ""), selectedStory + 1, App.getInstance().getStorage().mStories.size())));
    }

    private void setOnPageChange() {
        binding.vpStory.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.actionBarMenu.tvIndex.setText((String.format("%s%s/%s", (position < 9 ? "0" : ""), position + 1, App.getInstance().getStorage().mStories.size() + "")));
            }
        });
    }

    @Override
    protected M002ReadStoryBinding initViewBinding(LayoutInflater inflater) {
        return M002ReadStoryBinding.inflate(inflater);
    }
}
