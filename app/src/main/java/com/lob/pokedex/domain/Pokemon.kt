package com.lob.pokedex.domain

data class Pokemon(
    val imagemUrl: String,
    val number: Int,
    val name: String,
    val types: List<PokemonType>
){
    val formatedNumber = number.toString().padStart(3,'0')
}

