package com.reza.calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by reza on 12/11/17.
 */

public class DisplayFragment extends Fragment implements CalculatorMVP.PublishToView {

    @BindView(R.id.lbl_display) TextView tvDisplay;

    public DisplayFragment() {}

    public static DisplayFragment newInstance(){
        return new DisplayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_display, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.imb_delete)
    public void onDeleteShortClick(View v){

    }

    @OnLongClick(R.id.imb_delete)
    public boolean onDeleteLongClick(View v){
        return true;
    }

    @Override
    public void showResult(String result) {

    }

    @Override
    public void showToastMessage(String message) {

    }
}
