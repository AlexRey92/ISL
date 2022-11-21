package com.e.islandia2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TerremotoAdapter: ListAdapter<Terremoto, TerremotoAdapter.ViewHolder>(DiffCallBack) {
    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val latiTerremoto: TextView =view.findViewById(R.id.textViewlatitude)
        val longiTerremoto: TextView =view.findViewById(R.id.textViewlongitude)
        val depthTerremoto: TextView =view.findViewById(R.id.textViewdepth)
        val idTerremoto: TextView =view.findViewById(R.id.textViewID)

        fun onBind(terremoto:Terremoto){
            latiTerremoto.text=terremoto.latitude.toString()
            longiTerremoto.text=terremoto.longitude.toString()
            depthTerremoto.text=terremoto.depth.toString()
            idTerremoto.text=terremoto.ID.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=getItem(position)
        holder.onBind(item)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Terremoto>() {
        override fun areItemsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem.ID == newItem.ID
        }

        override fun areContentsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem == newItem
        }
    }
}