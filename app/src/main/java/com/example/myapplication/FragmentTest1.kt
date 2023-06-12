package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.math.log


class FragmentTest1  : Fragment() {
    val photos =mutableListOf(
        Photo("英灵1", "https://fgo.wiki/images/c/c6/Ordeal_Call_jp.png"),
        Photo("英灵1", "https://fgo.wiki/images/c/c5/%E7%91%9F%E5%9D%A6%E7%89%B9%E5%88%9D%E5%A7%8B.png"),
        Photo("英灵1", "https://fgo.wiki/images/c/c6/Ordeal_Call_jp.png"),
        Photo("英灵1", "https://fgo.wiki/images/c/c5/%E7%91%9F%E5%9D%A6%E7%89%B9%E5%88%9D%E5%A7%8B.png"),
        )
    val photosList=ArrayList<Photo>()
    @SuppressLint("MissingInflatedId", "InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_test1,container,false)
        val view: View=inflater.inflate(R.layout.fragment_test1, null)
        val recyclerView:RecyclerView=view.findViewById(R.id.recycler)
        initphotos()
        val layoutManager =GridLayoutManager(context,2) //设置显示为2排
        recyclerView.layoutManager=layoutManager //指定滑动控件布局
        val adapter=ImageAdapter(context,photosList)//加载适配器
        recyclerView.adapter=adapter
//        val imageapps:ImageView=view.findViewById(R.id.test_url)
////        imageapps.setImageResource(com.example.myapplication.R.drawable.all_2)
//        val layoutManager =GridLayoutManager(context,2)
//        Glide.with(context).load("https://fgo.wiki/images/c/c6/Ordeal_Call_jp.png").into(imageapps)
        return view
    }

    private fun initphotos() {
        photosList.clear()
        photosList.addAll(photos)
        }
    }

    class ImageAdapter(val context: Context?, val photosList:List<Photo>):
        RecyclerView.Adapter<ImageAdapter.ViewHolder>(){
        inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
            val imageView:ImageView=view.findViewById(R.id.imageView)
            val imagetext:TextView=view.findViewById(R.id.imagetext)
        }

        @SuppressLint("RestrictedApi")
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view=LayoutInflater.from(context).inflate(R.layout.image_item,parent,false)
            val viewHolder=ViewHolder(view)
//            viewHolder.itemView.setOnClickListener {
//                val position=viewHolder.adapterPosition
//                val name =photosList[position]
//                Log.d("FGOWikiActivity", "数据是 $position")
////               Toast.makeText(parent.context,name.name,Toast.LENGTH_SHORT).show()
//            }
//           viewHolder.imageView.setOnClickListener {
//               val position=viewHolder.bindingAdapterPosition
//               val name =photosList[position]
//               Log.d("FGOWikiActivity", "数据是 $position")
////               Toast.makeText(parent.context,name.name,Toast.LENGTH_SHORT).show()
//               }

            return ViewHolder(view)
        }

//        private fun onClick(name: Photo) {
////            val intent=Intent(context, FGOWikiActivity::class.java)
////            context!!.startActivity(intent)
//
//        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val  photo=photosList[position]
            holder.imagetext.text=photo.name
            Glide.with(context).load(photo.photourl).into(holder.imageView)//对子项数据进行赋值
            val viewHolder=holder
            viewHolder.imageView.setOnClickListener {
               val position=viewHolder.bindingAdapterPosition
               val name =photosList[position]
               Log.d("FGOWikiActivity", "数据是 $position")
                Toast.makeText(holder.itemView.context,name.name,Toast.LENGTH_SHORT).show()
//               Toast.makeText(parent.context,name.name,Toast.LENGTH_SHORT).show()
               }

        }

        override fun getItemCount() = photosList.size
    }
    class Photo(val name:String,val photourl:String)

