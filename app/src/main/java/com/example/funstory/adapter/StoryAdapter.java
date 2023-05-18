package com.example.funstory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funstory.model.Story;
import com.example.sample_project.R;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder> {
    private final ArrayList<Story> stories;
    private final Context context;

    private final View.OnClickListener event;

    public StoryAdapter(ArrayList<Story> stories, Context context, View.OnClickListener event) {
        this.stories = stories;
        this.context = context;
        this.event = event;
    }

    @NonNull
    @Override
    public StoryAdapter.StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.i001_tem_story, parent, false);
        return new StoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.StoryHolder holder, int position) {
        Story story = stories.get(position);

        holder.tvStory.setTag(story);
        holder.tvStory.setText(story.getName());

    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class StoryHolder extends RecyclerView.ViewHolder {
        TextView tvStory;

        public StoryHolder(@NonNull View v) {
            super(v);
            tvStory = v.findViewById(R.id.tv_story);
            tvStory.setOnClickListener(view -> {
                view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.pop_enter));
                event.onClick(view);
            });

        }
    }
}
