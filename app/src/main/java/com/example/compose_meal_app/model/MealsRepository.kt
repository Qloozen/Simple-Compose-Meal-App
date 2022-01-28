package com.example.compose_meal_app.model

import com.example.compose_meal_app.model.api.MealsWebService
import com.example.compose_meal_app.model.reponse.MealCategory
import com.example.compose_meal_app.model.reponse.MealCategoryList

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<MealCategory>()

    // Same function as in the api service. Acts more like the middleman between ViewModel and API call
    suspend fun getMeals(): MealCategoryList {
        var response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealCategory? {
        return cachedMeals.firstOrNull() { mealCategory -> mealCategory.id == id }
    }

    // Singleton pattern
    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }

}