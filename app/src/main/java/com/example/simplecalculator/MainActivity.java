package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String input = "";
    private String operator = "";
    private double operand1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.tvDisplay);

        int[] buttons = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnAdd, R.id.btnSubtract, R.id.btnEquals, R.id.btnClear
        };

        for (int id : buttons) {
            findViewById(id).setOnClickListener(this::handleInput);
        }
    }

    private void handleInput(View view) {
        Button button = (Button) view;
        String value = button.getText().toString();

        switch (value) {
            case "C":
                clear();
                break;
            case "+":
            case "-":
                setOperator(value);
                break;
            case "=":
                calculate();
                break;
            default:
                addNumber(value);
                break;
        }
        display.setText(input);
    }

    private void addNumber(String number) {
        input += number;
    }

    private void setOperator(String op) {
        if (!input.isEmpty()) {
            operand1 = Double.parseDouble(input);
            operator = op;
            input = "";
        }
    }

    private void calculate() {
        if (!input.isEmpty()) {
            double operand2 = Double.parseDouble(input);
            if (operator.equals("+")) {
                input = String.valueOf(operand1 + operand2);
            } else if (operator.equals("-")) {
                input = String.valueOf(operand1 - operand2);
            }
        }
    }

    private void clear() {
        input = "";
        operator = "";
        operand1 = 0;
    }
}
