package com.vguilhen.mvvm_estudo.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vguilhen.mvvm_estudo.models.Live
import com.vguilhen.mvvm_estudo.repositories.MainRepository
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

//Regra de negócios - é preciso extender a classe viewmodel, no construtor é preciso passar o repositório de dados criado
class MainViewModel constructor(private val repository : MainRepository) : ViewModel(){

    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives(){

        val request = repository.getAllLives()
        //passar o callback para delimitar o que ele fará após a requisição
        request.enqueue(object : Callback<List<Live>>{

            override fun onResponse(call: Call<List<Live>>, response : Response<List<Live>>) {
                // Quando houver uma resposta
                liveList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Live>>, t: Throwable) {
                // Quando houver falha
                errorMessage.postValue(t.message)

            }
        })

    }
}