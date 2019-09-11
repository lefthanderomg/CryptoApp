package andrey.murzin.cryptoapp.presetation.feature.currency.list.adapter

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.data.model.CoinModel
import andrey.murzin.cryptoapp.domain.entity.CoinEntity
import andrey.murzin.cryptoapp.presetation.feature.tool.ext.inflate
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_currency.view.*
import javax.inject.Inject

class CurrencyListAdapterDelegate @Inject constructor(

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
            containerView.tvRank.text = item.name ?: ""
        }
    }
}
