package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mainLine;
    private TextView secondLine;
    private String bufMain = "";
    private String bufSecond = "";
    private int firstNum;
    private int secondNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView
        mainLine = findViewById(R.id.mainLine);
        secondLine = findViewById(R.id.secondLine);
        //Buttons nums
        Button zero = findViewById(R.id.zero);
        zero.setOnClickListener(this);

        Button one = findViewById(R.id.one);
        one.setOnClickListener(this);

        Button two = findViewById(R.id.two);
        two.setOnClickListener(this);

        Button three = findViewById(R.id.three);
        three.setOnClickListener(this);

        Button four = findViewById(R.id.four);
        four.setOnClickListener(this);

        Button five = findViewById(R.id.five);
        five.setOnClickListener(this);

        Button six = findViewById(R.id.six);
        six.setOnClickListener(this);

        Button seven = findViewById(R.id.seven);
        seven.setOnClickListener(this);

        Button eight = findViewById(R.id.eight);
        eight.setOnClickListener(this);

        Button nine = findViewById(R.id.nine);
        nine.setOnClickListener(this);

        //Buttons operations
        Button plus = findViewById(R.id.plus);
        plus.setOnClickListener(this);

        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);

        }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            //Numbers
            case R.id.one:
                bufMain+=1;
                mainLine.setText(bufMain);
                break;
            case R.id.two:
                bufMain+=2;
                mainLine.setText(bufMain);
                break;
            case R.id.three:
                bufMain+=3;
                mainLine.setText(bufMain);
                break;
            case R.id.four:
                bufMain+=4;
                mainLine.setText(bufMain);
                break;
            case R.id.five:
                bufMain+=5;
                mainLine.setText(bufMain);
                break;
            case R.id.six:
                bufMain+=6;
                mainLine.setText(bufMain);
                break;
            case R.id.seven:
                bufMain+=7;
                mainLine.setText(bufMain);
                break;
            case R.id.eight:
                bufMain+=8;
                mainLine.setText(bufMain);
                break;
            case R.id.nine:
                bufMain+=9;
                mainLine.setText(bufMain);
                break;
            case R.id.zero:
                bufMain+=0;
                mainLine.setText(bufMain);
                break;
            //Operations
            case R.id.clear:
                bufMain="";
                mainLine.setText("");
                break;
            case R.id.plus:
                bufSecond+=bufMain+"+";
                firstNum = Integer.parseInt(bufMain);
                bufMain = "";
                secondLine.setText(bufSecond);
                mainLine.setText(bufMain);
                break;
        }
    }
}
