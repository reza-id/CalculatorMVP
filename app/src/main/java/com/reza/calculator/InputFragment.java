package com.reza.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by reza on 12/11/17.
 */

public class InputFragment extends Fragment {

    private CalculatorMVP.ForwardInputInteractionToPresenter forwardInteraction;

    public void setPresenter(CalculatorMVP.ForwardInputInteractionToPresenter forwardInteraction) {
        this.forwardInteraction = forwardInteraction;
    }

    public InputFragment() {
        // Required empty public constructor
    }

    public static InputFragment newInstance(){
        return new InputFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @OnClick({R.id.btn_number_one, R.id.btn_number_two, R.id.btn_number_three, R.id.btn_number_four,
            R.id.btn_number_five, R.id.btn_number_six, R.id.btn_number_seven, R.id.btn_number_eight,
            R.id.btn_number_nine, R.id.btn_number_zero})
    public void onNumberClick(Button v){
        forwardInteraction.onNumberClick(
                Integer.parseInt(v.getText().toString())
        );
    }

    @OnClick({R.id.btn_operator_add, R.id.btn_operator_divide, R.id.btn_operator_multiply,
            R.id.btn_operator_subtract})
    public void onOperatorClick(Button v){
        forwardInteraction.onOperatorClick(v.getText().toString());
    }

    @OnClick(R.id.btn_decimal)
    public void onDecimalClick(Button v){
        forwardInteraction.onDecimalClick();
    }

    @OnClick(R.id.btn_evaluate)
    public void onEvaluateClick(Button v){
        forwardInteraction.onEvaluateClick();
    }
}
