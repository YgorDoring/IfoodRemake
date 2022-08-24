package dev.ygordoring.ifoodremake

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.squareup.picasso.Picasso
import dev.ygordoring.ifoodremake.databinding.ShopItemBinding
import dev.ygordoring.ifoodremake.model.Shop

class ShopView (viewGroup: ViewGroup): ATViewHolder<Shop, ShopItemBinding>(ShopItemBinding::inflate, viewGroup) {
    override fun bind(item: Shop) {
        binding.txtShop.text = item.text
        Picasso.get().load(item.bannerUrl).into(binding.imgShop)
    }
}