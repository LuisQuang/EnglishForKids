package com.example.funstory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.funstory.model.Story;
import com.example.sample_project.R;

import java.util.ArrayList;

public class MyPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private final ArrayList<Story> stories;
    private final Context context;

    public MyPagerAdapter(ArrayList<Story> stories, Context context) {
        this.stories = stories;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stories.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_story, container, false);
        TextView tvTitle = view.findViewById(R.id.tv_name);
        TextView tvContent = view.findViewById(R.id.tv_content);

        Story story = stories.get(position);
        tvContent.setText(story.getContent());
        tvTitle.setText(story.getName());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}


