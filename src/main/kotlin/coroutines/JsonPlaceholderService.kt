package coroutines

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object JsonPlaceholderFactory {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    fun makeRetrofitService(): JsonPlaceholderService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(JsonPlaceholderService::class.java)
    }
}

interface JsonPlaceholderService {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class Post(
    val id: Int
)
