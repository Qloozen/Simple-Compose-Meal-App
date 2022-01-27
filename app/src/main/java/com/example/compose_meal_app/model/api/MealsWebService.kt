package com.example.compose_meal_app.model.api

import com.example.compose_meal_app.model.reponse.MealCategoryList
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit call to the api and returning a MealCategoryList
class MealsWebService {
    private var client: MealsApi

    init {
        // Creating the retrofit client
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        client = retrofit.create(MealsApi::class.java)
    }

    // Defining a method that gets the list of categories, will only be called by the repository
    suspend fun getMeals(): MealCategoryList {
        return client.getMeals()
    }

    // Interface declaring all the endpoint calls
    interface MealsApi {
        @GET("categories.php")
        suspend fun getMeals(): MealCategoryList
    }
}