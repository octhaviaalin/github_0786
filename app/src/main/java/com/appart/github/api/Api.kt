package com.appart.github.api


import com.appart.github.data.model.DetailUserResponse
import com.appart.github.data.model.User
import com.appart.github.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 345108e86d30b760186a1549094833bfee336574")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 345108e86d30b760186a1549094833bfee336574")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 345108e86d30b760186a1549094833bfee336574")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 345108e86d30b760186a1549094833bfee336574")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}