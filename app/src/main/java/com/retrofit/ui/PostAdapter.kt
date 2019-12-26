package com.retrofit.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.retrofit.R
import com.retrofit.data.model.Posts
import com.retrofit.databinding.ListDashboardBinding

open class PostAdapter(
    private val context: Context,
    private val list: List<Posts>
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ListDashboardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)

        val binding = DataBindingUtil.inflate<ListDashboardBinding>(inflater, R.layout.list_dashboard, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.model = item
        holder.binding.executePendingBindings()

    }

    override fun getItemCount(): Int {
        return list.size
    }
}