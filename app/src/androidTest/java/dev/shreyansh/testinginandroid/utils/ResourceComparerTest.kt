package dev.shreyansh.testinginandroid.utils

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ResourceComparerTest{

    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setUp() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun stringResourceSameAsGivenStringReturnsTrue(){
        val result = resourceComparer.isResourceEqual(ApplicationProvider.getApplicationContext(),
            dev.shreyansh.testinginandroid.R.string.app_name,"TestingInAndroid")
        assertThat(result).isTrue()

    }
}