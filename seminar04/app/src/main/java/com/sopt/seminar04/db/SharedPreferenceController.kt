package com.sopt.seminar04.db

import android.content.Context
import android.content.SharedPreferences

//자바에서 static. 인스턴스 생성하지 않고 내부에 있는 데이터 사용가능.
//object는 생성자를 만들 수 없음. companion object는 생성자 만들 수 있음
//싱글턴 구현할 때 사용.
object SharedPreferenceController{

    //sharedPreference에 있는 파일 명.. user_name이라는 파일이 있다고 생각할 것!
    private val USER_NAME : String = "user_name"

    private val USER_ID : String ="user_id"
    private val USER_PW : String ="user_pw"

    /****아이디*****/
    //데이터 저장. (아이디 저장)
    //sharedPreference에 저장시키는 로직
    //Context에는 Activity를 넣어주면됨 (가령, this). Context는 우리가 보는 화면에 대한 뿌리에 대한 ,.?... activity라고 생각하기
    fun setUserID(ctx : Context, input_id : String){
        //Context.Mode_PRIVATE : 이 앱에서만 열어볼 수 있음. user정보같은거.. 못보게 할 수 있음
        val preference  : SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = preference.edit()
        editor.putString(USER_ID, input_id)
        editor.commit()
        //=> 저장
    }

    //데이터 꺼내옴. (아이디 꺼내옴)
    //return 타입 String
    fun getUserID(ctx: Context) : String{

        val preferences : SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        //읽기만하기 때문에 editor 쓸 필요 없음

        return preferences.getString(USER_ID,"")
    }

    /****비밀번호*****/
    fun setUserPW(ctx : Context, input_id : String){
        //Context.Mode_PRIVATE : 이 앱에서만 열어볼 수 있음. user정보같은거.. 못보게 할 수 있음
        val preference  : SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = preference.edit()
        editor.putString(USER_PW, input_id)
        editor.commit()
        //=> 저장
    }

    //데이터 꺼내옴. (아이디 꺼내옴)
    //return 타입 String
    fun getUserPW(ctx: Context) : String{

        val preferences : SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        //읽기만하기 때문에 editor 쓸 필요 없음

        return preferences.getString(USER_PW,"")
    }

    /****제거*****/
    fun clearUserSharedPreference(ctx: Context){
        val preferences : SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor =preferences.edit()

        //clear()은 싹다지우기, remove()는 특정 데이터만(가령 아이디) 지우기
        editor.clear()
        editor.commit()
    }

}