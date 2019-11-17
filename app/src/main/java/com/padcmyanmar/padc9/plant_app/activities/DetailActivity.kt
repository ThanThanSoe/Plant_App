package com.padcmyanmar.padc9.plant_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padcmyanmar.padc9.plant_app.R
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO
import com.padcmyanmar.padc9.plant_app.mvp.presenters.DetailPresenter
import com.padcmyanmar.padc9.plant_app.mvp.views.DetailView
import kotlinx.android.synthetic.main.plant_detail.*

class DetailActivity : BaseActivity(), DetailView {
    override fun displayPlantDetail(plantVO: PlantVO) {
        bindData(plantVO)
    }

    private lateinit var mPresenter: DetailPresenter

    companion object {
        const val EXTRA_TO_EXTRA = "Extra_to_Extra"
        fun newIntent(context: Context, moviesIdExtra: Int): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_TO_EXTRA, moviesIdExtra)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.plant_detail)

        mPresenter = ViewModelProviders.of(this).get(DetailPresenter::class.java)
        mPresenter.init(this)
        val plantId = intent.getIntExtra(EXTRA_TO_EXTRA, 0)
        mPresenter.onUIReady(plantId,this)


    }



    fun bindData(plantVO: PlantVO) {
        Glide.with(this)
            .load(plantVO.plantPhoto)
            .into(detail_imageView)
        detail_title.text = plantVO.plantName
        detail.text = plantVO.description
        /* if (plantVO.uploadUser.userPhoto!=null)
             Glide.with(this)
                 .load(plantVO.uploadUser.userPhoto)
                 .into(detail_image_profile)*/
        user_name.text = "by "+plantVO.uploadUser.name
    }
}