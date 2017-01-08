package com.readsms.inbox;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.readsms.inboxmodule.InboxView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            FragmentManager fmanager = getSupportFragmentManager();
            FragmentTransaction transaction = fmanager.beginTransaction();
            transaction.replace(R.id.frmMain, new InboxView());
            transaction.commit();
        }

//        displaySmsLog();

    }

    private void displaySmsLog() {
        Uri allMessages = Uri.parse("content://sms/inbox");
//        Uri allMessages = Uri.parse("content://sms/");
//        Uri allMessages = Uri.parse(RECEIVED_MESSAGE_CONTENT_PROVIDER);
        //Cursor cursor = managedQuery(allMessages, null, null, null, null); Both are same
        Cursor cursor = this.getContentResolver().query(allMessages, null,
                null, null, null);

        while (cursor.moveToNext()) {
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                Log.d(cursor.getColumnName(i) + "", cursor.getString(i) + "");
            }
            Log.d("One row finished",
                    "**************************************************");
        }

    }
}
