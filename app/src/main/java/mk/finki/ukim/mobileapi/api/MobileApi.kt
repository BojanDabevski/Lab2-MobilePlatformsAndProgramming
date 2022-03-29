package mk.finki.ukim.mobileapi.api

import mk.finki.ukim.mobileapi.models.Data
import mk.finki.ukim.mobileapi.models.v3
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MobileApi {
    //@GET("v3/{id}")
    @GET("v3/{id}")
    fun getMoviesById(@Path("id") id:String): Call<v3>
}
