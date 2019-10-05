package andrey.murzin.screen_currency.screen.list.adapter

import andrey.murzin.core.model.Coin
import andrey.murzin.core_ui.ext.inflate
import andrey.murzin.core_ui.ext.load
import andrey.murzin.core_ui.ext.toImageUrl
import andrey.murzin.core_ui.ext.toPrice
import andrey.murzin.screen_currency.R
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_currency.view.*
import javax.inject.Inject

class CurrencyListAdapterDelegate @Inject constructor(
    private val parentContext: Context,
    private val clickListener: (Coin) -> Unit
) : AdapterDelegate<List<Coin>>() {
    override fun onBindViewHolder(
        items: List<Coin>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as? ViewHolder)?.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_currency))

    override fun isForViewType(items: List<Coin>, position: Int): Boolean = true

    inner class ViewHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private lateinit var data : Coin

        init {
            containerView.setOnClickListener {
                clickListener.invoke(data)
            }
        }

        fun bind(item: Coin) {
            data = item
            with(containerView) {
                tvRank.text = item.cmcRank?.toString() ?: ""
                tvCoinName.text = item.name ?: ""
                tvCoinSymbol.text = item.symbol ?: ""
                tvPrice.text = item.quote?.usd?.price?.toPrice() ?: ""
                item.id?.toImageUrl()?.let { umgUrl ->
                    imgIcon.load(parentContext, umgUrl)
                }
            }
        }
    }
}
