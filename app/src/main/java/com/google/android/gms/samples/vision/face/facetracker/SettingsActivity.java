package com.google.android.gms.samples.vision.face.facetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by marcin on 08.04.18.
 */

public class SettingsActivity extends Activity {
    private Button button;
    private int sensity;
    private int alarmLength;
    private int threshold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SeekBar sensitySeekBar = (SeekBar) findViewById(R.id.seekBarSensity);
        sensitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                sensity = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar timeSeekBar = (SeekBar) findViewById(R.id.seekBarAlarmLength);
        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                alarmLength = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar thersholdSeekBar = (SeekBar) findViewById(R.id.seekBarThreshold);
        thersholdSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                threshold = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener((v) -> {
            Intent intent = new Intent(SettingsActivity.this, FaceTrackerActivity.class);
            intent.putExtra("sensity", sensity);
            intent.putExtra("sensityMax", sensitySeekBar.getMax());
            intent.putExtra("threshold", threshold);
            intent.putExtra("alarmLength", alarmLength);
            startActivity(intent);
        });
    }
}
