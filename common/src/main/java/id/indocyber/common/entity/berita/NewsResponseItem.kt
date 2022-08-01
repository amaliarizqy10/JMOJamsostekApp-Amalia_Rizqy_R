package id.indocyber.common.entity.berita


import com.google.gson.annotations.SerializedName

data class NewsResponseItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)