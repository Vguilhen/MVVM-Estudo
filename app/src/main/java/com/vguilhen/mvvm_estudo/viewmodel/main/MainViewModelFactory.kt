package com.vguilhen.mvvm_estudo.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vguilhen.mvvm_estudo.repositories.MainRepository
import java.lang.IllegalArgumentException

// Necessário criar a Factory quando se tem uma VieModel com varios argumentos
class MainViewModelFactory constructor(private val repository : MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}