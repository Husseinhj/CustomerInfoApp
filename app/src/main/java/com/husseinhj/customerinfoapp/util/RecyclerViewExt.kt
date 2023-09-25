package com.husseinhj.customerinfoapp.util

import com.husseinhj.customerinfoapp.R
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration

/**
 * It apply divider configuration to recycler view that should have only LinearLayout for layoutManager.
 */
fun RecyclerView.applyDividerConfiguration() {
    val layoutManager  = this.layoutManager as? LinearLayoutManager ?: return

    val mDividerItemDecoration = MaterialDividerItemDecoration(this.context, layoutManager.orientation)
    mDividerItemDecoration.dividerInsetStart = this.context.resources.getDimension(R.dimen.extra_space).toInt()
    mDividerItemDecoration.dividerColor = ResourcesCompat.getColor(
        this.context.resources,
        R.color.Border_Separator,
        this.context.theme
    )
    mDividerItemDecoration.dividerThickness = 1

    this.addItemDecoration(mDividerItemDecoration)
}