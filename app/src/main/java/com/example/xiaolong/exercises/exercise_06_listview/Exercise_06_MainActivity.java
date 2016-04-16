package com.example.xiaolong.exercises.exercise_06_listview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.xiaolong.exercises.R;

import java.util.ArrayList;
import java.util.List;

public class Exercise_06_MainActivity extends Activity {

    private static final String LOG_TAG = "Exercise06";
    private static final String ACTION_STRING = "com.example.xiaolong.OPEN_CALCULATOR";

    private static final int CALCULATOR_REQUEST_CODE = 0;

    private ListView listview;
    private ArrayList<String> list_of_equations;
    private ArrayAdapter<String> array_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_06__main);

        Log.d(Exercise_06_MainActivity.LOG_TAG, "instantiating the activity exercise 06");
        list_of_equations = new ArrayList<>();
        list_of_equations.add("e=mc^2");
        array_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list_of_equations);

        listview = (ListView) findViewById(R.id.exercise_06_listview);
        listview.setAdapter(array_adapter);

        add_event_handlers();
    }

    public void add_event_handlers() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String equation_string = (String) listview.getItemAtPosition(position);

                Intent intent = new Intent(Exercise_06_MainActivity.ACTION_STRING);
                intent.putExtra("equation", equation_string);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, Exercise_06_MainActivity.CALCULATOR_REQUEST_CODE);
                } else {
                    Log.d(Exercise_06_MainActivity.LOG_TAG, "No activity found to handle \"" + Exercise_06_MainActivity.ACTION_STRING + "\"");
                }
            }
        });
    }

    public void on_log_selected(View view) {
        List<Integer> list = get_checked_items();
        for(Integer item : list) {
            Log.d(Exercise_06_MainActivity.LOG_TAG, item.toString());
        }
    }

    private List<Integer> get_checked_items() {
        List<Integer> list_of_checked_items = new ArrayList<>();
        SparseBooleanArray checked = listview.getCheckedItemPositions();

        for (int i = 0; i < listview.getAdapter().getCount(); i++) {
            if (checked.get(i)) {
                list_of_checked_items.add(i);
            }
        }
        return list_of_checked_items;
    }

    public void on_open_calculator(View view) {
        Intent intent = new Intent(Exercise_06_MainActivity.ACTION_STRING);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, Exercise_06_MainActivity.CALCULATOR_REQUEST_CODE);
        } else {
            Log.d(Exercise_06_MainActivity.LOG_TAG, "No activity found to handle \"" + Exercise_06_MainActivity.ACTION_STRING + "\"");
        }
    }

    @Override
    protected void onActivityResult(int request_code, int result_code, Intent data) {
        super.onActivityResult(request_code, result_code, data);

        if (result_code == Activity.RESULT_OK) {
            if (request_code == Exercise_06_MainActivity.CALCULATOR_REQUEST_CODE) {
                String[] equations = data.getStringArrayExtra("equations");
                add_equations(equations);
            } else {
                Log.d(Exercise_06_MainActivity.LOG_TAG, "unrecognized request code");
            }
        } else {
            Log.d(Exercise_06_MainActivity.LOG_TAG, "result not ok");
        }
    }

    private void add_equations(String[] equations) {
        Log.d(Exercise_06_MainActivity.LOG_TAG, "adding equations");
        for (String equation : equations) {
            list_of_equations.add(equation);
        }
    }
}
