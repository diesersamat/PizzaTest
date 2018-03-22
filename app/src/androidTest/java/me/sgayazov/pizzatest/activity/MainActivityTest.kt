package me.sgayazov.pizzatest.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import me.sgayazov.pizzatest.R
import org.junit.Test

class MainActivityTest {

    private val activity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkFabTest() {
        activity.launchActivity(null)

        onView(withId(R.id.floating_action_button))
                .perform(click())
    }
}