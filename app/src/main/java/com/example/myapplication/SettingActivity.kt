package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private val data = listOf<String>("系统设置界面","APN设置界面","定位设置界面","更多连接方式设置界面"
    ,"双卡和移动网络设置界面","无障碍设置界面/辅助功能界面","同步设置界面","添加账户界面","选取运营商的界面","安全设置界面",
        "备份重置设置界面","VPN设置界面,可能不存在","无线网设置界面","WIFI的IP设置","WIFI的IP设置","投射设置","日期时间设置","声音设置",
        "显示设置","语言设置","辅助应用和语音输入设置","语言和输入法设置","个人字典设置界面","搜索设置界面",
        "开发者选项","手机状态信息的界面","互动屏保设置的界面","通知使用权设置的界面","勿扰权限设置的界面","字幕设置的界面","打印设置界面",
        "节电助手界面","主屏幕设置界面","根据包名跳转到系统自带的应用程序信息","应用程序列表"
    )
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_layout)
        val listView = findViewById<ListView>(R.id.settinglist)
//        val button1: Button = findViewById(R.id.button1)
        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data)
        listView.adapter=adapter
        listView.setOnItemClickListener(){
                parent,view,position,id ->
            val name=data[position]
            mySwitch(name)
        }
//        button1.setOnClickListener {
////          val intent=Intent("android.media.action.IMAGE_CAPTURE")//启动相机
//            val intent=Intent(Settings.ACTION_SETTINGS)//启动设置页面
//
//            startActivity(intent)
//
//        }
    }

    private fun mySwitch(name: String)=when(name) {
        "系统设置界面"->startActivity(Intent(Settings.ACTION_SETTINGS))
        "系统设置界面"->startActivity(Intent(Settings.ACTION_SETTINGS))
        "APN设置界面"->startActivity(Intent(Settings.ACTION_APN_SETTINGS))
        "定位设置界面"->startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        "更多连接方式设置界面"->startActivity(Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS))
        "双卡和移动网络设置界面"->startActivity(Intent(Settings.ACTION_DATA_ROAMING_SETTINGS))
        "无障碍设置界面/辅助功能界面"->startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        "同步设置界面"->startActivity(Intent(Settings.ACTION_SYNC_SETTINGS))
        "添加账户界面"->startActivity(Intent(Settings.ACTION_ADD_ACCOUNT))
        "选取运营商的界面"->startActivity(Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS))
        "安全设置界面"->startActivity(Intent(Settings.ACTION_SECURITY_SETTINGS))
        "备份重置设置界面"->startActivity(Intent(Settings.ACTION_PRIVACY_SETTINGS))
        "VPN设置界面,可能不存在"->startActivity(Intent(Settings.ACTION_VPN_SETTINGS))
        "无线网设置界面"->startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
        "WIFI的IP设置"->startActivity(Intent(Settings.ACTION_WIFI_IP_SETTINGS))
        "蓝牙设置"->startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS))
        "投射设置"->startActivity(Intent(Settings.ACTION_CAST_SETTINGS))
        "日期时间设置"->startActivity(Intent(Settings.ACTION_DATE_SETTINGS))
        "显示设置"->startActivity(Intent(Settings.ACTION_DISPLAY_SETTINGS))
        "语言设置"->startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
        "辅助应用和语音输入设置"->startActivity(Intent(Settings.ACTION_VOICE_INPUT_SETTINGS))
        "语言和输入法设置"->startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
        "个人字典设置界面"->startActivity(Intent(Settings.ACTION_USER_DICTIONARY_SETTINGS))
        "存储空间设置的界面"->startActivity(Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS))
        "搜索设置界面"->startActivity(Intent(Settings.ACTION_SEARCH_SETTINGS))
        "开发者选项"->startActivity(Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS))
        "手机状态信息的界面"->startActivity(Intent(Settings.ACTION_DEVICE_INFO_SETTINGS))
        "互动屏保设置的界面"->startActivity(Intent(Settings.ACTION_DREAM_SETTINGS))
        "通知使用权设置的界面"->startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        "勿扰权限设置的界面"->startActivity(Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS))
        "字幕设置的界面"->startActivity(Intent(Settings.ACTION_CAPTIONING_SETTINGS))
        "打印设置界面"->startActivity(Intent(Settings.ACTION_PRINT_SETTINGS))
        "节电助手界面"->startActivity(Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS))
        "主屏幕设置界面"->startActivity(Intent(Settings.ACTION_HOME_SETTINGS))
        "根据包名跳转到系统自带的应用程序信息"->startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS))
        "应用程序列表"->startActivity(Intent(Settings.ACTION_APPLICATION_SETTINGS))
        else -> {Toast.makeText(this,"功能开发中",Toast.LENGTH_SHORT).show()}
    }


}
