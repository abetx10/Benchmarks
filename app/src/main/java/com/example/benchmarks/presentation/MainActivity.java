package com.example.benchmarks.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.benchmarks.R;

public class MainActivity extends AppCompatActivity {

    //    Button mCalculateBt;
    CollectionsTableFragment collTableFragment = new CollectionsTableFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}




