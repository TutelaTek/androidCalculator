package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Double previousNumber;
    String operator ;
    String input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void clear(View view){
        previousNumber = null;
        operator = null;
        input = null; //might break here
        TextView calcInput = (TextView)findViewById(R.id.calcInput);
        calcInput.setText("");
        TextView equation = (TextView)findViewById(R.id.equation);
        equation.setText("");
    }

    public void cancel(View view){
        TextView calcInput = (TextView)findViewById(R.id.calcInput);
        calcInput.setText("");
    }



    public void equals(View view){
        TextView calcInput = (TextView)findViewById(R.id.calcInput);
        Double answer = 0.;

        if(!(calcInput.getText().toString().equals(""))) {
            switch (operator) {
                case "+":
                    answer = previousNumber + Double.parseDouble(calcInput.getText().toString());
                    break;

                case "-":
                    answer = previousNumber - Double.parseDouble(calcInput.getText().toString());
                    break;

                case "÷":
                    answer = previousNumber / Double.parseDouble(calcInput.getText().toString());
                    break;

                case "x":
                    answer = previousNumber * Double.parseDouble(calcInput.getText().toString());
                    break;

                case "%":
                    answer = previousNumber % Double.parseDouble(calcInput.getText().toString());
                    break;

            }
            String ans = answer.toString();
            calcInput.setText(ans);
            previousNumber = answer;
            TextView equation = (TextView) findViewById(R.id.equation);
            equation.setText("");
        }
    }

    public void operations(View view){

        TextView calcInput = (TextView)findViewById(R.id.calcInput);

        // error

        if(!(calcInput.getText().toString().equals(""))) {
            previousNumber = Double.parseDouble(calcInput.getText().toString());
            calcInput.setText("");
        Button b = (Button)findViewById(view.getId());
        String buttonText = b.getText().toString();
        operator = buttonText;
        TextView equation = (TextView)findViewById(R.id.equation);
        String op = previousNumber.toString() + operator;
        equation.setText(op);
        }




    }



    public void numbers(View view){

        Button b = (Button)findViewById(view.getId());
        String buttonText = b.getText().toString();
        TextView calcInput = (TextView)findViewById(R.id.calcInput);
        input = calcInput.getText().toString();
        if(buttonText.equals("+/-")){

        }else if(buttonText.equals(".")){
            if(!(input.contains("."))){
                String concat = calcInput.getText().toString() + buttonText;
                calcInput.setText(concat);
            }
        } else
        {
            String concat = calcInput.getText().toString() + buttonText;
            calcInput.setText(concat);
        }


    }
}