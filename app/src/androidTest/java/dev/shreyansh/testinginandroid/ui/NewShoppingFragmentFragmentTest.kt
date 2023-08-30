package dev.shreyansh.testinginandroid.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import org.junit.Before
import org.junit.runner.RunWith
import dev.shreyansh.testinginandroid.R
import org.junit.Test

import org.junit.Assert.*


@RunWith(AndroidJUnit4::class)
@MediumTest
class NewShoppingFragmentFragmentTest{

    private lateinit var scenario: FragmentScenario<NewShoppingFragmentFragment>

    @Before
    fun setup(){
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_TestingInAndroid)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testFrag(){
        onView(withId(R.id.textView)).check(matches(withText("TextView")))
    }
}