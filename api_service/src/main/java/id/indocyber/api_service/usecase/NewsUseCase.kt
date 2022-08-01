package id.indocyber.api_service.usecase

import id.indocyber.api_service.service.news.NewsService
import id.indocyber.common.entity.base_response.ResponseApp
import id.indocyber.common.entity.berita.NewsResponse
import id.indocyber.common.entity.berita.NewsResponseItem
import kotlinx.coroutines.flow.flow

class NewsUseCase(val newsService: NewsService) {
    operator fun invoke() = flow<ResponseApp<List<NewsResponseItem>>> {
        try {
            emit(ResponseApp.loading())
            val data = newsService.getNews()
            if(data.isSuccessful){
                data.body()?.let {
                    emit(ResponseApp.success(it))
                } ?: run{
                    emit(ResponseApp.errorBackend(data.code(),data.errorBody()))
                }
            } else{
                emit(ResponseApp.errorBackend(data.code(), data.errorBody()))
            }
        }catch (e:Exception){
            emit(ResponseApp.errorSystem(e))
        }
    }
}