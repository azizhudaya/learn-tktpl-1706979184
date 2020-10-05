package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean isStart;
    private Button mainButton;
    private long timeStopped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.stopwatchTime);
        mainButton = findViewById(R.id.mainButton);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int h   = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s= (int)(time - h*3600000- m*60000)/1000 ;
                String hh = h < 10 ? "0"+h: h+"";
                String mm = m < 10 ? "0"+m: m+"";
                String ss = s < 10 ? "0"+s: s+"";
                cArg.setText(hh+":"+mm+":"+ss);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(
                getApplicationContext(),
                "Press exit button to exit",
                Toast.LENGTH_SHORT
        ).show();
    }
    public void setStartStop(View view) {
        if(isStart) {
            timeStopped = SystemClock.elapsedRealtime() - chronometer.getBase();
            chronometer.stop();
            isStart = false;
            mainButton.setText("Start");
        }else{
            chronometer.setBase(SystemClock.elapsedRealtime() - timeStopped);
            chronometer.start();
            isStart = true;
            mainButton.setText("Stop");
        }
    }
    public void resetTime(View view) {
        timeStopped = 0;
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.stop();
        mainButton.setText("Start");
        isStart = false;
    }
    public void exitApp(View view) {
        super.onBackPressed();
    }
}