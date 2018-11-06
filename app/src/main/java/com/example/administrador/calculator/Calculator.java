package com.example.administrador.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener{

    private enum OPERATOR{EQUAL, MULTIPLY, DIVIDE,PLUS,SUBTRACT}

    TextView txtResult;
    TextView txtCalculation;

    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationResult;
    private String calculationString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentNumber = "";
        calculationResult = 0;
        calculationString= "";

        txtResult = findViewById(R.id.txtResult);
        txtCalculation = findViewById(R.id.txtCalculation);

      //  findViewById(R.id.btnEqual).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
        findViewById(R.id.btnMultiply).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btnDivide).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btnPlus).setOnClickListener(Calculator.this);
        findViewById(R.id.btnClear).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btnSubtract).setOnClickListener(Calculator.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           // case R.id.btnEqual:
            //    break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationString = calculationString + " * ";
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btnDivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationString = calculationString + " / ";
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationString = calculationString + " + ";
                break;
            case R.id.btnClear:
                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btnSubtract:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationString = calculationString +  " - ";
                break;

        }
        txtCalculation.setText(calculationString);
    }

    private void numberIsTapped(int tappedNumber){
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResult.setText(currentNumber);

        calculationString = currentNumber;
        txtCalculation.setText(calculationString);
    }

    private void operatorIsTapped(OPERATOR operatorTapped){

        if(currentOperator != null){
            if(currentNumber != ""){
                stringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator){
                    case EQUAL:

                        break;
                    case MULTIPLY:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) *
                                            Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) /
                                            Integer.parseInt(stringNumberAtRight);
                        break;
                    case PLUS:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) +
                                            Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) -
                                            Integer.parseInt(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft = String.valueOf(calculationResult);
                txtResult.setText(stringNumberAtLeft);
                calculationString = stringNumberAtLeft;
            }}else{
                stringNumberAtLeft = currentNumber;
                currentNumber = "";}

        currentOperator = operatorTapped;
    }

}
