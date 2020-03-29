package com.deepanshu.android.blogpra;

import android.content.ComponentName;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//use for run test case in order

public class LoginActivityTest {
    private static final int ITEMBELOWFINDINLIST = 4;

    @Rule
    public IntentsTestRule<LoginActivity> mainActivityActivityTestRule = new IntentsTestRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void AA_LoginActivitydisplay(){
        onView(withId(R.id.firstActivity)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

    }

    @Test
    public void A_withSameCredentials() {
        onView(withId(R.id.Name)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        // intended(hasComponent(new ComponentName(getTargetContext(),Main2Activity.class)));
        //onView(withId(R.id.status)).check(matches(withText("successfull login")));
        //onView(withId(R.id.status)).perform((ViewAction) matches(withText("successfull login")));

    }

    @Test
    public void B_withdifferentCredentials() {
        onView(withId(R.id.Name)).perform(typeText("Alien"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("Alien"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        // intended(hasComponent(new ComponentName(getTargetContext(),Main2Activity.class)));
        onView(withId(R.id.status)).check(matches(withText("unSuccessfull login")));
        //onView(withId(R.id.status)).perform((ViewAction) matches(withText("successfull login")));

    }
    @Test //to check if the toast message is displayed if wrong credentials are filled
    public void C_shouldShowToast() {
        onView(withId(R.id.Name)).perform(typeText("Alien"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("Alien"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        onView(withText(R.string.toast)).inRoot(withDecorView(not(is(mainActivityActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

    }


    @Test
    public void D_callOtherActivity() {//used for show data on other intentactivtiy and verify that data
        onView(withId(R.id.Name)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), Main2Activity.class)));
        onView(withId(R.id.Name1)).check(matches(withText("deepanshu")));
        onView(withId(R.id.Password1)).check(matches(withText("deepanshu")));


    }



    @Test
    public void E_performBack_after_successfullLogin() {//used for show data on other intentactivtiy and verify that data
        onView(withId(R.id.Name)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), Main2Activity.class)));
        onView(withId(R.id.Name1)).check(matches(withText("deepanshu")));
        onView(withId(R.id.Password1)).check(matches(withText("deepanshu")));
        onView(withId(R.id.backbutton)).perform(click());
        onView(withId(R.id.firstActivity)).check(matches(isDisplayed()));
    }
    @Test
    public void F_showBlogs() {//used for show data on other intentactivtiy and verify that data
        onView(withId(R.id.Name)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), Main2Activity.class)));
        onView(withId(R.id.Name1)).check(matches(withText("deepanshu")));
        onView(withId(R.id.Password1)).check(matches(withText("deepanshu")));
        onView(withId(R.id.show_list)).perform(click());
        onView(withId(R.id.BlogActivity)).check(matches(isDisplayed()));
    }


    @Test
    public void G_isItemClickable() {
        onView(withId(R.id.Name)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        onView(withId(R.id.show_list)).perform(click());
        Espresso.onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
    @Test
    public void H_OnclickFab(){
        onView(withId(R.id.Name)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        onView(withId(R.id.show_list)).perform(click());
        /*RecyclerView recyclerView = rule.getActivity().findViewById(R.id.my_recycler_view);
        int itemcount = recyclerView.getAdapter().getItemCount()+1;*/
        Espresso.onView(withId(R.id.fab)).perform(click());
        Espresso.onView(withId(R.id.my_recycler_view)).check(matches(isDisplayed()));
       /* int itemcount2 = recyclerView.getAdapter().getItemCount();
        onView(withText("unSuccessfull login")).check(matches(withText("unSuccessfull login")));*/

    }
    /*@Test
    public void I_scrollToLast() {
        onView(withId(R.id.Name)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        onView(withId(R.id.show_list)).perform(click());
        RecyclerView recyclerView = rule.getActivity().findViewById(R.id.my_recycler_view);
        int itemcount = recyclerView.getAdapter().getItemCount();
        Espresso.onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions.scrollToPosition(itemcount - 1));
    }*/
    @Test
    public void J_titleDisplayOrNot() {
        onView(withId(R.id.Name)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("deepanshu"), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        onView(withId(R.id.show_list)).perform(click());
        Espresso.onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(ITEMBELOWFINDINLIST, click()));
        String itemVal = "World Global health";
        Espresso.onView(withText(itemVal)).check(matches(isDisplayed()));
    }



}