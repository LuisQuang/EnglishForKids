package com.example.funstory.view.frm;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.funstory.App;
import com.example.funstory.CommonUtils;
import com.example.funstory.adapter.StoryAdapter;
import com.example.funstory.model.Story;
import com.example.funstory.model.Topic;
import com.example.funstory.viewmode.CommonVM;
import com.example.funstory.viewmode.M001MainVM;
import com.example.sample_project.R;
import com.example.sample_project.databinding.M001MenuStoriesBinding;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class M001_Menu extends BaseFragment<M001MenuStoriesBinding, M001MainVM> {
    public static final String SAVE_TOPIC = "SAVE_TOPIC";
    public static final String TAG = M001_Menu.class.getName();

    @Override
    protected Class<M001MainVM> getClassVM() {
        return M001MainVM.class;
    }

    @Override
    protected void initViews() {
        binding.actionbar.ivMenu.setOnClickListener(view -> binding.drawer.openDrawer(GravityCompat.START));
        viewModel.initTopics();
        showTopics();
    }

    private void showTopics() {
        showSavedTopic();
        if (viewModel.topics == null || viewModel.topics.isEmpty()) return;
        binding.menu.lnMenu.removeAllViews();
        for (Topic topic : viewModel.topics) {
            View topicView = LayoutInflater.from(context).inflate(R.layout.i001_item_topic, null);
            TextView tvName = topicView.findViewById(R.id.tv_topic);
            ImageView ivPhoto = topicView.findViewById(R.id.iv_topic);

            tvName.setText(topic.getName());
            ivPhoto.setImageBitmap(topic.getImg());
            topicView.setTag(topic);
            topicView.setOnClickListener(v -> clickTopicView((Topic) v.getTag()));
            binding.menu.lnMenu.addView(topicView);
        }
    }
    public void showSavedTopic() {
        if (viewModel.topics != null && !viewModel.topics.isEmpty()) {
            String topicName = CommonUtils.getInstance().getPref(M001_Menu.SAVE_TOPIC);
            if (topicName == null) {
                clickTopicView(viewModel.topics.get(0));
            } else {
                Topic topic = new Topic(topicName, null);
                int index = viewModel.topics.indexOf(topic);
                clickTopicView(viewModel.topics.get(index == -1 ? 0 : index));
            }
        }
    }
    public void clickTopicView(Topic topic) {
        CommonUtils.getInstance().savePref(SAVE_TOPIC, topic.getName());
        binding.drawer.closeDrawer(GravityCompat.START);
        binding.actionbar.tvTopic.setText(topic.getName());
        App.getInstance().getStorage().topicName = topic.getName();
        viewModel.loadListStory(topic);
        showStories();
    }

    private void showStories() {
        if (viewModel.stories == null || viewModel.stories.isEmpty()) return;
        StoryAdapter adapter = new StoryAdapter(viewModel.stories, context, v -> clickStory((Story) v.getTag()));
        binding.rvListStory.setLayoutManager(new LinearLayoutManager(context));
        binding.rvListStory.setAdapter(adapter);
    }

    private void clickStory(Story story) {
        App.getInstance().getStorage().mstory = story;
        App.getInstance().getStorage().mStories = viewModel.stories;
        callback.showFragement(M002_ReadStory.TAG, null, true);
    }

    @Override
    protected M001MenuStoriesBinding initViewBinding(LayoutInflater inflater) {
        return M001MenuStoriesBinding.inflate(inflater);
    }
}
