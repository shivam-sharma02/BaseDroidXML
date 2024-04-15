package com.example.basedroidxml.model

object RequestBodies {

    data class LoginBody(
        val email: String,
        val password: String,
        val device_token: String,
        val device_type: String
    )

    data class SocialLoginBody(
        val email: String,
        val provider: String,
        val social_token: String,
        val device_token: String,
        val device_type: String
    )

    data class SignUpBody(
        val name: String,
        val email: String,
        val password: String,
        val country_code: String,
        val phone: String,
        val device_token: String,
        val device_type: String,
        val is_web: Int = 0
    )

    data class ForgotPasswordBody(
        val email: String
    )

    data class ChangePasswordBody(
        val old_password: String,
        val new_password: String,
        val confirm_password: String,
    )

}