package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide

class FirstActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private var viewPager //轮播图模块
            : ViewPager?=null
    private lateinit var mImg: IntArray
    private lateinit var mImg_id: IntArray
    private lateinit var mDec: Array<String>
    private lateinit var mImgList: ArrayList<ImageView>
    private lateinit var ll_dots_container: LinearLayout
    private var loop_dec: TextView?=null
    private var previousSelectedPosition=0
    var isRunning=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        initLoopView() //实现轮播图
        val button1:Button=findViewById(R.id.button1)
        button1.setOnClickListener{
            val intent=Intent(this,FGOWikiActivity::class.java)
            startActivity(intent)
        }
        val button2:Button=findViewById(R.id.button2)
        button2.setOnClickListener{
            val intent=Intent(this,PhotoActivity::class.java)
            startActivity(intent)
        }
        val button3:Button=findViewById(R.id.button3)
        button3.setOnClickListener{
            val intent=Intent(this,SettingActivity::class.java)
            startActivity(intent)
        }
        val button4:Button=findViewById(R.id.button4)
        button4.setOnClickListener{
            val intent=Intent(this,TestActivity::class.java)
            startActivity(intent)
        }

        val preview_gif:ImageView=findViewById(R.id.preview)
        Glide.with(this).load(R.drawable.preview).into(preview_gif)
//        Glide.with(this).load("https://fgo.wiki/images/9/9e/Servant380.jpg").into(preview_gif)
    }
    private fun initLoopView() {
        viewPager=findViewById(R.id.loopviewpager) as ViewPager
        ll_dots_container=findViewById(R.id.ll_dots_loop) as LinearLayout
        loop_dec=findViewById(R.id.loop_dec) as TextView

        // 图片资源id数组
        mImg=intArrayOf(
            R.drawable.preview1,
            R.drawable.preview2,
            R.drawable.preview3,
            R.drawable.preview4,
            R.drawable.preview5,
        )

        // 文本描述
        mDec=arrayOf(
            "Test1",
            "Test2",
            "Test3",
            "Test4",
            "Test5"
        )
        mImg_id=intArrayOf(
            R.id.pager_img1,
            R.id.pager_img2,
            R.id.pager_img3,
            R.id.pager_img4,
            R.id.pager_img5
        )

        // 初始化要展示的5个ImageView
        mImgList=java.util.ArrayList()
        var imageView: ImageView
        var dotView: View
        var layoutParams: LinearLayout.LayoutParams
        for (i in mImg.indices) {
            //初始化要显示的图片对象
            imageView=ImageView(this)
            imageView.setBackgroundResource(mImg[i])
            imageView.id=mImg_id[i]
            imageView.setOnClickListener(pagerOnClickListener(applicationContext))
            mImgList.add(imageView)
            //加引导点
            dotView=View(this)
            dotView.setBackgroundResource(R.drawable.dot)
            layoutParams=LinearLayout.LayoutParams(10, 10)
            if (i != 0) {
                layoutParams.leftMargin=10
            }
            //设置默认所有都不可用
            dotView.isEnabled=false
            ll_dots_container.addView(dotView, layoutParams)
        }
        ll_dots_container.getChildAt(0).isEnabled=true
        loop_dec!!.setText(mDec[0])
        previousSelectedPosition=0
        //设置适配器
        viewPager!!.adapter=LoopViewAdapter(mImgList)
        // 把ViewPager设置为默认选中Integer.MAX_VALUE / t2，从十几亿次开始轮播图片，达到无限循环目的;
        val m=Int.MAX_VALUE / 2 % mImgList.size
        val currentPosition=Int.MAX_VALUE / 2 - m
        viewPager!!.currentItem=currentPosition
        viewPager!!.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
            override fun onPageSelected(i: Int) {
                val newPosition=i % mImgList.size
                loop_dec!!.setText(mDec[newPosition])
                ll_dots_container.getChildAt(previousSelectedPosition).isEnabled=false
                ll_dots_container.getChildAt(newPosition).isEnabled=true
                previousSelectedPosition=newPosition
            }

            override fun onPageScrollStateChanged(i: Int) {}
        })

        // 开启轮询
        object : Thread() {
            override fun run() {
                isRunning=true
                while (isRunning) {
                    try {
                        sleep(5000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    //下一条
                    runOnUiThread { viewPager!!.currentItem=viewPager!!.currentItem + 1 }
                }
            }
        }.start()
    }
}