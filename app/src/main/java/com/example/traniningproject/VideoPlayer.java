package com.example.traniningproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    private VideoView Vview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        //initialization
        Vview = (VideoView) findViewById(R.id.ContainervideoView);

        /**
         * @param setVideoPath(Path)
         * set the url or path of the video @FILE raw/spoken_word.mp4
         */
        Vview.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.spoken_word);

        //assigning the controller to the video view
        MediaController controller = new MediaController(this);
        controller.setAnchorView(Vview);
        Vview.setMediaController(controller);
        Vview.start();

    }
}
