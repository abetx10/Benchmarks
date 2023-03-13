package com.example.benchmarks;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.benchmarks.presentation.MainActivity;
import com.example.benchmarks.presentation.adapter.CollectionsDataAdapter;
import com.example.benchmarks.presentation.adapter.MapsDataAdapter;
import com.google.android.material.tabs.TabLayout;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CollectionsAndMapsUiTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCollectionsUi() {
        onView(withId(R.id.bt_calculateCollections)).check(matches(isDisplayed()));
        onView(withId(R.id.ed_collectionSize)).check(matches(isDisplayed()));
        onView(withId(R.id.ed_collectionSize)).perform(typeText("10000"));
        onView(withId(R.id.bt_calculateCollections)).perform(click());
        onView(withId(R.id.ed_enterNumber)).check(matches(withText("10000")));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.bt_startCalc)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_collections)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_startCalc)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView = mActivityRule.getActivity().findViewById(R.id.rv_collections);
        CollectionsDataAdapter collDataAdapter = (CollectionsDataAdapter) recyclerView.getAdapter();
        onView(withId(R.id.rv_collections)).perform(scrollToPosition(collDataAdapter.getItemCount() - 1));
        onView(withId(R.id.rv_collections)).check(matches(atPosition(collDataAdapter.getItemCount() - 1, hasDescendant(withText(Matchers.greaterThanOrEqualTo("0"))))));
    }

    @Test
    public void testMapsUi() {
        onView(withId(R.id.tabLayout)).perform(selectTabAtPosition(1));
        onView(withId(R.id.ed_collectionSize)).check(matches(isDisplayed()));
        onView(withId(R.id.ed_collectionSize)).perform(typeText("20000"));
        onView(withId(R.id.bt_calculateCollections)).perform(click());
        onView(withId(R.id.ed_enterNumberMaps)).check(matches(isDisplayed()));
        onView(withId(R.id.ed_enterNumberMaps)).check(matches(withText("20000")));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.bt_startCalcMaps)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_maps)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_startCalcMaps)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView = mActivityRule.getActivity().findViewById(R.id.rv_maps);
        MapsDataAdapter mapsDataAdapter = (MapsDataAdapter) recyclerView.getAdapter();
        onView(withId(R.id.rv_maps)).perform(scrollToPosition(mapsDataAdapter.getItemCount() - 1));
        onView(withId(R.id.rv_maps)).check(matches(atPosition(mapsDataAdapter.getItemCount() - 1, hasDescendant(withText(Matchers.greaterThanOrEqualTo("0"))))));
    }

    public static ViewAction selectTabAtPosition(final int position) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), isAssignableFrom(TabLayout.class));
            }

            @Override
            public String getDescription() {
                return "Select tab at position " + position;
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((TabLayout) view).getTabAt(position).select();
            }
        };
    }

    private static Matcher<View> atPosition(final int position, @NonNull final Matcher<View> itemMatcher) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {
                RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
                if (viewHolder == null) {
                    // has no item on such position
                    return false;
                }
                return itemMatcher.matches(viewHolder.itemView);
            }
        };
    }
}