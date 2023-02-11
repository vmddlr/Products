package com.example.products.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.products.R
import com.example.products.data.model.Records
import com.example.products.databinding.ItemProductLayoutBinding

class MainActivityAdapter(
    private val listItem: List<Records>
): RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_layout, parent, false)

        return this.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = listItem[position]
        with(holder){
            Glide.with(context)
                .load(entity.lgImage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.ivProduct)

            binding.tvName.text = entity.productDisplayName
            binding.tvPrice.text = entity.listPrice.toString()
            binding.tvPriceWithDiscount.text = entity.promoPrice.toString()

            binding.cvOne.visibility = View.GONE
            binding.cvTwo.visibility = View.GONE
            binding.cvThree.visibility = View.GONE

            entity.variantsColor.forEachIndexed(){ index, colorH ->
                val color = Color.parseColor(colorH.colorHex);
                when(index){
                    1 ->{
                        binding.cvOne.visibility = View.VISIBLE
                        binding.cvOne.background.setTint(color)
                    }
                    2 -> {
                        binding.cvTwo.visibility = View.VISIBLE
                        binding.cvTwo.background.setTint(color)
                    }
                    3 -> {
                        binding.cvThree.visibility = View.VISIBLE
                        binding.cvThree.background.setTint(color)
                    }
                }
            }
        }
    }

    override fun getItemCount() = listItem.size


    inner class  ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemProductLayoutBinding.bind(view)
    }
}