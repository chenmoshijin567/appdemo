package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class UpdateActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_layout)
        val edit_id: EditText =findViewById(R.id.edit_id)
        val edit_name: EditText =findViewById(R.id.edit_name)
        val edit_rank: EditText =findViewById(R.id.edit_rank)
        val edit_Treasuretools: EditText =findViewById(R.id.edit_Treasuretools)
        val buttonupdate:Button=findViewById(R.id.buttonupdate)
        val Idvalue = intent.getIntExtra("Idvalue", -1)
        Toast.makeText(this,"手机内置的数据库表长度为：$Idvalue",Toast.LENGTH_SHORT).show()
        buttonupdate.setOnClickListener{
            val input1=edit_id.getText().toString()
            var w:Int=Integer.parseInt(input1)
            val input2=edit_name.getText().toString()
            val input3=edit_rank.getText().toString()
            val input4=edit_Treasuretools.getText().toString()
            val intent=Intent(this,FGOWikiActivity::class.java)
            intent.putExtra("extra_data1",w)
            Toast.makeText(this,"$w",Toast.LENGTH_SHORT).show()
            startActivity(intent)
            Toast.makeText(this,"$w" +
                    "$input2" +
                    "$input3" +
                    "$input4" ,Toast.LENGTH_SHORT).show()
            if (!input1.isEmpty()&&!input2.isEmpty()&&!input3.isEmpty()&&!input4.isEmpty()){
                if (w>Idvalue){
                    val intent=Intent(this,FGOWikiActivity::class.java)
                    w=1
                    intent.putExtra("extra_data1",w)
                    intent.putExtra("extra_data2",input2)
                    intent.putExtra("extra_data3",input3)
                    intent.putExtra("extra_data4",input4)
                    Toast.makeText(this,"此时输入为增加!!!",Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }else if(w<=Idvalue){
                    val intent=Intent(this,FGOWikiActivity::class.java)
                    intent.putExtra("extra_data1",w)
                    intent.putExtra("extra_data2",input2)
                    intent.putExtra("extra_data3",input3)
                    intent.putExtra("extra_data4",input4)
                    Toast.makeText(this,"此时输入为更新!!!",Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }else{
                Toast.makeText(this,"输入的数据有误，请重新输入",Toast.LENGTH_SHORT).show()
            }
        }

    }
}
