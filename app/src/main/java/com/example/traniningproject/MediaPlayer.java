package com.example.traniningproject;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author sourabh karmakar
 */

public class MediaPlayer extends AppCompatActivity implements View.OnClickListener {

    private ImageButton playButton, forwardButton, rewindButton;
    protected SeekBar musicSeekBar;
    protected android.media.MediaPlayer musicPlayer;
    protected TextView currentTime, remainingTime, songName;
    private Boolean isPlaying = false;
    protected Handler musichandler;
    private int SEEK_TIME = 5000;

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
        songName = (TextView) findViewById(R.id.song_name_TV);

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
        musicPlayer = android.media.MediaPlayer.create(this, R.raw.gazab_ka_hai_din);

        //disable buttons and seek bar before starting the music
        musicSeekBar.setClickable(false);

    }

    @Override
    public void onClick(View v) {

        /**
         * @param v
         * implementation of click event of each button
         */
        switch (v.getId()) {

            //play button case
            case R.id.Play_btn:

                if (isPlaying) {
                    musicPlayer.pause();
                    playButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_circle));
                    isPlaying = false;
                } else {
                    musicPlayer.start();
                    musichandler = new Handler();
                    musichandler.postDelayed(updateSongTime, 100);
                    playButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_circle));
                    isPlaying = true;
                }
                break;

            //forward button case
            case R.id.forward_btn:
                if ((musicPlayer.getCurrentPosition()+SEEK_TIME)>musicPlayer.getDuration()){
                    musicPlayer.seekTo(0);
                }else {
                    musicPlayer.seekTo(musicPlayer.getCurrentPosition()+SEEK_TIME);
                }
                break;

            //rewind button case
            case R.id.reviewnd_btn:
                if ((musicPlayer.getCurrentPosition()-SEEK_TIME)<=0){
                    musicPlayer.seekTo(0);
                }else {
                    musicPlayer.seekTo(musicPlayer.getCurrentPosition()-SEEK_TIME);
                }
                break;
        }
    }

    private Runnable updateSongTime = new Runnable() {
        @Override
        public void run() {
            double current = musicPlayer.getCurrentPosition();
            double remM = (TimeUnit.MILLISECONDS.toMinutes((long) musicPlayer.getDuration())) - (TimeUnit.MILLISECONDS.toMinutes((long) musicPlayer.getCurrentPosition()));
            double rems = (TimeUnit.MILLISECONDS.toSeconds((long) musicPlayer.getDuration())) - (TimeUnit.MILLISECONDS.toSeconds((long) musicPlayer.getCurrentPosition()));
            currentTime.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes((long) current), TimeUnit.MILLISECONDS.toSeconds((long) current)));
            remainingTime.setText(String.format("%d:%d", (long) remM, (long) rems));
//            Log.e("result", "run: "+(musicPlayer.getCurrentPosition()*musicSeekBar.getMax())/musicPlayer.getDuration() );
            musicSeekBar.setProgress((musicPlayer.getCurrentPosition() * musicSeekBar.getMax()) / musicPlayer.getDuration());
            musichandler.postDelayed(this, 100);
        }
    };
}
