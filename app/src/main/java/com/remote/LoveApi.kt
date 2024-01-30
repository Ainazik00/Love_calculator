package com.remote

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")

    fun getCompatibility(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "3a5cf78851msh6107f6ddfdf3cccp1da377jsn1b4c2b5bb8cf",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ): retrofit2.Call<LoveModel>

}