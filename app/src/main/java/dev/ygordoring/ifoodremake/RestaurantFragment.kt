package dev.ygordoring.ifoodremake

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import dev.ygordoring.ifoodremake.databinding.*
import dev.ygordoring.ifoodremake.model.*

class RestaurantFragment : Fragment(R.layout.fragment_restaurant) {

    private var binding: FragmentRestaurantBinding? = null

    private val categoryAdapter: ATAdapter<CategoryView, Category, CategoryItemBinding> = ATAdapter({ CategoryView(it) })
    private val bannerAdapter: ATAdapter<BannerView, Banner, BannerItemBinding> = ATAdapter({ BannerView(it) })
    private val shopAdapter: ATAdapter<ShopView, Shop, ShopItemBinding> = ATAdapter({ ShopView(it) })
    private val moreShopAdapter: ATAdapter<MoreShopView, MoreShop, MoreShopItemBinding> = ATAdapter({ MoreShopView(it) })

    private var position: Int? = RecyclerView.NO_POSITION
    private val snapHelper = LinearSnapHelper()

    private val filters = mutableListOf(
        FilterItem(1, "Ordenar", closeIcon = R.drawable.ic_arrow_down_black),
        FilterItem(2, "Pra retirar", icon = R.drawable.ic_directions_walk),
        FilterItem(3, "Entrega grátis"),
        FilterItem(4, "Vale-refeição", closeIcon = R.drawable.ic_arrow_down_black),
        FilterItem(5, "Distância", closeIcon = R.drawable.ic_arrow_down_black),
        FilterItem(6, "Entrega Parceria"),
        FilterItem(7, "Super Restaurante"),
        FilterItem(8, "Filtros", closeIcon = R.drawable.ic_filter_list)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.items = arrayListOf(
            Category(1, "https://www.ifood.com.br/static/images/categories/restaurant.png", "Restaurante", 0xFFE91D2D),
            Category(2, "https://www.ifood.com.br/static/images/categories/drinks.png", "Bebidas", 0xFFF6D553),
            Category(3, "https://static-images.ifood.com.br/image/upload/f_auto/webapp/landingV2/express.png", "Express", 0xFFFF0000),
            Category(4, "https://www.ifood.com.br/static/images/categories/market.png", "Mercado", 0xFFB6D048),
            Category(5, "https://parceiros.ifood.com.br/static/media/salad.9db040c0.png", "Saudavel", 0xFFE91D2D),
            Category(6, "https://www.ifood.com.br/static/images/categories/restaurant.png", "Salgados", 0xFF8C60C5),
        )

        bannerAdapter.items = arrayListOf(
            Banner(1, "https://static-images.ifood.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-3.png"),
            Banner(2, "https://static-images.ifood.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-2.png"),
            Banner(3, "https://static-images.ifood.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-1.png"),
        )

        shopAdapter.items = arrayListOf(
            Shop(1, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/067247ff-fab9-4f9c-967a-c1fceae8f8d9_MCDON_PENH04.png", "Mc Donald's"),
            Shop(2, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/24633464-a029-4977-befc-4b04b7ae391b/202208221746_pKPK_i.jpg", "Kibon Sorveteria"),
            Shop(3, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/201912131127_b7820767-ffda-4870-8797-6e2c4fc90746.png", "O Burguês - Burger Vitória"),
            Shop(4, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/644725b1-fc69-4bf2-906e-1c3525337903/202006211843_NPDP_i.png", "By Rock Steakhouse"),
            Shop(5, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/5d9ff9cc-ea4e-4f2d-9c11-f1402c3db251/202201071052_BHAX_i.jpg", "China in Box"),
            Shop(6, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/96128b11-2b45-40d1-a2e0-2c3597600746_PIZZA_TORI122.png", "Pizza Hut"),
            Shop(7, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/d818d7e9-d598-4673-aa70-9c3fd3a7d337/202008102342_DuAT_i.png", "Outback"),
        )

        moreShopAdapter.items = arrayListOf(
            MoreShop(1, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 26.00),
            MoreShop(2, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/bb3ad636-7c36-4ae2-a1db-14cd35695350/202001271029_rK15_i.png", "Fábrica de Esfiha", 4.3, "Esfiha", 12.2, "60-70", 9.00),
            MoreShop(3, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/2fd863ac-4cc2-476c-8896-99aedfdaeb5f/201911150948_Z9QG_i.jpg", "Pecorino", 4.9, "Grill", 17.2, "60-70", 10.00),
            MoreShop(4, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/86b58685-a7dc-4596-be26-2c4037b4d591/202006051304_JuRt_i.jpg", "Barbacoa Grill", 4.9, "Grill", 12.2, "70-90", 40.00),
            MoreShop(5, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/e2f3424a-06fb-46dd-89c3-f7b039e2b1f0_BOLOD_PPIN02.jpeg", "Bolo de Madre", 4.7, "Bolo", 11.0, "80-90", 30.00),
            MoreShop(6, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201901021647_8066dc64-9383-46d1-aa2d-56b9492e27ed.png", "Uau Esfiha", 4.4, "Esfiha", 11.2, "60-70", 8.00),
            MoreShop(7, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201705131248_0ca51a98-ee95-48ac-b193-48066c8f20cc.png", "Bar do Juarez", 4.9, "Bar", 17.2, "40-50", 13.00),
        )



        binding = FragmentRestaurantBinding.bind(view)

        binding?.let {
            it.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            it.rvShops.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvShops.adapter = shopAdapter

            it.rvMoreShops.layoutManager = LinearLayoutManager(requireContext())
            it.rvMoreShops.adapter = moreShopAdapter

            it.rvBanners.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvBanners.adapter = bannerAdapter
            it.rvBanners.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE)
                        notifyPositionChanged(recyclerView)
                }
            })

            addDots(it.dots, bannerAdapter.items.size, 0)

            filters.forEach { filter ->
                it.chipGroupFilter.addView(filter.toChip(requireContext()))
            }
        }
    }

    private fun addDots(container: LinearLayout, size: Int, position: Int) {
        container.removeAllViews()

        Array(size) {
            val textView = TextView(context).apply {
                text = getString(R.string.dotted)
                textSize = 20f
                setTextColor(
                    if (position == it) ContextCompat.getColor(context, android.R.color.black)
                    else ContextCompat.getColor(context, android.R.color.darker_gray)
                )
            }
            container.addView(textView)
        }
    }

    private fun notifyPositionChanged(recyclerView: RecyclerView) {
        val layoutManager: RecyclerView.LayoutManager? = recyclerView.layoutManager
        val view: View? = snapHelper.findSnapView(layoutManager)
        val position: Int? = if (view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)

        val positionChanged: Boolean = this.position != position
        if (positionChanged) {
            addDots(binding!!.dots, bannerAdapter.items.size, position ?: 0)
        }
        this.position = position
    }
}