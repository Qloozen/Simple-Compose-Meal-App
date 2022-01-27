package com.example.compose_meal_app.model

import com.example.compose_meal_app.model.api.MealsWebService
import com.example.compose_meal_app.model.reponse.MealCategoryList

class MealsRepository (private val webService: MealsWebService = MealsWebService()) {

    // Same function as in the api service. Acts more like the middleman between ViewModel and API call
    suspend fun getMeals(): MealCategoryList {
        return webService.getMeals()
    }
}