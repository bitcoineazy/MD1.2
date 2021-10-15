package com.example.md12_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mainEt;
    TextView resultTv;
    Double operand = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainEt = findViewById(R.id.mainET);
        resultTv = findViewById(R.id.result_tv);
    }

    public void numbersListener(View view) {
        Log.d("Numbers", "Нажата кнопка: " + view.getId());
        switch (view.getId()) {
            case (R.id.one_btn):
                mainEt.append("1");
                break;
            case (R.id.two_btn):
                mainEt.append("2");
                break;
            case (R.id.three_btn):
                mainEt.append("3");
                break;
            case (R.id.four_btn):
                mainEt.append("4");
                break;
            case (R.id.five_btn):
                mainEt.append("5");
                break;
            case (R.id.six_btn):
                mainEt.append("6");
                break;
            case (R.id.seven_btn):
                mainEt.append("7");
                break;
            case (R.id.eight_btn):
                mainEt.append("8");
                break;
            case (R.id.nine_btn):
                mainEt.append("9");
                break;
            case (R.id.zero_btn):
                mainEt.append("0");
                break;
            case (R.id.comma_btn):
                mainEt.append(".");
                break;
            case (R.id.reset_btn):
                mainEt.setText("");
                resultTv.setText("");
                operand = null;
                break;


        }
    }
    public void operationsListener(View view) {
        Log.d("Operations", "Нажата кнопка: " + view.getId());
        if (mainEt.getText().toString().length() > 0) {
            double number = Double.parseDouble(mainEt.getText().toString());
            if (operand == null) {
                operand = number;
                resultTv.append(String.valueOf(operand));
                mainEt.setText("");
            } else {
                switch (view.getId()) {
                    case (R.id.plus_image):
                        operand += number;
                        resultTv.append(" + " + number  + " = " + operand + " \n");
                        mainEt.setText("");
                        operand = null;
                        break;
                    case (R.id.minus_image):
                        operand -= number;
                        resultTv.append(" - " + number  + " = " + operand + " \n");
                        mainEt.setText("");
                        operand = null;
                        break;
                    case (R.id.multiply_image):
                        operand *= number;
                        resultTv.append(" × " + number  + " = " + operand + " \n");
                        mainEt.setText("");
                        operand = null;
                        break;
                    case (R.id.divide_image):
                        operand /= number;
                        resultTv.append(" ÷ " + number  + " = " + operand + " \n");
                        mainEt.setText("");
                        operand = null;
                        break;
                }
            }
        } else {
            //Если ничего не ввели
            Toast.makeText(getApplicationContext(), "Введите число",
                    Toast.LENGTH_LONG).show();
        }
    }
}