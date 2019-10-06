package andrey.murzin.screen_currency.screen.list.adapter

import andrey.murzin.core.model.Coin
import androidx.recyclerview.widget.DiffUtil

class CoinDiffUtil : DiffUtil.ItemCallback<Coin>() {
    override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean =
        oldItem.id == newItem.id
}
