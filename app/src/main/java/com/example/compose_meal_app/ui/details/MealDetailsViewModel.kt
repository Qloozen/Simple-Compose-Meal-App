package com.example.compose_meal_app.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.compose_meal_app.model.MealsRepository
import com.example.compose_meal_app.model.reponse.MealCategory

class MealDetailsViewModel(
    private val savedStateHandle:SavedStateHandle
    ): ViewModel() {
    private val repository: MealsRepository = MealsRepository.getInstance()

    var mealState = mutableStateOf<MealCategory?>(null)
    init {
        val mealId = savedStateHandle.get<String>("meal_id")?: ""
        mealState.value = repository.getMeal(mealId)
    }
}