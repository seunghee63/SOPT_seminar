package com.sopt.seminar05

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import org.jetbrains.anko.toast

class SubActivity : AppCompatActivity() {

    val bottomBarAnnotation: Animation by lazy {
        AnimationUtils.loadAnimation(this,R.anim.example_animation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

       //메모리 할당
        bottomBarAnnotation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {
             }

            override fun onAnimationEnd(p0: Animation?) {
                toast("끝")
             }

            override fun onAnimationStart(p0: Animation?) {
                toast("시작")
             }

        })

        //btn_sub_act_show_bottom_bar.setOnClickListener({
            //rl_sub_act_bottom_bar.visibility =View.VISIBLE
            //rl_sub_act_bottom_bar.startAnimation(bottomBarAnnotation)
        //})
    }


}
