package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.ui.first;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.R;

public class FirstFragment extends Fragment {

    private DateModelViewModel mViewModel;
    private Chronometer chronometer;
    private boolean isStart;
    private Button mainButton;
    private Button resetButton;
    private long timeStopped;
    private Button recordButton;
    private Button recordListButton;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DateModelViewModel.class);
        chronometer = getActivity().findViewById(R.id.stopwatchTime);
        mainButton = getActivity().findViewById(R.id.mainButton);
        resetButton =  getActivity().findViewById(R.id.resetButton);
        recordButton = getActivity().findViewById(R.id.recordButton);
        recordListButton = getActivity().findViewById(R.id.recordList);

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

        mainButton.setOnClickListener(v -> {
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
        });
        resetButton.setOnClickListener(v -> {
            timeStopped = 0;
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.stop();
            mainButton.setText("Start");
            isStart = false;
        });
        recordButton.setOnClickListener(v -> {
            long timeRecorded = 0;
            if(isStart) {
                timeRecorded = SystemClock.elapsedRealtime() - chronometer.getBase();
            } else {
                timeRecorded = timeStopped;
            }
            mViewModel.insert(new DateModel(timeRecorded, new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime())));
        });

        recordListButton.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new SecondFragment());
            fragmentTransaction.commit();
        });
    }
}