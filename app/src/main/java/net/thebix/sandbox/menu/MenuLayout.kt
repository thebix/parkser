package net.thebix.sandbox.menu

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import net.thebix.parkser.R

class MenuLayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        ViewGroup.inflate(context, R.layout.sandbox_menu_layout, this)
        if (isInEditMode) {
            id = R.id.sandbox_menu_root
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}
