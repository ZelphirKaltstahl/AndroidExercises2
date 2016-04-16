package com.example.xiaolong.exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_05_Context_Menu extends AppCompatActivity {

    private static final String LOG_TAG = "ContextMenu";

    private TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_05__context__menu);

        textview = (TextView) findViewById(R.id.activity_05_long_click_me_textview);

        add_event_handlers();
    }

    private void add_event_handlers() {
        textview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(Activity_05_Context_Menu.LOG_TAG, "Opening context menu ...");
                registerForContextMenu(view);
                view.showContextMenu();
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_reset_item:
                Log.d(Activity_05_Context_Menu.LOG_TAG, "Item selected: " + item.getTitle());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
