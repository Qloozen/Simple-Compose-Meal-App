package com.example.compose_meal_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose_meal_app.ui.details.MealDetailsScreen
import com.example.compose_meal_app.ui.details.MealDetailsViewModel
import com.example.compose_meal_app.ui.meals.MealsCategoriesScreen
import com.example.compose_meal_app.ui.theme.ComposeMealAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodApp()
        }
    }
}

@Composable
private fun FoodApp() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            MealsCategoriesScreen() { mealId ->
                navigationController.navigate("destination_meal_details/${mealId}")
            }
        }
        composable(
            route = "destination_meal_details/{meal_id}",
            arguments = listOf(navArgument("meal_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailsScreen(meal = viewModel.mealState.value)
        }
    }
}



