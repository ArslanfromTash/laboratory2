package ru.mirea.akhmerov.lifedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements Observer<String> {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        TimeLiveData.getDate().observe(this, this);
        Handler handler = new Handler();
        handler.postDelayed(TimeLiveData::setTime, 5000);
    }

    public void onChanged(@Nullable String s) {
        Log.d(MainActivity.class.getSimpleName(), s + "");
        textView.setText("" + s);
    }
}