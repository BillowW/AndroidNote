package com.example.cap8_media

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")

        playV.setOnClickListener {
            if (!videoView.isPlaying) {
                videoView.start()
            }
        }

        pauseV.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
            }
        }

        pauseV.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.resume()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.suspend()
    }
}