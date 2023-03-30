package com.example.myapplication.di

import com.example.myapplication.repository.DropdownRepository
import com.example.myapplication.viewmodel.DropdownViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dropDownModule = module {
    single{ DropdownRepository() }

    viewModel { DropdownViewModel(get()) }
}
