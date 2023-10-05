package com.example.unit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FloatingButtonDemo : AppCompatActivity() {
    lateinit var add: FloatingActionButton
    lateinit var home: FloatingActionButton
    lateinit var setting: FloatingActionButton
    var fabvisibility = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_button_demo)
        add = findViewById(R.id.idFABAdd)
        home = findViewById(R.id.idFABHome)
        setting = findViewById(R.id.idFABSettings)
        add.setOnClickListener {
            if (!fabvisibility){
                setting.show()
                home.show()
                home.visibility = View.VISIBLE
                setting.visibility = View.VISIBLE
                add.setImageDrawable(resources.getDrawable(R.drawable.close))
                fabvisibility=true
            }
            else{
                setting.hide()
                home.hide()
                home.visibility = View.GONE
                setting.visibility = View.GONE
                add.setImageDrawable(resources.getDrawable(R.drawable.add))
                fabvisibility=false
            }
        }
        home.setOnClickListener {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
        }
        setting.setOnClickListener {
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
        }


    }
}