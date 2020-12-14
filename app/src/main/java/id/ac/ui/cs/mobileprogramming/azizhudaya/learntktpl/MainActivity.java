package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        TextView counterText = findViewById(R.id.counter);
        fab.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            @Override
            public void onClick(View view) {
                counter++;
                counterText.setText(String.valueOf(counter));
            }
        });
    }
}