package com.google.android.gms.samples.vision.face.facetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by marcin on 08.04.18.
 */

public class SettingsActivity extends Activity {
    private Button button;
    private Spinner spinner;
    private int sensibility;
    private int alarmLength;
    private int threshold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        TextView textThreshold = (TextView) findViewById(R.id.textThreshold);
        TextView textSensibility = (TextView) findViewById(R.id.textSensity);
        TextView textLength = (TextView) findViewById(R.id.textLength);

        // init values
        threshold = 35;
        sensibility = 45;
        alarmLength = 2;

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sound, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        SeekBar thersholdSeekBar = (SeekBar) findViewById(R.id.seekBarThreshold);
        thersholdSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                threshold = i;
                textThreshold.setText("Eye threshold: " + threshold + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar sensibilitySeekBar = (SeekBar) findViewById(R.id.seekBarSensibility);
        sensibilitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                sensibility = i;
                textSensibility.setText("Sensibility: " + sensibility * 2 + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar lengthSeekBar = (SeekBar) findViewById(R.id.seekBarLength);
        lengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                alarmLength = i + 1;
                textLength.setText("Alarm length: " + alarmLength + " s");
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
            intent.putExtra("sensibility", sensibility);
            intent.putExtra("sensibilityMax", sensibilitySeekBar.getMax());
            intent.putExtra("threshold", threshold);
            intent.putExtra("alarmLength", alarmLength);
            intent.putExtra("chosenAlarm", spinner.getSelectedItem().toString());
            startActivity(intent);
        });
    }
}
