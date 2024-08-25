package com.avrians.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avrians.core.R
import com.avrians.core.databinding.ItemListRecipeBinding
import com.avrians.core.domain.model.Recipe
import com.bumptech.glide.Glide

class RecipeAdapter(
    private var listRecipe: List<Recipe>
) : RecyclerView.Adapter<RecipeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemListRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val recipe = listRecipe[position]
        Glide.with(holder.itemView.context)
            .load(recipe.image)
            .into(holder.binding.ivRecipe)
        holder.apply {
            binding.tvTitle.text = recipe.title
            binding.tvDescription.text = recipe.summary
            binding.ivHealth.setImageResource(
                when (recipe.veryHealthy.toString()) {
                    "true" -> R.drawable.ic_health
                    else -> R.drawable.ic_no_health
                }
            )
            binding.ivVegetarian.setImageResource(
                when (recipe.vegetarian.toString()) {
                    "true" -> R.drawable.ic_vegetarian
                    else -> R.drawable.ic_non_vegetarian
                }
            )
            binding.ivCheap.setImageResource(
                when (recipe.cheap.toString()) {
                    "true" -> R.drawable.ic_cheap
                    else -> R.drawable.ic_expensive
                }
            )
            binding.tvTimeMinute.text = recipe.readyInMinutes.toString()
            binding.cardView.setOnClickListener {
                onItemClickCallback.onItemClicked(listRecipe[holder.adapterPosition])
            }
        }
    }

    class ListViewHolder(val binding: ItemListRecipeBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: Recipe)
    }
}