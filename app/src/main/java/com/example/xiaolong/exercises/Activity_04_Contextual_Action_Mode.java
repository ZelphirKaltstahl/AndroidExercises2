package com.example.xiaolong.exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Activity_04_Contextual_Action_Mode extends AppCompatActivity {

    private ActionMode mActionMode;
    private ActionMode.Callback mActionModeCallback;

    private TextView long_click_me_textview;

    private static final String LOG_TAG = "ContextualActionMode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_04__contextual__action__mode);

        long_click_me_textview = (TextView) findViewById(R.id.activity_04_long_click_me_textview);

        add_event_handlers();
        add_menu();
    }

    public void add_menu() {
        mActionModeCallback = new ActionMode.Callback() {
            // Called when the action mode is created; startActionMode() was called
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate a menu resource providing context menu items
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu, menu);
                return true;
            }

            // Called each time the action mode is shown. Always called after onCreateActionMode, but
            // may be called multiple times if the mode is invalidated.
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false; // Return false if nothing is done
            }

            // Called when the user selects a contextual menu item
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_reset_item:
                        Log.d(Activity_04_Contextual_Action_Mode.LOG_TAG, "Item clicked:" + item.getTitle());
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }

            }

            // Called when the user exits the action mode
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                mActionMode = null;
            }
        };
    }

    public void add_event_handlers() {
        long_click_me_textview.setOnLongClickListener(new View.OnLongClickListener() {
            // Called when the user long-clicks on someView
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }

                // Start the CAB using the ActionMode.Callback defined above
                mActionMode = startActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });
    }
}
