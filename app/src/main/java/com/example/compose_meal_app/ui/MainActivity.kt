package com.example.compose_meal_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose_meal_app.ui.meals.MealsCategoriesScreen
import com.example.compose_meal_app.ui.theme.ComposeMealAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMealAppTheme {
                MealsCategoriesScreen()
            }
        }
    }
}



