package com.emsilabs.emsitether;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "USB Tether Notification. ", Snackbar.LENGTH_LONG)
                        .setAction("GO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.emsilabs.emsitether");
                                Intent ngintent = new Intent();
                                ngintent.setAction(Intent.ACTION_MAIN);
                                ComponentName com = new ComponentName("com.android.settings", "com.android.settings.TetherSettings");
                                ngintent.setComponent(com);
//                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(ngintent);
                            }
                        })
                        .show();
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
