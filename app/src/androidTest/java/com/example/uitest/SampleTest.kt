package com.example.uitest

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SampleTest {

    companion object {

        const val EMAIL_EXAMPLE_1 = "mail@mail.com"
        const val EMAIL_EXAMPLE_2 = "testemail@mail.com"
        const val EMAIL_EXAMPLE_3 = "testmail.com"

        const val STATUS_OK = "Status: OK"
        const val STATUS_FAIL = "Status: FAIL"
    }

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkEmailVerifier1() {

        onView(withId(R.id.email)).perform(typeText(EMAIL_EXAMPLE_1), closeSoftKeyboard())

        onView(withId(R.id.verify)).perform(click())

        onView(withId(R.id.result)).check(matches(withText(STATUS_OK)))
    }

    @Test
    fun checkEmailVerifier2() {

        onView(withId(R.id.email)).perform(typeText(EMAIL_EXAMPLE_2), closeSoftKeyboard())

        onView(withId(R.id.verify)).perform(click())

        onView(withId(R.id.result)).check(matches(withText(STATUS_OK)))
    }

    @Test
    fun checkEmailVerifier3() {

        onView(withId(R.id.email)).perform(typeText(EMAIL_EXAMPLE_3), closeSoftKeyboard())

        onView(withId(R.id.verify)).perform(click())

        onView(withId(R.id.result)).check(matches(withText(STATUS_FAIL)))
    }
}
