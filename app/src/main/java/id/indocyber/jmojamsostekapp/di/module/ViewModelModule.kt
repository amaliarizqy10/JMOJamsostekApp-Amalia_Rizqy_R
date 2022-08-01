package id.indocyber.jmojamsostekapp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import id.indocyber.api_service.service.news.NewsService
import id.indocyber.api_service.usecase.NewsUseCase
import id.indocyber.api_service.usecase.ProgramUseCase
import id.indocyber.common.entity.error_data.ErrorData
import id.indocyber.jmojamsostekapp.viewmodel.NewsViewModel
import id.indocyber.jmojamsostekapp.viewmodel.ProgramViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.ResponseBody
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.PrintWriter
import java.io.StringWriter

val vmModule = module {
    viewModel { NewsViewModel(get(), get()) }
    viewModel { ProgramViewModel(get(), get()) }
}

val networkService = module {

    single {
        OkHttpClient.Builder().addInterceptor {
            try {
                it.proceed(it.request())
            }catch (e:Exception){
                val sw = StringWriter()
                val pw = PrintWriter(sw)
                e.printStackTrace(pw)

                okhttp3.Response.Builder().code(0)
                    .body(
                        ResponseBody.create("application/json".toMediaTypeOrNull(), Gson().toJson(
                            ErrorData(sw.toString(),0)
                        ))).request(it.request())
                    .protocol(Protocol.HTTP_2)
                    .message(e.message.orEmpty())
                    .build()
            }
        }.build()
    }

    single {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(
            GsonConverterFactory.create(GsonBuilder().setLenient().create())
        ).build()
    }

    single {
        get<Retrofit>().create(NewsService::class.java)
    }
}

val usecasemodule = module{

    factory {
        NewsUseCase(get())
    }

    factory {
        ProgramUseCase()
    }
}