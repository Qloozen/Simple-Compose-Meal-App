package com.example.compose_meal_app.model.reponse

import com.google.gson.annotations.SerializedName

// Outer wrapper is a array of categories
data class MealCategoryList(val categories: List<MealCategory>)

// Single meal object with gson serialized names for mapping api names to the custom object names
data class MealCategory(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryThumb") val imageUrl: String,
    @SerializedName("strCategoryDescription") val description: String
)