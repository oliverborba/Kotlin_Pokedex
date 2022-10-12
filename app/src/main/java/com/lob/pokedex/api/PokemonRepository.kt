package com.lob.pokedex.api

import android.util.Log
import com.lob.pokedex.api.model.PokemonApiResult
import com.lob.pokedex.api.model.PokemonService
import com.lob.pokedex.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {

    private val service: PokemonService

    //https://pokeapi.co/api/v2/pokemon/?limit=1000

    init {
        val retofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 1000): PokemonsApiResult? {
        val call = service.listPokemons(limit)

        return call.execute().body()
    }

    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemon(number)

        return call.execute().body()
    }


}