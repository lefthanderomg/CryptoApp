package andrey.murzin.core_ui.ext

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(context: Context = this.context, url: String) {
    Glide.with(context).load(url).into(this)
}