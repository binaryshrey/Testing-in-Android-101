package dev.shreyansh.testinginandroid.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{


    @Test
    fun emptyUserNameReturnsFalse(){
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun duplicateUserNameReturnsFalse(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Peter",
            "123",
            "123"
        )
        assertThat(result).isFalse()

    }

    @Test
    fun unMatchingPwdReturnsFalse(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Rohan",
            "123",
            "1234"
        )
        assertThat(result).isFalse()

    }

    @Test
    fun invalidPwdReturnsFalse(){
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "1",
            "1"
        )
        assertThat(result).isFalse()

    }
}