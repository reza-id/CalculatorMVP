package com.reza.calculator;

/**
 * Created by reza on 12/11/17.
 */

public class CalculatorPresenter implements CalculatorMVP.ForwardDisplayInteractionToPresenter,
        CalculatorMVP.ForwardInputInteractionToPresenter, Calculation.CalculationResult {

    private CalculatorMVP.PublishToView publishResult;
    private Calculation calculation;

    public CalculatorPresenter(CalculatorMVP.PublishToView publishResult) {
        this.publishResult = publishResult;
        calculation = new Calculation();
        calculation.setCalculationResultListener(this);
    }

    @Override
    public void onDeleteShortClick() {
        calculation.deleteCharacter();
    }

    @Override
    public void onDeleteLongClick() {
        calculation.deleteExpression();
    }

    @Override
    public void onNumberClick(int number) {
        calculation.appendNumber(Integer.toString(number));
    }

    @Override
    public void onDecimalClick() {
        calculation.appendDecimal();
    }

    @Override
    public void onEvaluateClick() {
        calculation.performEvaluation();
    }

    @Override
    public void onOperatorClick(String operator) {
        calculation.appendOperator(operator);
    }

    @Override
    public void onExpressionChanged(String result, boolean successful) {
        if (successful) {
            publishResult.showResult(result);
        } else {
            publishResult.showToastMessage(result);
        }
    }
}
