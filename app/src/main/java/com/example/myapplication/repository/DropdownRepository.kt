package com.example.myapplication.repository

import com.example.connect.model.Brand
import com.example.connect.model.Model

class DropdownRepository {

    fun getCarData() = listOf(
            Model("Camry", Brand.TOYOTA),
            Model("Corolla", Brand.TOYOTA),
            Model("Sequoia", Brand.TOYOTA),
            Model("Civic", Brand.HONDA),
            Model("Fit", Brand.HONDA),
            Model("X1", Brand.BMW),
            Model("X2", Brand.BMW),
            Model("X3", Brand.BMW),
    )

    fun getBrands() = Brand.values()

}