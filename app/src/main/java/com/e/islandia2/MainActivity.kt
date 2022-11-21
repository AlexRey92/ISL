package com.e.islandia2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TerremotoAdapter
    private var listadoDeTerremotos= listOf<Terremoto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerview)
        adapter= TerremotoAdapter()
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter

        getTerremotos()


    }

    private fun getTerremotos() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).getTerremotosIs()
            val response= call.body()
            runOnUiThread {
                if (call.isSuccessful){
                    listadoDeTerremotos= (response?.map { Earthquake->Earthquake.Mapear()}?:
                    adapter.submitList(listadoDeTerremotos)) as List<Terremoto>


                }else{
                    adapter.submitList(listOf())      }
            }
        }

    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    companion object{
        const val URL="https://apis.is/"
    }

}