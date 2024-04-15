package com.example.basedroidxml.model

import java.io.Serializable

data class AuthenticationModel(

    var status_code: Int,
    var token: String,
    var message: String,
    var `data`: Data,

    var host_email: String = "",
    var host_name: String = "",
    var host_profile: String = "",
    var member_name: String = "",
    var member_profile: String = ""

)

data class Data(
    var message: String,
    var apple_id: String,
    var hide_button: Int,
    var is_read: Int,
    var country_code: String,
    var created_at: String,
    var deleted_at: String,
    var email: String,
    var email_verified_at: String,
    var facebook_id: String,
    var google_id: String,
    var id: Int,
    var is_account_active: Int,
    var notification: Int,
    var latitude: String,
    var longitude: String,
    var name: String,
    var distance: String,
    var phone: String,
    var profile_pic: String,
    var role_id: Int,
    var role_type: String,
    var updated_at: String,


    var is_accepted: Int,
    var is_email_sent: Int,
    var member_email: String,
    var relation: Int,
    var relation_name: String,
    var user_id: Int,

    val category: String,
    val category_id: String,
    val event_date: String,
    val is_cancelled: String,
    val event_details: String,
    val other_category_name: String?,
    val event_name: String,
    val event_pic: String,
    val is_reminder: Int,

    val host_email: String,
    val host_name: String,
    val host_profile: String,
    val is_host: Boolean,
    val member_name: String,
    val member_profile: String,
    var media_type: Int,
    var media_file: String,
    var v_thumbnail: String,

    var group_id:Int,
    var members_count:Int,
    var group_name:String,
    var group_photo:String,
    var group_description:String,

    ) : Serializable