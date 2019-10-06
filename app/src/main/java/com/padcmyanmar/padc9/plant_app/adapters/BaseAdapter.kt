package com.padcmyanmar.padc9.plant_app.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padc9.plant_app.views.holders.BaseViewHolder

abstract class BaseAdapter<VH : BaseViewHolder<W>, W> : RecyclerView.Adapter<VH>() {
    private var dataList: MutableList<W> = ArrayList()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setNewData(newData: MutableList<W>)
    {
        dataList = newData
        notifyDataSetChanged()
    }

}