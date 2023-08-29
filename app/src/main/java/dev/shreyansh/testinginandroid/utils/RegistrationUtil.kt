package dev.shreyansh.testinginandroid.utils

object RegistrationUtil {


    private val existingUsers = listOf("Peter", "Carl")
    /**
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {

        if(username.isNullOrEmpty()){
            return false
        }
        if(username in existingUsers){
            return false
        }
        if(password != confirmedPassword){
            return false
        }
        if(password.count { it.isDigit() } < 2){
            return false
        }

        return true
    }




    /**
     * check if braces are correctly set
     * eg.: (a+b)) is incorrect
     *
     **/

    fun checkBraces(input: String): Boolean {
        var count = 0
        for (i in input){
            if(i == '('){
                count++
            }else if(i == ')'){
                count--
            }
            if(count < 0){
                return false
            }
        }
        return count == 0
    }

}