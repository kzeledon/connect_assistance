package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connect.model.Model
import com.example.myapplication.repository.DropdownRepository

class DropdownViewModel(
    private val dropdownRepository: DropdownRepository
) : ViewModel() {

    private val _brandLiveData = MutableLiveData<List<String>>()
    val brandLiveData: LiveData<List<String>>
        get() = _brandLiveData

    private val _modelLiveData = MutableLiveData<List<String>>()
    val modelLiveData: LiveData<List<String>>
        get() = _modelLiveData

    private lateinit var data : List<Model>

    fun getData() {
        val brands = dropdownRepository.getBrands().map { it.value }
        data = dropdownRepository.getCarData()

        _brandLiveData.value = brands
    }

    fun getModels(brand : String) {
        val models = data.toMutableList().filter { it.brand.value == brand }.map { it.name }
        _modelLiveData.value = models
    }
}