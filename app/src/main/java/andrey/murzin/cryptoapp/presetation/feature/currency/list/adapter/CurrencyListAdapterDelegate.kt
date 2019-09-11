package andrey.murzin.cryptoapp.presetation.feature.currency.list.adapter

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.domain.entity.CoinEntity
import andrey.murzin.cryptoapp.presetation.feature.tool.ext.inflate
import andrey.murzin.cryptoapp.presetation.feature.tool.ext.toImageUrl
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_currency.view.*
import javax.inject.Inject

class CurrencyListAdapterDelegate @Inject constructor(
    private val parentContext: Context
) : AdapterDelegate<List<CoinEntity>>() {
    override fun onBindViewHolder(
        items: List<CoinEntity>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as? ViewHolder)?.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_currency))

    override fun isForViewType(items: List<CoinEntity>, position: Int): Boolean = true

    inner class ViewHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: CoinEntity) {
            with(containerView) {
                tvRank.text = item.cmcRank?.toString() ?: ""
                item.id?.toImageUrl()?.let { umgUrl ->
                    Glide.with(parentContext).load(umgUrl).into(imgIcon)
                }
            }
        }
    }
}
