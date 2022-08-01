package id.indocyber.api_service.service.news

import id.indocyber.common.entity.berita.NewsResponse
import id.indocyber.common.entity.berita.NewsResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {
    @GET("posts")
    suspend fun getNews() : Response<List<NewsResponseItem>>
}