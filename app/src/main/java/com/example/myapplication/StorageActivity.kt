package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class StorageActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.storage_layout)
        val button3_1:Button=findViewById(R.id.button3_1)
        val edit_text:EditText=findViewById(R.id.edit_text)
        val button3_2:Button=findViewById(R.id.button3_2)
        val textview_3:TextView=findViewById(R.id.textview_3)
        button3_1.setOnClickListener{
            val inputText=edit_text.text.toString()
            save(inputText)
        }
        button3_2.setOnClickListener{
            val inputText= load()
            textview_3.setText(inputText)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val edit_text:EditText=findViewById(R.id.edit_text)
        val inputText=edit_text.text.toString()
        save(inputText)
    }
    private fun save(inputText: String){
        try {
            val output=openFileOutput("data",Context.MODE_PRIVATE)
            val writer=BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(inputText)
            }
        }catch (e :IOException){
            e.printStackTrace()
        }
    }
    private fun load():String{
        val content = StringBuilder()
        try {
            val input=openFileInput("data")
            val reader=BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        }catch (e :IOException){
            e.printStackTrace()
        }
        return content.toString()
    }
}