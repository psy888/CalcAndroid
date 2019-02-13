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
    private int operation;
    private int firstNum;
    private int secondNum;

    private static final int SUM = 0;
    private static final int MINUS = 1;
    private static final int MULTIPLY = 2;
    private static final int DIVISION = 3;

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

        Button minus = findViewById(R.id.minus);
        minus.setOnClickListener(this);

        Button multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(this);

        Button division = findViewById(R.id.division);
        division.setOnClickListener(this);

        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);

        Button result = findViewById(R.id.result);
        result.setOnClickListener(this);

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
                operation = 0;
                setFirstNum ();
                break;
            case R.id.minus:
                bufSecond+=bufMain+"-";
                operation = 1;
                setFirstNum ();
                break;
            case R.id.multiply:
                bufSecond+=bufMain+"*";
                operation = 2;
                setFirstNum ();
                break;
            case R.id.division:
                bufSecond+=bufMain+"/";
                operation = 3;
                setFirstNum ();
                break;
            case R.id.result:
                bufSecond+=bufMain+"=";
                checkResult();
                break;
        }
    }
    private void setFirstNum ()
    {
        if(bufMain.contentEquals(""))
        {
            bufMain = mainLine.getText().toString();
            bufSecond = bufMain + bufSecond;
        }
        firstNum = Integer.parseInt(bufMain);
        bufMain = "";
        secondLine.setText(bufSecond);
        mainLine.setText(bufMain);
    }
    private void checkResult()
    {
        if(!bufMain.contentEquals(""))
        {
            secondNum = Integer.parseInt(bufMain);
            bufMain = "";
            secondLine.setText(bufSecond);
            switch (operation)
            {
                case SUM:
                    mainLine.setText(""+(firstNum+secondNum));
                    bufSecond = "";
                    break;
                case MINUS:
                    mainLine.setText(""+(firstNum-secondNum));
                    bufSecond = "";
                    break;
                case MULTIPLY:
                    mainLine.setText(""+(firstNum*secondNum));
                    bufSecond = "";
                    break;
                case DIVISION:
                    if(secondNum!=0)
                    {
                        mainLine.setText(""+(firstNum/secondNum));
                    }
                    else
                    {
                        mainLine.setText("На ноль делить нельзя");
                    }
                    bufSecond = "";
                    break;
            }
        }
    }

}
