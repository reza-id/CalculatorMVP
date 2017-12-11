package com.reza.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        DisplayFragment displayFragment = (DisplayFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_display);
        InputFragment inputFragment = (InputFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_input);

        // Actually, the presenter should be initialized in the fragment it self, we'll get another example project
        CalculatorPresenter presenter = new CalculatorPresenter(displayFragment);
        displayFragment.setPresenter(presenter);
        inputFragment.setPresenter(presenter);
    }
}
