package dev.ygordoring.ifoodremake

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.squareup.picasso.Picasso
import dev.ygordoring.ifoodremake.databinding.MoreShopItemBinding
import dev.ygordoring.ifoodremake.model.MoreShop

class MoreShopView (viewGroup: ViewGroup): ATViewHolder<MoreShop, MoreShopItemBinding>(MoreShopItemBinding::inflate, viewGroup) {
    override fun bind(item: MoreShop) {
        with(binding) {
            txtShop.text = item.text
            txtStar.text = item.rate.toString()
            txtSubtitle.text = itemView.context.getString(R.string.shop_category, item.category, item.distance)
            txtPrice.text = itemView.context.getString(R.string.shop_price, item.time, item.price)
            Picasso.get().load(item.bannerUrl).into(imgShop)
        }
    }
}