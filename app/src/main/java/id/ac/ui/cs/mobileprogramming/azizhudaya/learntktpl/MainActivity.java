package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(view -> sendNumber());

    }
    @SuppressLint("SetTextI18n")
    private void sendNumber() {
        TextView input1 = findViewById(R.id.inputNumber1);
        TextView input2 = findViewById(R.id.inputNumber2);
        TextView results = findViewById(R.id.results);

        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());

        int result = sumNumbers(num1,num2);
        results.setText("Hasil = " + result);

    }
    //untuk meload file native_lib library di app settings
    static {
        System.loadLibrary("lab6-1706979184");
    }

    //impementasi fungsi sumNumber pada c++
    private native int sumNumbers(int num1, int num2);


}