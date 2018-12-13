package com.example.gabrielhuang.gymclub;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;

public class VideoActivity extends AppCompatActivity {

    VideoView mVideoView;
    MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        TextView pathTv = findViewById(R.id.path_tv);
        mVideoView = findViewById(R.id.video_view);

        String uri = "android.resource://" + getPackageName() + "/" + R.raw.test;
        mMediaController = new MediaController(this);
        mVideoView.setVideoURI(Uri.parse(uri));
        mVideoView.setMediaController(mMediaController);
        mVideoView.requestFocus();
        mVideoView.start();
        pathTv.setText(uri);

    }
}
