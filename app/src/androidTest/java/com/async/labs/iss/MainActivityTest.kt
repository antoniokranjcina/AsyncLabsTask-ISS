package com.async.labs.iss

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isActivityInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_toolbar_fragment_bottomNavigation() {
        onView(withId(R.id.app_bar_layout))
            .check(matches(isDisplayed()))

        onView(withId(R.id.toolbar))
            .check(matches(isDisplayed()))

        onView(withId(R.id.fragment))
            .check(matches(isDisplayed()))

        onView(withId(R.id.bottom_navigation))
            .check(matches(isDisplayed()))
    }
}