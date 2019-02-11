package com.example.direction;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout main;
    float[] startPoint = new float[2];
    float[] endPoint = new float[2];


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main);

        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float x = event.getX();
                float y = event.getY();
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        startPoint[0] = x;
                        startPoint[1] = y;
                        break;
                    case MotionEvent.ACTION_UP:
                        endPoint[0] = x;
                        endPoint[1] = y;
                        //setColorA(startPoint,endPoint);
                        setColorL(startPoint,endPoint);
                        break;
                        /*
                        Log.d("TEST", " УГОЛ = " + ang);
                        Log.d("TEST", " Первая точка = (" + startPoint[0] + " ," + startPoint[1] + ")\n" +
                                "вторая точка = (" + endPoint[0] + " ," + endPoint[1] + ")");
                        break;
                        */
                }
                /**
                 * https://ru.wikihow.com/%D0%BD%D0%B0%D0%B9%D1%82%D0%B8-%D1%83%D0%B3%D0%BE%D0%BB-%D0%BD%D0%B0%D0%BA%D0%BB%D0%BE%D0%BD%D0%B0-%D0%BF%D1%80%D1%8F%D0%BC%D0%BE%D0%B9-%D0%BF%D0%BE-%D0%B4%D0%B2%D1%83%D0%BC-%D1%82%D0%BE%D1%87%D0%BA%D0%B0%D0%BC*/
                return true;
            }
        });
    }

    public void setColorA(float[] s, float[] e)
    {
        /**
         *        ( y2 - y1)
         *  = atan(--------)
         *        ( x2 - x1)
         */
        float angK = (e[1]-s[1])/(e[0] - s[0]); // угловой коэффициент
        double ang = Math.toDegrees(Math.abs(Math.atan(angK))); // угол
        if (ang<10)
            main.setBackgroundColor(getResources().getColor(R.color.green));
        if (ang>80)
            main.setBackgroundColor(getResources().getColor(R.color.yellow));
        if (ang>35&&ang<55)
            main.setBackgroundColor(getResources().getColor(R.color.red));
    }

    public void setColorL(float[] s, float[] e)
    {
        float LIM = 70;
        if (Math.abs(s[0]-e[0])>LIM&&Math.abs(s[1]-e[1])<LIM)
            main.setBackgroundColor(getResources().getColor(R.color.green));
        if (Math.abs(s[0]-e[0])<LIM&&Math.abs(s[1]-e[1])>LIM)
            main.setBackgroundColor(getResources().getColor(R.color.yellow));
        if (Math.abs(s[0]-e[0])>LIM&&Math.abs(s[1]-e[1])>LIM)
            main.setBackgroundColor(getResources().getColor(R.color.red));
    }

}
