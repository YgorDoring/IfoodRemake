package dev.ygordoring.ifoodremake

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.squareup.picasso.Picasso
import dev.ygordoring.ifoodremake.databinding.BannerItemBinding
import dev.ygordoring.ifoodremake.model.Banner

class BannerView (viewGroup: ViewGroup): ATViewHolder<Banner, BannerItemBinding>(BannerItemBinding::inflate, viewGroup) {
    override fun bind(item: Banner) {
        Picasso.get().load(item.bannerUrl).into(binding.imgBanner)
    }
}