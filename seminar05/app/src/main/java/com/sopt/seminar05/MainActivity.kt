package com.sopt.seminar05

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val confetti_animation : LottieAnimationView =findViewById(R.id.lottie_main_act_star)

        lottie_main_act_star.setOnClickListener{
            confetti_animation.playAnimation()
        }

        confetti_animation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationEnd(p0: Animator?) {
                //toast("에니메이션 끝")
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationRepeat(p0: Animator?) {

            }
        })

    }
}
