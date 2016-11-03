package com.sakebook.android.sample.dockertestsample;

import android.content.Context;
import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by sakemotoshinya on 2016/11/03.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class GreetingMakerTest {

    Context context = RuntimeEnvironment.application;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void greetByHour() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 11, 3, 5, 0);
        GreetingMaker greetingMaker = new GreetingMaker(context);
        assertEquals(context.getString(R.string.morning), greetingMaker.createGreet(calendar.getTime()));
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        assertEquals(context.getString(R.string.afternoon), greetingMaker.createGreet(calendar.getTime()));
        calendar.add(Calendar.HOUR_OF_DAY, 11);
        assertEquals(context.getString(R.string.night), greetingMaker.createGreet(calendar.getTime()));
        calendar.add(Calendar.MINUTE, -1);
        assertEquals(context.getString(R.string.evening), greetingMaker.createGreet(calendar.getTime()));
    }

    @Config(qualifiers="ja")
    @Test
    public void greetByJapanTimeZone() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 11, 3, 5, 0);
        GreetingMaker greetingMaker = new GreetingMaker(context);
        assertEquals("おはよう。", greetingMaker.createGreet(calendar.getTime()));
    }

    @Config(qualifiers="en")
    @Test
    public void greetByDefaultTimeZone() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 11, 3, 5, 0);
        GreetingMaker greetingMaker = new GreetingMaker(context);
        assertEquals("Good morning.", greetingMaker.createGreet(calendar.getTime()));
    }
}
