package com.reza.calculator;

/**
 * Created by reza on 12/11/17.
 */

public interface CalculatorMVP {

    // our views handles these methods
    interface PublishToView {
        void showResult(String result);

        void showToastMessage(String message);
    }

    //passes click events from our View (DisplayFragment), to the presenter
    interface ForwardDisplayInteractionToPresenter {
        void onDeleteShortClick();

        void onDeleteLongClick();
    }

    interface ForwardInputInteractionToPresenter {
        void onNumberClick(int number);

        void onDecimalClick();

        void onEvaluateClick();

        void onOperatorClick(String operator);
    }


}
