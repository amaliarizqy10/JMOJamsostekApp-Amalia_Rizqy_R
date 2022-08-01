package id.indocyber.jmojamsostekapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.indocyber.api_service.usecase.NewsUseCase
import id.indocyber.common.entity.base_response.ResponseApp
import id.indocyber.common.entity.berita.NewsResponseItem
import kotlinx.coroutines.launch

class NewsViewModel(application: Application, val newsUsecase: NewsUseCase) : AndroidViewModel(application) {

    val newsData = MutableLiveData<ResponseApp<List<NewsResponseItem>>>()

    init {
        getNews()
    }

    fun getNews (){
        viewModelScope.launch {
            newsUsecase.invoke().collect{
                newsData.postValue(it)
            }
        }
    }
}