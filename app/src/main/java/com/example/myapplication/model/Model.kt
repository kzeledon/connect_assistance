package com.example.connect.model

enum class Brand(val value: String){
    TOYOTA("Toyota"),
    HONDA("Honda"),
    BMW("BMW");
}

data class Model(
    val name : String,
    val brand : Brand
)