package andrey.murzin.core_ui.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun View.setVisible(flag:Boolean) {
    if (flag) this.visibility = View.VISIBLE
    else this.visibility = View.INVISIBLE
}

fun TextView.safeSetText(text: String) {
    if (getText() != text) {
        setText(text)
    }
}
