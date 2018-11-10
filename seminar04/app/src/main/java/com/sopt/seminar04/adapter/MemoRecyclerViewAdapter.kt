package com.sopt.seminar04.adapter

import android.content.Context
import android.support.constraint.R.id.parent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.sopt.seminar04.R
import com.sopt.seminar04.data.MemoData
import kotlin.IndexOutOfBoundsException

//이너클래스에 홀더 만든것 꺽쇠안에 넣어줌
class MemoRecyclerViewAdapter(val ctx: Context, var dataList  :ArrayList<MemoData>) : RecyclerView.Adapter<MemoRecyclerViewAdapter.Holder>(){

    lateinit var MemoRecyclerViewAdapter : MemoRecyclerViewAdapter

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_memo,parent, false)
        return Holder(view)
    }

    fun addNewItem(memoData: MemoData){
        val positon : Int = dataList.size
        dataList.add(memoData)
        notifyItemInserted(positon)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].title
        holder.content.text = dataList[position].content

        holder.whole_btn.setOnClickListener {
            try{
                dataList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, dataList.size)
            }catch (e: IndexOutOfBoundsException){
                Log.e("item제거 중 오류 발생", e.toString())
            }
        }

    }


    //1. 홀더만들기
    //상속받아야함. 반환값아님
    //viewHolder인자에 부모객채에 넘겨줘야 하는 값 넣기
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_rv_item_memo_title) as TextView
        val content : TextView = itemView.findViewById(R.id.tv_rv_item_memo_content) as TextView

        val whole_btn : RelativeLayout = itemView.findViewById(R.id.btn_rv_item_memo_whole_box) as RelativeLayout
    }

}