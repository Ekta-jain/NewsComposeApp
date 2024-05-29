package com.e4ekta.newscomposeapp

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope

object SignupFieldStateSaver : Saver<SignupFieldState, Any> {
    override fun restore(value: Any): SignupFieldState {
        // Cast the value to a Map<String, Any>
        val map = value as Map<String, Any>

        // Extract the values from the map
        val userName = map["userName"] as String
        val emailAddress = map["emailAddress"] as String
        val mobileNo = map["mobileNo"] as String
        val password = map["password"] as String
        val confirmPassword = map["confirmPassword"] as String

        // Return a new SignupFieldState object with the restored values
        return SignupFieldState(
            userName = userName,
            emailAddress = emailAddress,
            mobileNo = mobileNo,
            password = password,
            confirmPassword = confirmPassword
        )
    }

    override fun SaverScope.save(value: SignupFieldState): Any? {
        val map = mutableMapOf<String, Any>()

        // Put the values into the map
        map["userName"] = value.userName
        map["emailAddress"] = value.emailAddress
        map["mobileNo"] = value.mobileNo
        map["password"] = value.password
        map["confirmPassword"] = value.confirmPassword

        // Return the map
        return map
    }
}
