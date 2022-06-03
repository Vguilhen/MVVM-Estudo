package com.vguilhen.mvvm_estudo.repositories

import com.vguilhen.mvvm_estudo.rest.RetrofitService

//Absrai a função do serviços - caso precise trocar uma biblioteca só precisará trocar em um lugar
class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllLives() = retrofitService.getAllLives()

}