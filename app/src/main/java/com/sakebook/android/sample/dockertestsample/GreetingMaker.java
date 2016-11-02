package com.sakebook.android.sample.dockertestsample;

import android.content.Context;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sakemotoshinya on 2016/11/02.
 */

public class GreetingMaker {

    private Context context;
    private Date date;

    public GreetingMaker(Context context, Date now) {
        this.context = context;
        this.date = now;
    }

    public String createGreet() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (5 <= hour && 11 > hour) {
            return context.getString(R.string.morning);
        } else if (11 <= hour && 17 > hour) {
            return context.getString(R.string.afternoon);
        } else if (17 <= hour && 22 > hour) {
            return context.getString(R.string.evening);
        } else {
            return context.getString(R.string.night);
        }
    }
}
