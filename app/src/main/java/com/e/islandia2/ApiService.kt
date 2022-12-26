package com.e.islandia2

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(value="earthquake/is")
    suspend fun getTerremotosIs(): Response<ResponseEarthquake>
}