package com.sakebook.android.sample.dockertestsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GreetingMaker greetingMaker = new GreetingMaker(this);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(greetingMaker.createGreet(new Date()));
    }
}
