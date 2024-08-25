package com.avrians.mycooking.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avrians.core.domain.usecase.RecipeUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val recipeUseCase: RecipeUseCase
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(
                recipeUseCase
            ) as T
            else -> throw IllegalArgumentException("Unknown Viewmodel class ${modelClass.name}")
        }
}