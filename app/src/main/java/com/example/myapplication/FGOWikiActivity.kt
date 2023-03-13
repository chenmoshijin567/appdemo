package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class FGOWikiActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Range")
    private var ServantList = ArrayList<FGOServantList>()

    @SuppressLint("Range", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fgowiki_layout)
        val adapter = FGOServantListAdapter(this, R.layout.fgoservantlist_layout, ServantList)
        val listView = findViewById<ListView>(R.id.listView_fgo)
        var value = FindServantList()
        Log.d("FGOWikiActivity", "此表的长度是 $value")
        listView.adapter = adapter//加载适配器
        listView.setOnItemClickListener(){
            parent,view,position,id ->
            val name=ServantList[position]
            Toast.makeText(this,name.name,Toast.LENGTH_SHORT).show()
        }
        val edit_input: EditText =findViewById(R.id.edit_input)
        val button2_0: Button = findViewById(R.id.button2_0)
        button2_0.setOnClickListener {
//            val intent= Intent(this,FGOWikiActivity::class.java)
//            startActivity(intent)
//            finish()//关闭此页面刷新
//            overridePendingTransition(0,0)//去掉刷新动画
            adapter.clear()
            FindServantList()
            listView.adapter = adapter
        }//刷新此页面/给页面加载全查找视图
        val button2_1: Button = findViewById(R.id.button2_1)
        button2_1.setOnClickListener {
            var i:Int
            createData()
            i=createData()
            if(i==-1){
                val intent= Intent(this,UpdateActivity::class.java)
                startActivity(intent)
//                finish()//关闭此页面刷新
//                overridePendingTransition(0,0)//去掉刷新动画
            }
        }//跳转到增加页面，返回值而且全查找
        val button2_2: Button = findViewById(R.id.button2_2)
        button2_2.setOnClickListener{
            adapter.clear()
            val servantData = CreateServantData(this, "ServantStore.db", 1)
            val sD = servantData.writableDatabase
            val input=edit_input.getText().toString()
            if(input.isEmpty()){
                Toast.makeText(this,"至少输入一个值来完成查找工作",Toast.LENGTH_SHORT).show()
            }else{
                val cursor=sD.rawQuery("select * from Servant where id like ? OR rank = ?", arrayOf(input,input))
                if (cursor.moveToFirst()) {
                    do {
                        val id = cursor.getInt(cursor.getColumnIndex("id"))
                        val name = cursor.getString(cursor.getColumnIndex("name"))
                        val rank = cursor.getString(cursor.getColumnIndex("rank"))
                        val Treasuretools = cursor.getString(cursor.getColumnIndex("Treasuretools"))
                        when {
                            rank == "Archer" -> {
                                val rankid = R.drawable.archer_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Alterego" -> {
                                val rankid = R.drawable.alterego_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Assassin" -> {
                                val rankid = R.drawable.assassin_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Avenger" -> {
                                val rankid = R.drawable.avenger_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Berserker" -> {
                                val rankid = R.drawable.berserker_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Caster" -> {
                                val rankid = R.drawable.caster_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Foreigner" -> {
                                val rankid = R.drawable.foreigner_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Lancer" -> {
                                val rankid = R.drawable.lancer_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "MoonCancer" -> {
                                val rankid = R.drawable.mooncancer_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Pretender" -> {
                                val rankid = R.drawable.pretender_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Rider" -> {
                                val rankid = R.drawable.rider_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Saber" -> {
                                val rankid = R.drawable.saber_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            rank == "Shielder" -> {
                                val rankid = R.drawable.shielder_1
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                            else -> {
                                val rankid = R.drawable.all_2
                                ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                            }
                        }
                    } while (cursor.moveToNext())
                    cursor.close()
                }
            }
            listView.adapter = adapter//加载适配器
        }//跳转到查询页面，返回查询值查找
        val button2_3: Button = findViewById(R.id.button2_3)
        button2_3.setOnClickListener {
            var i:Int
            createData()
            i=createData()
            if(i==-1){
                val intent= Intent(this,FGOWikiActivity::class.java)
                startActivity(intent)
                finish()//关闭此页面刷新
                overridePendingTransition(0,0)//去掉刷新动画
            }
        }//跳转到更新页面，返回查询值查找
        val button2_4: Button = findViewById(R.id.button2_4)
        button2_4.setOnClickListener {
            adapter.clear()
            val servantData = CreateServantData(this, "ServantStore.db", 1)
            val sD = servantData.writableDatabase
            val input=edit_input.getText().toString()
           if (input.isEmpty()){
                Toast.makeText(this,"至少输入一个值来完成删除工作",Toast.LENGTH_SHORT).show()
            }else if (!input.isEmpty()){
                sD.execSQL("delete from Servant where id= ? or rank=?",arrayOf(input,input))
                FindServantList()}
            listView.adapter = adapter//加载适配器
        }//跳转到删除页面，返回查询值查找
    }

    private fun createData(): Int {
        val extradata1 = intent.getIntExtra("extra_data1", -1)
        val extradata2 = intent.getStringExtra("extra_data2")
        val extradata3 = intent.getStringExtra("extra_data3")
        val extradata4 = intent.getStringExtra("extra_data4")
        Toast.makeText(
            this, "$extradata1" +
                    "$extradata2" +
                    "$extradata3" +
                    "$extradata4", Toast.LENGTH_SHORT).show()
            val servantData = CreateServantData(this, "ServantStore.db", 1)
            val sD = servantData.writableDatabase
        when{
            extradata1==-1 ->{ val intent= Intent(this,UpdateActivity::class.java)
            startActivity(intent)
            }
            extradata1==1 ->{
            var value = ContentValues().apply {
                    put("name", extradata2)
                    put("rank", extradata3)
                    put("Treasuretools", extradata4)
                }
            sD.insert("Servant", null, value)
            }
            else ->{sD.execSQL("update Servant set id=?,name=?,rank=?,Treasuretools=?", arrayOf(extradata1,extradata2,extradata3,extradata4))
            }
        }
        return -1
    }

    @SuppressLint("Range")
    private fun FindServantList(): Int {
        val servantData = CreateServantData(this, "ServantStore.db", 1)
        val sD = servantData.writableDatabase
        val cursor = sD.query("Servant", null, null, null, null, null, null)
        var rowCount: Int = 0
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex("id"))
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val rank = cursor.getString(cursor.getColumnIndex("rank"))
                val Treasuretools = cursor.getString(cursor.getColumnIndex("Treasuretools"))
                when {
                    rank == "Archer" -> {
                        val rankid = R.drawable.archer_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Alterego" -> {
                        val rankid = R.drawable.alterego_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Assassin" -> {
                        val rankid = R.drawable.assassin_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Avenger" -> {
                        val rankid = R.drawable.avenger_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Berserker" -> {
                        val rankid = R.drawable.berserker_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Caster" -> {
                        val rankid = R.drawable.caster_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Foreigner" -> {
                        val rankid = R.drawable.foreigner_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Lancer" -> {
                        val rankid = R.drawable.lancer_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "MoonCancer" -> {
                        val rankid = R.drawable.mooncancer_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Pretender" -> {
                        val rankid = R.drawable.pretender_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Rider" -> {
                        val rankid = R.drawable.rider_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Saber" -> {
                        val rankid = R.drawable.saber_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    rank == "Shielder" -> {
                        val rankid = R.drawable.shielder_1
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                    else -> {
                        val rankid = R.drawable.all_2
                        ServantList.add(FGOServantList(id, name, rankid, Treasuretools))
                        rowCount++
                    }
                }
            } while (cursor.moveToNext())
            cursor.close()
        }
        //Log.d("FGOWikiActivity", "数据是 $rowCount")
        return rowCount
    }//全查找列表，并把MySQL中数据赋值到FGOServantList
}


class CreateServantData(val context: Context,name:String,version: Int):SQLiteOpenHelper(context,name,null,version){
    private val createServant="create table Servant(" +
            "id integer primary key autoincrement,"+
            "name text," +
            "rank text," +
            "Treasuretools text)"
    private val Servant="insert into Servant (id,name,rank,Treasuretools) values(\"1\",\"玛修・基列莱特\",\"Shielder\",\"蓝卡辅助\")," +
            "(\"2\",\"阿尔托莉雅・潘德拉贡\",\"Saber\",\"红卡光炮\")," +
            "(\"3\",\"阿尔托莉雅・潘德拉贡〔Alter〕\",\"Saber\",\"红卡光炮\")," +
            "(\"4\",\"阿尔托莉雅・潘德拉贡〔Lily〕\",\"Saber\",\"红卡光炮\")," +
            "(\"5\",\"尼禄・克劳狄乌斯\",\"Saber\",\"蓝卡光炮\")," +
            "(\"6\",\"齐格飞\",\"Saber\",\"红卡光炮\")," +
            "(\"7\",\"盖乌斯・尤利乌斯・恺撒\",\"Saber\",\"绿卡单体\")," +
            "(\"8\",\"阿蒂拉\",\"Saber\",\"红卡光炮\")," +
            "(\"9\",\"吉尔・德・雷\",\"Saber\",\"蓝卡辅助\")," +
            "(\"10\",\"骑士迪昂\",\"Saber\",\"蓝卡辅助\")," +
            "(\"11\",\"卫宫\",\"Archer\",\"红卡光炮\")," +
            "(\"12\",\"吉尔伽美什\",\"Archer\",\"红卡光炮\")," +
            "(\"13\",\"罗宾汉\",\"Archer\",\"绿卡单体\")," +
            "(\"14\",\"阿塔兰忒\",\"Archer\",\"绿卡光炮\")," +
            "(\"15\",\"尤瑞艾莉\",\"Archer\",\"蓝卡单体\")," +
            "(\"16\",\"阿拉什\",\"Archer\",\"红卡光炮\")," +
            "(\"17\",\"库・丘林\",\"Lancer\",\"绿卡单体\")," +
            "(\"18\",\"伊丽莎白・巴托里\",\"Lancer\",\"红卡光炮\")," +
            "(\"19\",\"武藏坊弁庆\",\"Lancer\",\"蓝卡辅助\")," +
            "(\"20\",\"库・丘林〔Prototype〕\",\"Lancer\",\"绿卡单体\")," +
            "(\"21\",\"列奥尼达一世\",\"Lancer\",\"红卡辅助\")," +
            "(\"22\",\"罗穆路斯\",\"Lancer\",\"红卡光炮\")," +
            "(\"23\",\"美杜莎\",\"Rider\",\"绿卡光炮\")," +
            "(\"24\",\"乔尔乔斯\",\"Rider\",\"蓝卡单体\")," +
            "(\"25\",\"爱德华・蒂奇\",\"Rider\",\"红卡光炮\")," +
            "(\"26\",\"布狄卡\",\"Rider\",\"蓝卡辅助\")," +
            "(\"27\",\"牛若丸\",\"Rider\",\"绿卡单体\")," +
            "(\"28\",\"亚历山大\",\"Rider\",\"绿卡光炮\")," +
            "(\"29\",\"玛丽・安托瓦内特\",\"Rider\",\"绿卡光炮\")," +
            "(\"30\",\"玛尔达\",\"Rider\",\"红卡光炮\")," +
            "(\"31\",\"美狄亚\",\"Caster\",\"蓝卡单体\")," +
            "(\"32\",\"吉尔・德・雷\",\"Caster\",\"红卡光炮\")," +
            "(\"33\",\"汉斯・克里斯蒂安・安徒生\",\"Caster\",\"蓝卡辅助\")," +
            "(\"34\",\"威廉・莎士比亚\",\"Caster\",\"红卡光炮\")," +
            "(\"35\",\"梅菲斯托费勒斯\",\"Caster\",\"红卡光炮\")," +
            "(\"36\",\"沃尔夫冈・阿马德乌斯・莫扎特\",\"Caster\",\"蓝卡辅助\")," +
            "(\"37\",\"诸葛孔明〔埃尔梅罗Ⅱ世〕\",\"Caster\",\"蓝卡辅助\")," +
            "(\"38\",\"库・丘林\",\"Caster\",\"红卡全体\")," +
            "(\"39\",\"佐佐木小次郎\",\"Assassin\",\"绿卡单体\")," +
            "(\"40\",\"咒腕哈桑\",\"Assassin\",\"绿卡单体\")," +
            "(\"41\",\"斯忒诺\",\"Assassin\",\"蓝卡单体\")"
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createServant)
        db.execSQL(Servant)
        Toast.makeText(context,"创建表成功",Toast.LENGTH_SHORT).show()
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        /*if (db != null) {
            db.execSQL("drop table if exists Servant")
            onCreate(db)
        }*/
    }
}
class FGOServantListAdapter (activity: Activity, val resourceId:Int, data: List<FGOServantList>):
    ArrayAdapter<FGOServantList>(activity, resourceId,data){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view:View
        if (convertView==null){
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)
        }else{
            view=convertView
        }
        val Servantid: TextView = view.findViewById(R.id.textview_id)
        val Servantname: TextView = view.findViewById(R.id.textview_name)
        var Servantrankid: ImageView = view.findViewById(R.id.image_rank)
        val ServantTreasuretools: TextView = view.findViewById(R.id.textview_Treasuretools)
        val ServantList = getItem(position)
        if (ServantList != null) {
            Servantid.text= ServantList.id.toString()
            Servantname.text = ServantList.name
            Servantrankid.setImageResource(ServantList.rankid)
            ServantTreasuretools.text = ServantList.Treasuretools
        }
        return view
    }
}//得到FGOServantList中的数据，给listeview加载内容视图
class FGOServantList(val id: Int, val name:String, val rankid: Int, val Treasuretools:String){
}
