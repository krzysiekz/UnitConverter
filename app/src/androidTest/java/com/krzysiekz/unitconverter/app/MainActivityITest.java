package com.krzysiekz.unitconverter.app;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldDisplayProperResultWhenConvertingFromInchToCm() {
        //when
        onView(withId(R.id.input_number)).perform(ViewActions.typeText("2"));
        onView(withId(R.id.from_unit)).perform(ViewActions.typeText("in"));
        onView(withId(R.id.to_unit)).perform(ViewActions.typeText("cm"));
        onView(withId(R.id.convert_button)).perform(ViewActions.click());
        //then
        onView(withId(R.id.result_text)).check(matches(withText("5.08")));
    }

    @Test
    public void shouldDisplayProperResultWhenConvertingFromFahrenheitToCelsius() {
        //when
        onView(withId(R.id.input_number)).perform(ViewActions.typeText("-4"));
        onView(withId(R.id.from_unit)).perform(ViewActions.typeText("F"));
        onView(withId(R.id.to_unit)).perform(ViewActions.typeText("C"));
        onView(withId(R.id.convert_button)).perform(ViewActions.click());
        //then
        onView(withId(R.id.result_text)).check(matches(withText("-20.00")));
    }

    @Test
    public void shouldDisplayProperMessageWhenConversionNotSupported() {
        //when
        onView(withId(R.id.input_number)).perform(ViewActions.typeText("-4123"));
        onView(withId(R.id.from_unit)).perform(ViewActions.typeText("X"));
        onView(withId(R.id.to_unit)).perform(ViewActions.typeText("C123"));
        onView(withId(R.id.convert_button)).perform(ViewActions.click());
        //then
        onView(withId(R.id.result_text)).check(matches(withText("Conversion not supported!")));
    }
}