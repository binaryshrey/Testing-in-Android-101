package dev.shreyansh.testinginandroid.utils

import dev.shreyansh.testinginandroid.utils.RegistrationUtil.checkBraces
import org.junit.Test
import com.google.common.truth.Truth.assertThat


class BracesUtilTest{

    @Test
    fun bracesEmptyStringReturnsTrue(){
        val result = checkBraces("")
        assertThat(result).isTrue()
    }
}