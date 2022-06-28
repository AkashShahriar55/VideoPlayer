package com.akash.videoplayer

import android.media.MediaExtractor
import android.media.MediaFormat
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mediaExtractor = MediaExtractor();
        val uri = Uri.parse("android.resource://$packageName/raw/canon_in_d")

        mediaExtractor.setDataSource(this,uri,null);

        val numTracks = mediaExtractor.trackCount
        Log.d("extractor", "onCreate: " + numTracks)

        for(track in (0 until numTracks).withIndex()){
            val format = mediaExtractor.getTrackFormat(track.index)
            val mime = format.getString(MediaFormat.KEY_MIME)
            Log.d("extractor", "onCreate: " + track.value)

        }

//        int numTracks = extractor.getTrackCount();
//        for (int i = 0; i < numTracks; ++i) {
//            MediaFormat format = extractor.getTrackFormat(i);
//            String mime = format.getString(MediaFormat.KEY_MIME);
//            if (weAreInterestedInThisTrack) {
//                extractor.selectTrack(i);
//            }
//        }
//        ByteBuffer inputBuffer = ByteBuffer.allocate(...)
//        while (extractor.readSampleData(inputBuffer, ...) >= 0) {
//            int trackIndex = extractor.getSampleTrackIndex();
//            long presentationTimeUs = extractor.getSampleTime();
//            ...
//            extractor.advance();
//        }
//
//        extractor.release();
//        extractor = null;



    }





}