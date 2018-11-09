package com.sopt.seminar02_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.sopt.seminar02_1.Fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var data3: Int = 0
    var data1: String? = null
    var data2: String? = null

    //어디서 보낸 data인지 알기 위해
    val REQUEST_CODE_USER_ACTIVITY = 1004

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(HomeFragment())

        //버튼 누를경우 서브 액티비티로
        btn_main_act_goto_sub.setOnClickListener {
            //StartActivityForResult() : 서브 창에서 받아 올 값이 있을 경우 사용.


            val intent: Intent = Intent(this, UserActivity::class.java)
            intent.putExtra("data1", "안녕하세요")
            startActivityForResult(intent, REQUEST_CODE_USER_ACTIVITY)//코드를 붙여줘서 보냄 -> Useractivity

        }

    }

    //onActivityResult() : StartActivityForResult()와 세트. user에서 보낸 것 받아옴.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode ==1004){
            if(resultCode ==100) {
                toast("결과코드 100!")
            }else if (resultCode ==200)
                toast("200")
        }
    }

    private fun addFragment(fragment : Fragment){
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_main_act_fragment_block, fragment)
        transaction.commit()
    }
}