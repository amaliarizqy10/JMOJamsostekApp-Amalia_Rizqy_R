package id.indocyber.common.entity.login

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("password")
    val password:String,
    @SerializedName("email")
    val email:String
)
