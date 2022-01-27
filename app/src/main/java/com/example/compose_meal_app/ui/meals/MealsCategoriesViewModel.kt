package com.example.compose_meal_app.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_meal_app.model.MealsRepository
import com.example.compose_meal_app.model.reponse.MealCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// ViewModel holds the list state, so the UI listens to the ViewModel when changes are made. Changes will recompose
class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {

    init {
        // This is a coroutine, for handling async tasks. ViewModelScope will keep the coroutine alive as long as the ViewModel
        viewModelScope.launch(Dispatchers.IO) { // IO = thread for networking/data, main = thread for UI, default = thread for CPU tasks
            val meals = getMeals()
            mealsState.value = meals // updating the list state
        }
    }

    // Holding the list state, will be accessed by the UI
    val mealsState: MutableState<List<MealCategory>> = mutableStateOf(emptyList())

    // Again delegates from repository, but will only be used here in the ViewModel
    private suspend fun getMeals() : List<MealCategory> {
        return repository.getMeals().categories
    }
}