package com.padcmyanmar.padc9.plant_app.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO
import com.padcmyanmar.padc9.plant_app.delegate.PlantDelegate
import kotlinx.android.synthetic.main.list_view.view.*
import kotlinx.android.synthetic.main.plant_list.view.*

class PlantListViewHolder(itemView: View, private val plantDelegate: PlantDelegate) :
    BaseViewHolder<PlantVO>(itemView) {

    init {
        itemView.setOnClickListener(View.OnClickListener {
            data?.id?.let { it1 ->
                plantDelegate.onTapPlantItem(it1, itemView.imageView)
            }
        })
    }

    override fun bindData(data: PlantVO) {
        itemView.image_profile
        itemView.title.text = data.plantName
        itemView.user_name

        Glide.with(itemView)
            .load(data.plantPhoto)
            .into(itemView.imageView)
        itemView.user_name.text = "by "+data.uploadUser.name
        /*if (data.uploadUser.userPhoto!=null)
            Glide.with(itemView)
                .load(data.uploadUser.userPhoto)
                .into(itemView.image_profile)*/
    }
}