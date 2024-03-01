package API

import data.InfoClass
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface APIService {
    @GET("character")
    suspend fun getCharacter(): Response<InfoClass>
}

object RetrofitService {
    private val baseURL = "https://rickandmortyapi.com/api/"

    fun createService(): APIService {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}