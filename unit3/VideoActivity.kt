package com.example.unit3

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {
    var simpleVideoView:  VideoView? = null
    lateinit var mediaControls: MediaController
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        simpleVideoView = findViewById(R.id.videoView)
        mediaControls = MediaController(this@VideoActivity)
        if(mediaControls == null){
            mediaControls.setAnchorView(simpleVideoView)
        }

        simpleVideoView!!.setMediaController(mediaControls)
        simpleVideoView!!.setZOrderMediaOverlay(true)

        simpleVideoView!!.setVideoURI(Uri.parse(
            "android.resource://" + "com.example.unit3/" + R.raw.video
        ))
        simpleVideoView!!.requestFocus()
        simpleVideoView!!.setZOrderOnTop(false)

        simpleVideoView!!.start()
        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(
                applicationContext,
                "Thank You...!!!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}