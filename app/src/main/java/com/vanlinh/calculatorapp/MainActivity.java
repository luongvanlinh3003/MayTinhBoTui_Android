package com.vanlinh.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textInput);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }else {
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroBtn(View view){
        updateText("0");
    }

    public void oneBtn(View view){
        updateText("1");
    }
    public void twoBtn(View view){
        updateText("2");
    }
    public void threeBtn(View view){
        updateText("3");
    }
    public void fourBtn(View view){
        updateText("4");
    }
    public void fiveBtn(View view){
        updateText("5");
    }
    public void sixBtn(View view){
        updateText("6");
    }
    public void sevenBtn(View view){
        updateText("7");
    }
    public void eightBtn(View view){
        updateText("8");
    }
    public void nineBtn(View view){
        updateText("9");
    }
    public void decimalBtn(View view){
        updateText(".");
    }

    public void congBtn(View view){
        updateText("+");
    }

    public void truBtn(View view){
        updateText("-");
    }

    public void nhanBtn(View view){
        updateText("x");
    }
    public void chiaBtn(View view){
        updateText("÷");
    }

    public void deleteAllBtn(View view){
       display.setText("");
    }

    public void deleteBtn(View view){
        String numberAfterRemove = deleteNumber(display.getText().toString());
        display.setText(numberAfterRemove);
        int index = display.getText().toString().length();
        display.setSelection(index);
    }

    public void resultBtn(View view){
       String userExp = display.getText().toString();
       userExp = userExp.replaceAll("÷", "/");
       userExp = userExp.replaceAll("x", "*");

       Expression exp = new Expression(userExp);

       String result = String.valueOf(exp.calculate());

       display.setText(result);
       display.setSelection(result.length());
    }

    public String deleteNumber(String number){
        int size = number.length();
        String tem = number.substring(0,size-1);
        return tem;
    }
}