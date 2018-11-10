package com.sopt.seminar04

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.sopt.seminar04.adapter.MemoRecyclerViewAdapter
import com.sopt.seminar04.data.MemoData
import com.sopt.seminar04.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_memo.*
import org.jetbrains.anko.startActivity

class MemoActivity : AppCompatActivity() {

    //instant변수
    lateinit var memoRecyclerViewAdapter : MemoRecyclerViewAdapter

    //쓰기 전까지 메모리 할당이 안되다가 쓰는 순간 메모리 할당 됨
    val dataList : ArrayList<MemoData> by lazy{
        ArrayList<MemoData>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)

        srl_memo_act_reflesh.setOnRefreshListener {
            //서버 재통신 로직 넣기
            srl_memo_act_reflesh.isRefreshing= false
        }
        setOnBtnClickListener()
        setRecyclerView()
    }

    private fun setOnBtnClickListener(){
        btn_memo_act_logout.setOnClickListener{
            SharedPreferenceController.clearUserSharedPreference(this)
            startActivity<LoginActivity>()
            finish()
        }

        btn_memo_act_add_memo.setOnClickListener{
            if(et_memo_act_title.text.toString().isNotEmpty() && et_memo_act_content.text.toString().isNotEmpty()){

                val position : Int = memoRecyclerViewAdapter.dataList.size

                val title : String = et_memo_act_title.text.toString()
                val content : String = et_memo_act_content.text.toString()

                val memoData : MemoData = MemoData(title, content)

                memoRecyclerViewAdapter.dataList.add(memoData)
                memoRecyclerViewAdapter.notifyItemInserted(position)


            }

        }
    }

    //private fun addItem()

    private fun setRecyclerView(){


        //초기화. by laze를 썼기 때문에 이 순간부터 메모리 할당
        //recyclerview 달아줌
        memoRecyclerViewAdapter = MemoRecyclerViewAdapter(this,dataList)
        rv_memo_act_memo_list.adapter = memoRecyclerViewAdapter
        rv_memo_act_memo_list.layoutManager = LinearLayoutManager(this)


    }

}
