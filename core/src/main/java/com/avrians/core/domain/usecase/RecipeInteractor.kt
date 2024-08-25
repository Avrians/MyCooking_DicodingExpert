package com.avrians.core.domain.usecase

import com.avrians.core.domain.model.Recipe
import com.avrians.core.domain.repository.IRecipeRepository
import javax.inject.Inject

class RecipeInteractor @Inject constructor(
    private val recipeRepository: IRecipeRepository
) : RecipeUseCase {
    override fun getRecipes() = recipeRepository.getRecipes()

    override fun getDetailRecipe(id: Int) = recipeRepository.getDetailRecipe(id)

    override fun getRecipeById(id: Int) = recipeRepository.getRecipeById(id)

    override fun getFavoriteRecipe() = recipeRepository.getFavoriteRecipe()

    override fun setFavoriteRecipe(recipe: Recipe, state: Boolean) = recipeRepository.setFavoriteRecipe(recipe, state)
}