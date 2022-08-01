package id.indocyber.common.entity.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("error_reponse")
    val errorResponse: String,
    @SerializedName("is_success")
    val isSuccess: Boolean,
    @SerializedName("key")
    val key:String ="f27c0119fa2a8bb026c08fa374802c90"
)
