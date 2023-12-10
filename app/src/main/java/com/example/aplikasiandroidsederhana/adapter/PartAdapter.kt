package com.example.aplikasiandroidsederhana.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiandroidsederhana.R
import com.example.aplikasiandroidsederhana.`interface`.RecyclerViewClickListener
import com.example.aplikasiandroidsederhana.model.PCPartsModel

class PartAdapter(private val listModelPCParts: ArrayList<PCPartsModel>) : RecyclerView.Adapter<PartAdapter.ViewHolder>(){

    var listener: RecyclerViewClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivphoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvtitle: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvdescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val cvitem: CardView = itemView.findViewById(R.id.cv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_pcparts, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listModelPCParts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvtitle.text = listModelPCParts[position].name
        holder.ivphoto.setImageResource(listModelPCParts[position].photo)
        holder.tvdescription.text = listModelPCParts[position].description
        holder.cvitem.setOnClickListener {
            listener?.onItemClicked(it, listModelPCParts[position])
        }
    }
}