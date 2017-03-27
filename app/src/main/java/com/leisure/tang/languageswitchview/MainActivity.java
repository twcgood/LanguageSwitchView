package com.leisure.tang.languageswitchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.LSBt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = getResources().getConfiguration().locale;
                if (locale == Locale.CHINESE) {
                    LSUtil.switchLanguage(MainActivity.this, Locale.ENGLISH);
                } else {
                    LSUtil.switchLanguage(MainActivity.this, Locale.CHINESE);
                }
                LSUtil.updateViewLanguageforActivity(MainActivity.this);
            }
        });
    }
}
