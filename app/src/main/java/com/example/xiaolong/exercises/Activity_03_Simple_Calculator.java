package com.example.xiaolong.exercises;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_03_Simple_Calculator extends Activity {

    public EditText operand_1_edittext;
    public EditText operand_2_edittext;
    public EditText result_edittext;

    private Double operand_1;
    private Double operand_2;
    private Double result;

    private static final String LOG_TAG = "SimpleCalculator";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_03__simple__calculator);

        operand_1_edittext = (EditText) findViewById(R.id.activity_03_simple_calculator_operand_1_edittext);
        operand_2_edittext = (EditText) findViewById(R.id.activity_03_simple_calculator_operand_2_edittext);
        result_edittext = (EditText) findViewById(R.id.activity_03_simple_calculator_default_result_edittext);
    }

    public void add(View view) {
        try {
            operand_1 = Double.parseDouble(operand_1_edittext.getText().toString());
            operand_2 = Double.parseDouble(operand_2_edittext.getText().toString());
            result = operand_1 + operand_2;
            result_edittext.setText(result.toString());
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
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Enter decimal values!", Toast.LENGTH_SHORT).show();
        }
    }


}
