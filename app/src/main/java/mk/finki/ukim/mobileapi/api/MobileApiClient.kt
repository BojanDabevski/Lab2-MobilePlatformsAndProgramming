package mk.finki.ukim.mobileapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MobileApiClient {
    companion object{
        private var mobileApi:MobileApi?=null
        fun getMobileApi():MobileApi?{
            if(mobileApi ==null)
            {
                mobileApi= Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MobileApi:: class.java)
            }
            return mobileApi
        }
    }
}