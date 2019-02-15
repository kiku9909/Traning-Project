package com.example.traniningproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author sourabh karmakar
 */

public class MediaPlayer extends AppCompatActivity implements View.OnClickListener {

    private ImageButton playButton,forwardButton,rewindButton;
    protected SeekBar musicSeekBar;
    protected android.media.MediaPlayer musicPlayer;
    protected TextView currentTime,remainingTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        
        //initialization of elements in UI
        playButton = (ImageButton) findViewById(R.id.Play_btn);
        forwardButton = (ImageButton) findViewById(R.id.forward_btn);
        rewindButton = (ImageButton) findViewById(R.id.reviewnd_btn);
        musicSeekBar = (SeekBar) findViewById(R.id.musicseekBar);
        currentTime = (TextView) findViewById(R.id.current_duration_tv);
        remainingTime = (TextView) findViewById(R.id.remaining_duration_tv);


        /**@param this
         * current instance of the button view
         * assigning the click event of Buttons
         */
        playButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        rewindButton.setOnClickListener(this);

        /**
         * assigning raw music file to
         * @code musicPlayer
         */
        musicPlayer = android.media.MediaPlayer.create(this,R.raw.gazab_ka_hai_din);

        //disable buttons and seek bar before starting the music
        musicSeekBar.setClickable(false);
        forwardButton.setEnabled(false);
        rewindButton.setEnabled(false);


    }

    @Override
    public void onClick(View v) {

        /**
         * @param v
         * implementation of click event of each button
         */
        switch (v.getId()){

            //play button case
            case R.id.Play_btn:
                break;

            //forward button case
            case R.id.forward_btn:
                break;

            //rewind button case
            case R.id.reviewnd_btn:
                break;
        }
    }

    private class MusicPlayingThread extends Thread{
        @Override
        public void run() {
            super.run();

        }
    }
}
