package id.indocyber.common.entity.berita


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("mews")
    val news : ArrayList<NewsResponseItem>
)