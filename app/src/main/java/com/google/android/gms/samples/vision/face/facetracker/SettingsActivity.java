package com.google.android.gms.samples.vision.face.facetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by marcin on 08.04.18.
 */

public class SettingsActivity extends Activity {
    private Button button;
    private Spinner spinner;
    private int sensity;
    private int alarmLength;
    private int threshold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        spinner = (Spinner) findViewById(R.id.soundSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sound, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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
            intent.putExtra("chosenAlarm", spinner.getSelectedItem().toString());
            startActivity(intent);
        });
    }
}
