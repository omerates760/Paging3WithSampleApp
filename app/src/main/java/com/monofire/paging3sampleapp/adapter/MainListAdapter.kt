package com.monofire.paging3sampleapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.monofire.paging3sampleapp.R
import com.monofire.paging3sampleapp.data.response.Data
import kotlinx.android.synthetic.main.list_item.view.*

class MainListAdapter : PagingDataAdapter<Data, MainListAdapter.ViewHolder>(DataDifferntiator) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("items",getItem(position)?.first_name)
        holder.itemView.textViewName.text =
            "${getItem(position)?.first_name} ${getItem(position)?.last_name}"
        holder.itemView.textViewEmail.text = getItem(position)?.email

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    object DataDifferntiator : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

}