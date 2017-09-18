package net.derohimat.sgpsi.features.psi;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import net.derohimat.sgpsi.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PsiListActivityUITest {

    @Rule
    public ActivityTestRule<PsiListActivity> activityTestRule =
            new ActivityTestRule<>(PsiListActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource() {
        mIdlingResource = activityTestRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void verifySpinnerData() {
        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.psi_list_spinner), isDisplayed()));
        appCompatSpinner.perform(click());

        onView(withText("O3 SubIndex")).check(matches(isDisplayed()));
        onView(withText("PM10 24 Hourly")).check(matches(isDisplayed()));
        onView(withText("CO SubIndex")).check(matches(isDisplayed()));
        onView(withText("PM25 24 Hourly")).check(matches(isDisplayed()));
        onView(withText("CO 8 Hour Max")).check(matches(isDisplayed()));
        onView(withText("SO2 24 Hourly")).check(matches(isDisplayed()));
        onView(withText("PM25 SubIndex")).check(matches(isDisplayed()));
        onView(withText("PSI 24 Hourly")).check(matches(isDisplayed()));
        onView(withText("O3 8 Hour Max")).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerViewShow() {
        onView(withId(R.id.psi_list_recyclerview)).check(matches(isDisplayed()));
    }

    @Test
    public void testSpinnerShow() {
        onView(withId(R.id.psi_list_spinner)).check(matches(isDisplayed()));
    }

    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }
}