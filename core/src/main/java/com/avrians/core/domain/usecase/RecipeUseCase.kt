package com.avrians.core.domain.usecase

import com.avrians.core.data.Resource
import com.avrians.core.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeUseCase {

    fun getRecipes(): Flow<Resource<List<Recipe>>>
    fun getDetailRecipe(id: Int): Flow<Resource<Recipe>>
    fun getRecipeById(id: Int): Flow<Recipe>
    fun getFavoriteRecipe(): Flow<List<Recipe>>
    fun setFavoriteRecipe(recipe: Recipe, state: Boolean)
}