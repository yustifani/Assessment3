package org.d3if3124.galerianjing.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3124.galerianjing.ui.model.MessageResponse
import org.d3if3124.galerianjing.ui.model.AnjingCreate
import org.d3if3124.galerianjing.ui.model.Anjing
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://galeri-anjing.vercel.app/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()



private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface UserApi {
    @POST("anjings/")
    suspend fun addData(
        @Body anjing: AnjingCreate
    ): MessageResponse

    @GET("anjings/")
    suspend fun getAllData(
        @Query("user_email") email: String,
    ): List<Anjing>

    @DELETE("anjings/{anjing_id}")
    suspend fun deleteData(
        @Path("anjing_id") id: Int,
        @Query("email") email: String
    ): MessageResponse
}


object Api {
    val userService: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

}

enum class ApiStatus { LOADING, SUCCESS, FAILED }