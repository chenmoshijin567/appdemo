package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class FirstActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
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
            val intent=Intent(this,GongnengActivity::class.java)
            startActivity(intent)
        }
        val preview_gif:ImageView=findViewById(R.id.preview)
        Glide.with(this).load(R.drawable.preview).into(preview_gif)
    }
}