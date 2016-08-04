package com.leonguevara.shapenumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        public boolean isTriangular(){
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber += x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public checkNumber(View view) {
            EditText number = (EditText) findViewById(R.id.numberText);
            String sNumber = number.getText().toString().trim();
            String message;

            if (!sNumber.isEmpty() && sNumber != null) {
                Number myNumber = new Number();
                myNumber.number = Integer.parseInt(sNumber);

                message = "Number " + myNumber.number;

                if (myNumber.isTriangular()) {
                    if (myNumber.isSquare()) {
                        message += " is both triangular and square";
                    } else {
                        message += " is a triangular number";
                    }
                } else {
                    if (myNumber.isSquare()) {
                        message += " is a square number";
                    } else {
                        message += " is neither triangular nor square";
                    }
                }
            } else {
                message = "You must input a whole number";
            }

            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
