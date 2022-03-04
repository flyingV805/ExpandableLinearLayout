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
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initExpandable(attrs)
    }

    private var changesApplied = false
    private var expandedChildPosition = -1

    private fun initExpandable(attrs: AttributeSet?){
        Log.d("initExpandable", "Children count: $childCount")
        expandedChildPosition = attrs?.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "expandedPosition", -1) ?: -1
    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if(!changesApplied){
            modifyChildren()
            changesApplied = true
        }
    }

    private fun modifyChildren(){
        when(orientation){
            HORIZONTAL -> {modifyChildrenHorizontal()}
            VERTICAL -> {modifyChildrenVertical()}
        }
    }

    private fun modifyChildrenHorizontal(){
        Log.d("modifyChildren", "Parent width: $width")

        var notExpandedChildrenWidth = 0
        for(i in 0 until childCount){
            if(i != expandedChildPosition){
                Log.d("child", "$i child width: ${getChildAt(i).width}")
                notExpandedChildrenWidth += getChildAt(i).width
            }
        }

        Log.d("modifyChildren", "notExpandedChildrenWidth: $notExpandedChildrenWidth")
        val params = getChildAt(expandedChildPosition).layoutParams
        params.width = width - notExpandedChildrenWidth
        getChildAt(expandedChildPosition).layoutParams = params
    }

    private fun modifyChildrenVertical(){
        Log.d("expandable child", "position: $expandedChildPosition")
        Log.d("onLayout", "Parent width: $width")
        Log.d("onLayout", "Parent height: $height")

        var notExpandedChildrenHeight = 0

        for(i in 0 until childCount){
            if(i != expandedChildPosition){
                Log.d("child", "Parent width: $height")
                notExpandedChildrenHeight += getChildAt(i).height
            }
        }

        val params = getChildAt(expandedChildPosition).layoutParams
        params.height = height - notExpandedChildrenHeight
        getChildAt(expandedChildPosition).layoutParams = params
    }

}