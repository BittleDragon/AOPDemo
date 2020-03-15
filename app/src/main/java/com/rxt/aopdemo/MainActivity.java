package com.rxt.aopdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_say_hello).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onSayHelloClick(true);
    }

    @LoginChecker
    private void onSayHelloClick(boolean loginCheck) {
        Log.d("main_hello", "继续执行");
    }
}
