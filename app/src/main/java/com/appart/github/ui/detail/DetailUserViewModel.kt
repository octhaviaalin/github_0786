package com.appart.github.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appart.github.api.RetrofitUser
import com.appart.github.data.model.DetailUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel : ViewModel(){
    val user = MutableLiveData<DetailUserResponse>()

    fun setUserDetail(username: String){
        RetrofitUser.apiInstance
            .getUserDetail(username)
            .enqueue(object : Callback<DetailUserResponse> {
                override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

                override fun onResponse(
                    call: Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    if(response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

            })
    }

    fun getUserDetail() : LiveData<DetailUserResponse> {
        return user
    }
}