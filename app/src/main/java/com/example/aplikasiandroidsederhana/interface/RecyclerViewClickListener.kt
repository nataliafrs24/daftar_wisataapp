package com.example.aplikasiandroidsederhana.`interface`

import android.view.View
import com.example.aplikasiandroidsederhana.model.PCPartsModel

interface RecyclerViewClickListener {
    fun onItemClicked(view: View, data: PCPartsModel )
}