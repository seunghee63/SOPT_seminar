package com.sopt.seminar04

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sopt.seminar04.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setOnBtnClickListener()

        if(SharedPreferenceController.getUserID(this).isNotEmpty()){
            //startActivity<MemoActivity>()
            startActivity(Intent(this,MemoActivity::class.java))
        }
    }

    //Listener들을 관리하는 함수
    private fun setOnBtnClickListener(){
        btn_login_act_sign_in.setOnClickListener{
            //두개 다 비어있지 않을 때
            if(et_login_act_id.text.toString().isNotEmpty() && et_login_act_pw.text.toString().isNotEmpty()){
                val input_id : String = et_login_act_id.text.toString()
                val input_pw : String = et_login_act_pw.text.toString()

                //데이터를 Preference데이터베이스에 넣어줌
                //괄호가 없으면 가령, SharedPreferenceController -> static으로 접근
                SharedPreferenceController.setUserID(this, input_id)
                SharedPreferenceController.setUserID(this, input_pw)

                startActivity<MemoActivity>()
                finish()
            }
        }

    }
}
