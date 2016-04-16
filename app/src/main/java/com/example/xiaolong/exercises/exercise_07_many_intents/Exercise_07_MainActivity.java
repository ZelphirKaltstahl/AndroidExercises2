package com.example.xiaolong.exercises.exercise_07_many_intents;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;

import com.example.xiaolong.exercises.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class Exercise_07_MainActivity extends Activity {

    private static String LOG_TAG = "Exercise07";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_07__main);
    }

    public void on_show_website(View view) {
        String url = "https://www.duckduckgo.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void on_show_website_search_term(View view) {
        String url = "https://duckduckgo.com/?q=android&ia=about";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void on_show_maps_with_location(View view) {
        double latitude = 52.5167;
        double longitude = 13.3833;
        String uri = "geo:" + latitude + "," + longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    public void on_show_contact(View view) {
        List<String> contact_ids = new ArrayList<>();
//        List<String> contact_names = new ArrayList<>();
//        List<String> contact_lookup_keys = new ArrayList<>();

        ContentResolver content_resolver = getContentResolver();
        Cursor cursor = content_resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                contact_ids.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID)));
//                contact_names.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
//                contact_lookup_keys.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY)));
            }
        }

//        for (int i = 0; i < contact_ids.size(); i++) {
//            Log.d(Exercise_07_MainActivity.LOG_TAG,
//                    "Contact Name: " + contact_names.get(i) +
//                            " Contact ID: " + contact_ids.get(i) +
//                            " LookupKey " + contact_lookup_keys.get(i)
//            );
//        }

        Intent show_contact_intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("content://contacts/people/" + contact_ids.get(1))
        );

        startActivity(show_contact_intent);
    }

    public void on_show_number(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);
    }

    public void on_dial_number(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:2000"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    public void on_create_alarm(View view) {
        String message = "This is an alarm! Not an exercise!";
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);

        intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
        intent.putExtra(AlarmClock.EXTRA_HOUR, 12);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 0);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void on_create_date(View view) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.DATE, 1);
        long tomorrow = gc.getTimeInMillis();
        gc.add(Calendar.DATE, 1);
        long day_after_tomorrow = gc.getTimeInMillis();

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, "MyEvent");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, tomorrow);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, day_after_tomorrow);
        intent.putExtra(CalendarContract.Events.ALL_DAY, false); // periodicity
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "This is a programmatically added event.");
        startActivity(intent);
    }

    public void on_send_email(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","example@example.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public void on_show_sms(View view) {
        final String PHONE_NUMBER = "0123456789";
        final String MESSAGE = "Hi, this is your SMS : )";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + PHONE_NUMBER));
        intent.putExtra("sms_body", MESSAGE);
        startActivity(intent);
    }

    public void on_send_sms(View view) {
        final String PHONE_NUMBER = "0123456789";
        final String MESSAGE = "Hi, this is your SMS : )";
        SmsManager sms_manager = SmsManager.getDefault();
        sms_manager.sendTextMessage(PHONE_NUMBER, null, MESSAGE, null, null);
    }
}
