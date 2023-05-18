package com.example.funstory.viewmode;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.lifecycle.ViewModel;

import com.example.funstory.App;
import com.example.funstory.model.Story;
import com.example.funstory.model.Topic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class M001MainVM extends ViewModel {

    public ArrayList<Topic> topics;
    public ArrayList<Story> stories;

    public void initTopics() {
        topics = new ArrayList<>();
        AssetManager assetManager = App.getInstance().getAssets();
        try {
            String[] listFileName = assetManager.list("photo/");
            for (String photoPath : listFileName) {
                InputStream in = assetManager.open("photo/" + photoPath);
                Bitmap img = BitmapFactory.decodeStream(in);
                String name = photoPath.replace(".png", "");
                topics.add(new Topic(name, img));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadListStory(Topic topic) {
        stories = new ArrayList<>();
        AssetManager assetManager = App.getInstance().getAssets();
        try {
            InputStream in = assetManager.open("story/" + topic.getName() + ".txt");
            InputStreamReader inputSReader = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputSReader);

            String name = null;
            StringBuilder content = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                if (name == null) {
                    name = line;
                } else if (line.contains("','0');")) {
                    Story story = new Story(name, content.toString());
                    stories.add(story);
                    name = null;
                    content = new StringBuilder();
                } else if (!line.isEmpty()) {
                    content.append(line).append("\n");
                }
                line = reader.readLine();
            }
            reader.close();
            in.close();
            inputSReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
