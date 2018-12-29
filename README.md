## 23rd SOPT Android파트 세미나

[TOC]





##1주차
###1. Layout
1. relative layout

2. 


##2주차
###1. 스플래쉬

###2. Intent 창전환
1. Splash Act -> ***Main Act***
: startActivity() - ***getExtra()***

2. ***Main Act*** -> Sub Act -> ***Main Act*** 
: ***startActivityForResult()*** - getExtra()/setResult() - ***onActivityResult()***


###3. 프래그먼트
1. flagment class 에 layout 붙이기

2. activity 에 fragment 붙이기
*activity 내 fragment는 fragmentManager에 의해 관리 됨*
	- activity layout에 fragment 붙이기
	- activity.kr 에 fragment 붙이기

##3주차
###1. FragmentStatePagerAdapter , selector
* slide되는 view. slide하여 tap전환!
* Fragment가 슬라이드 되는 view를 관리 해 주는 것. 범위 지정 가능. adapter가 유연하게 fragment관리
* Fragment 의 상태를 보존시켜 불필요한 서버통신을 줄임. 
* FragmentPagerAdapter : 고정개수의 Fragment관리. 한번 생성되면 FragmentMaganer에 박제되어 activity가 종료되지 않는 한 제거되지 않음. 메모리 누수 발생.

1. fragment.kr과 layout.xml파일 연결
: 여러개의 창 tab전환 해야하기때문에.. fragment 여러개 만들기 

2. FragmentStatPagerAdapter만들기

3. BottomNaviActivity/ view만들기
: view구성은, ViewPager + TabLayout

4.  selector
: selector_bottom_navi_main_icon.xml * n개(tab의 개수만큼)
		<selecor> 
		<item android:state_selected=“true” android:drawable=“@drawable/black.jpg”/>
		<item android:state_selected=“false” android:drawable=“@drawable/green.jpg”/>
		</selector>
5. tablayout 만들기 : selector를 이용한 탭 전환

6. BottomNaviActivity에 tablayout달기


###2. RecyclerView
* 반복적인 view를 가진 item을 보여주는, 스크롤 되는 목록(List)를 구현하기 위해 사용

1. RecyclerView 라이브러리 추가

2. Data Class
: KakaoTalkRoomData.kr

3.  item의 레이아웃 구성할 xml

4. View Holder Class
: KakaoTalkRoomRecyclerViewAdapter 클래스의 내부클래스로 Holder클래스 생성
: inner Holder

5. RecyclerViewAdapterClass : Adapter를 통해 view와 data 연결
: onBindViewHolder(Holder, position)

6. Adapter연결 
: fragment(or Actiivity)에 RecyclerView위젯달기

		latent var adapter
		setRecyclerView
		layoutmanager

8. 리스너 달기
 itemview의 root에 ViewGroup에 id설정
 Holder에 RelativeLayout의 id잡아줌 + onBindViewHolder

##4주차
###1. 내부데이터 베이스 - SharedPreference
1. db> SharedPreferenceController.kr 만들기

 1) object SharedPreferenceController{}
 object : static 객체 만들 때 사용

 2) UserID/UserPW를 저장하는 코드 get/set

 `set`
	1. getSharedPreference 를 통해 인스턴스 가져옴
	2. editor 열기
	3. 값 넣기
	4. commit

 `get`
	1. getSharedPreference를 통해 잊스턴스 가져옴
	2. 키 꺼내옴


2. activity

###2. RecyclerView, Click Effect(Ripple)

##5주차
>디자인합동세미나

###1. Shape, Font

###2. Lottie

###3. Animation

##6주차 
###1. 회원가입 통신


###2. 로그인 통신


###3. 게시물 쓰기 통신
##7주차
>서버합동세미나


##8주차 

