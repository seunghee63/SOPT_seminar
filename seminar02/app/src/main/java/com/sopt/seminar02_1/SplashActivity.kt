package com.sopt.seminar02_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Q ?
        Handler().apply {
            postDelayed({

                val intent : Intent = Intent(this@SplashActivity, MainActivity::class.java)
                intent.putExtra("data1","헬로우") //key, value
                intent.putExtra("data2", "월드")
                intent.putExtra("data2", 1000)

                //startActivity<MainActivity>("data1" to "헬로우", "data2" to "월드", "data3" to 1000)
                startActivity(intent)
                finish()

            }, 2000)
        }
    }
}
