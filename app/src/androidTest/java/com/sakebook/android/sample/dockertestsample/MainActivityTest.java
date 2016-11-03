package com.sakebook.android.sample.dockertestsample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.spoon.Spoon;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by sakemotoshinya on 2016/11/03.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void cleanUp() throws Exception {
    }


    @Test
    public void launch() {
        getInstrumentation().waitForIdleSync(); // wait.
        Spoon.screenshot(activityRule.getActivity(), "screenshot1");
    }

    @Test
    public void checkView() {
        onView(withId(R.id.text))
                .check(matches(isDisplayed()));
    }
}
