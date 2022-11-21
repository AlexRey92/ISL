package com.e.islandia2

data class Response (
    val results:List<Earthquake>
)

data class Earthquake (
    val timestamp:String,
    val latitude:Double,
    val longitude:Double,
    val depth:Double,
    val size:Double,
    val quality:Double,
    val humanReadableLocation:String


)