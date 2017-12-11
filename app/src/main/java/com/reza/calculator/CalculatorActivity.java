package com.reza.calculator;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        FragmentManager manager = getSupportFragmentManager();

        DisplayFragment displayFragment = DisplayFragment.newInstance();
        InputFragment inputFragment = InputFragment.newInstance();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frag_display, displayFragment);
        transaction.add(R.id.frag_input, inputFragment);
        transaction.commit();

        // Actually, the presenter should be initialized in the fragment it self, we'll get another example project
        CalculatorPresenter presenter = new CalculatorPresenter(displayFragment);
        displayFragment.setPresenter(presenter);
        inputFragment.setPresenter(presenter);
    }
}
