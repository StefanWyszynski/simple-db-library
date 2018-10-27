package com.simple.sqldatabase.db_android_app;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test
 *
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentedTest {

    public static final String NEW_TEST_ITEM_TEXT = "New test item";

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void addButton_newItemExists() {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
        onView(withId(R.id.edittext)).perform(typeText(NEW_TEST_ITEM_TEXT), closeSoftKeyboard());
        onView(withId(R.id.checkbox)).perform(click());
        onView(withId(R.id.btn_add)).perform(click());

//        onData(anything())
//                .inAdapterView(allOf(withId(R.id.list), isDisplayed(),
//                        isDescendantOfA(allOf(withId(R.id.list), isDisplayed()))))
//                .atPosition(0)
//        onData(anything()).inAdapterView(withId(R.id.list)).atPosition(0).check();
//        assertEquals("com.simple.sqldatabase.db_android_app", appContext.getPackageName());

        //TODO check whether first row exists and has "New test item" tekst
    }

    @Test
    public void updateButton_willUpdateFirstRow() {
        onView(withId(R.id.edittext)).perform(typeText(NEW_TEST_ITEM_TEXT), closeSoftKeyboard());
        onView(withId(R.id.checkbox)).perform(click());
        onView(withId(R.id.btn_add)).perform(click());

        onView(withId(R.id.edittext)).perform(typeText("changed"), closeSoftKeyboard());
        onView(withId(R.id.checkbox)).perform(click());
        onView(withId(R.id.btn_update)).perform(click());

        //TODO check whether first row is changed
    }

    @Test
    public void loadButton_willLoadData() {
        onView(withId(R.id.edittext)).perform(typeText(NEW_TEST_ITEM_TEXT), closeSoftKeyboard());
        onView(withId(R.id.checkbox)).perform(click());
        onView(withId(R.id.btn_add)).perform(click());

        onView(withId(R.id.btn_load)).perform(click());

        //TODO check whether first row exists
    }


}
