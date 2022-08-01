package id.indocyber.api_service

import id.indocyber.api_service.service.news.NewsService
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import retrofit2.create

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testNewsService(){
        runBlocking {
            val serviceResponse = RetrofitClient.client.create(NewsService::class.java).getNews()
            println(serviceResponse)
        }
    }
}