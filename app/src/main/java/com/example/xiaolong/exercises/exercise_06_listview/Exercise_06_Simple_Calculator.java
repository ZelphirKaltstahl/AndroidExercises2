package com.example.xiaolong.exercises.exercise_06_listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiaolong.exercises.R;

import java.util.ArrayList;

public class Exercise_06_Simple_Calculator extends Activity {

    public EditText operand_1_edittext;
    public EditText operand_2_edittext;
    public EditText result_edittext;

    private Double operand_1;
    private Double operand_2;
    private Double result;

    private static final String LOG_TAG = "SimpleCalculator";

    private ArrayList<String> list_of_equations = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_06__simple__calculator);

        operand_1_edittext = (EditText) findViewById(R.id.activity_03_simple_calculator_operand_1_edittext);
        operand_2_edittext = (EditText) findViewById(R.id.activity_03_simple_calculator_operand_2_edittext);
        result_edittext = (EditText) findViewById(R.id.activity_03_simple_calculator_default_result_edittext);

        if (getIntent().hasExtra("equation")) {
            String initial_equation = getIntent().getStringExtra("equation");
            initialize_with_equation(initial_equation);
        } else {
            Log.d(Exercise_06_Simple_Calculator.LOG_TAG, "got no initial equation");
        }

    }

    private void initialize_with_equation(String initial_equation) {
        if (initial_equation.contains("+")) {
            String[] parts = initial_equation.split("\\+", -1);
            try {
                operand_1 = Double.parseDouble(parts[0].trim());
                operand_1_edittext.setText(operand_1.toString());
            } catch (NumberFormatException ex) {
                operand_1 = 0.0;
                operand_1_edittext.setText("0.0");
            }

            String[] remaining_parts = parts[1].split("=", -1);
            try {
                operand_2 = Double.parseDouble(remaining_parts[0].trim());
                operand_2_edittext.setText(operand_2.toString());
            } catch (NumberFormatException ex) {
                operand_2 = 0.0;
                operand_2_edittext.setText("0.0");
            }

            try {
                result = Double.parseDouble(remaining_parts[1].trim());
                result_edittext.setText(result.toString());
            } catch (NumberFormatException ex) {
                Log.d(Exercise_06_Simple_Calculator.LOG_TAG, "could not parse result to DOuble type");
            }

        } else if (initial_equation.contains("-")) {
            String[] parts = initial_equation.split("[-]", -1);
            try {
                operand_1 = Double.parseDouble(parts[0].trim());
                operand_1_edittext.setText(operand_1.toString());
            } catch (NumberFormatException ex) {
                operand_1 = 0.0;
                operand_1_edittext.setText("0.0");
            }

            String[] remaining_parts = parts[1].split("=", -1);
            try {
                operand_2 = Double.parseDouble(remaining_parts[0].trim());
                operand_2_edittext.setText(operand_2.toString());
            } catch (NumberFormatException ex) {
                operand_2 = 0.0;
                operand_2_edittext.setText("0.0");
            }

            try {
                Log.d(Exercise_06_Simple_Calculator.LOG_TAG, "Parsing:" + remaining_parts[1].trim());
                result = Double.parseDouble(remaining_parts[1].trim());
                result_edittext.setText(result.toString());
            } catch (NumberFormatException ex) {
                Log.d(Exercise_06_Simple_Calculator.LOG_TAG, "could not parse result to Double type");
            }

        } else if (initial_equation.contains("*")) {
            String[] parts = initial_equation.split("\\*", -1);
            try {
                operand_1 = Double.parseDouble(parts[0].trim());
                operand_1_edittext.setText(operand_1.toString());
            } catch (NumberFormatException ex) {
                operand_1 = 0.0;
                operand_1_edittext.setText("0.0");
            }

            String[] remaining_parts = parts[1].split("=", -1);
            try {
                operand_2 = Double.parseDouble(remaining_parts[0].trim());
                operand_2_edittext.setText(operand_2.toString());
            } catch (NumberFormatException ex) {
                operand_2 = 0.0;
                operand_2_edittext.setText("0.0");
            }

            try {
                result = Double.parseDouble(remaining_parts[1].trim());
                result_edittext.setText(result.toString());
            } catch (NumberFormatException ex) {
                Log.d(Exercise_06_Simple_Calculator.LOG_TAG, "could not parse result to DOuble type");
            }

        } else if (initial_equation.contains("/")) {
            String[] parts = initial_equation.split("/", -1);
            try {
                operand_1 = Double.parseDouble(parts[0].trim());
                operand_1_edittext.setText(operand_1.toString());
            } catch (NumberFormatException ex) {
                operand_1 = 0.0;
                operand_1_edittext.setText("0.0");
            }

            String[] remaining_parts = parts[1].split("=", -1);
            try {
                operand_2 = Double.parseDouble(remaining_parts[0].trim());
                operand_2_edittext.setText(operand_2.toString());
            } catch (NumberFormatException ex) {
                operand_2 = 0.0;
                operand_2_edittext.setText("0.0");
            }

            try {
                result = Double.parseDouble(remaining_parts[1].trim());
                result_edittext.setText(result.toString());
            } catch (NumberFormatException ex) {
                Log.d(Exercise_06_Simple_Calculator.LOG_TAG, "could not parse result to DOuble type");
            }
        } else {
            Log.d(Exercise_06_Simple_Calculator.LOG_TAG, "equation syntax not recognized");
        }
    }

    public void add(View view) {
        try {
            operand_1 = Double.parseDouble(operand_1_edittext.getText().toString());
            operand_2 = Double.parseDouble(operand_2_edittext.getText().toString());
            result = operand_1 + operand_2;
            result_edittext.setText(result.toString());
            list_of_equations.add(operand_1 + " + " + operand_2 + " = " + result.toString());
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Enter decimal values!", Toast.LENGTH_SHORT).show();
        }
    }

    public void substract(View view) {
        try {
            operand_1 = Double.parseDouble(operand_1_edittext.getText().toString());
            operand_2 = Double.parseDouble(operand_2_edittext.getText().toString());
            result = operand_1 - operand_2;
            result_edittext.setText(result.toString());
            list_of_equations.add(operand_1 + " - " + operand_2 + " = " + result.toString());
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Enter decimal values!", Toast.LENGTH_SHORT).show();
        }
    }

    public void multiply(View view) {
        try {
            operand_1 = Double.parseDouble(operand_1_edittext.getText().toString());
            operand_2 = Double.parseDouble(operand_2_edittext.getText().toString());
            result = operand_1 * operand_2;
            result_edittext.setText(result.toString());
            list_of_equations.add(operand_1 + " * " + operand_2 + " = " + result.toString());
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Enter decimal values!", Toast.LENGTH_SHORT).show();
        }
    }

    public void divide(View view) {
        try {
            operand_1 = Double.parseDouble(operand_1_edittext.getText().toString());
            operand_2 = Double.parseDouble(operand_2_edittext.getText().toString());
            result = operand_1 / operand_2;
            result_edittext.setText(result.toString());
            list_of_equations.add(operand_1 + " / " + operand_2 + " = " + result.toString());
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Enter decimal values!", Toast.LENGTH_SHORT).show();
        }
    }

    public void on_finish(View view) {
        String[] equations_array = new String[list_of_equations.size()];
        equations_array = list_of_equations.toArray(equations_array);

        Intent return_intent = new Intent();
        return_intent.putExtra("equations", equations_array);
        setResult(Activity.RESULT_OK, return_intent);
        finish();
    }
}
