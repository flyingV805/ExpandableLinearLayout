package kz.flyingv.expandablelinearlayout

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.children

class ExpandableLinearLayout: LinearLayoutCompat {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initExpandable(attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        initExpandable(attrs)
    }

    private var expandedChildPosition = -1

    private fun initExpandable(attrs: AttributeSet?){
        Log.d("initExpandable", "Children count: $childCount")
        expandedChildPosition = attrs?.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "expandedPosition", -1) ?: -1
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)

        Log.d("expandable child", "position: $expandedChildPosition")

        Log.d("onLayout", "Parent width: $width")
        Log.d("onLayout", "Parent height: $height")

        val params = getChildAt(expandedChildPosition).layoutParams
        params.width = 500
        getChildAt(expandedChildPosition).layoutParams = params

        children.iterator().forEach { childView ->
            Log.d("onLayout", "Child width: ${childView.width}")
        }

        Log.d("onLayout", "Children count: $childCount")

    }

}