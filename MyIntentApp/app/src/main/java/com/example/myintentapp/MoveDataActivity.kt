package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveDataActivity : AppCompatActivity() {

    // Memberikan konstanta yang tetap dan dapat diakses di semua kelas dengan companion
    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data)

        val data : TextView = findViewById(R.id.tv_data_received)
        val name= intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Nama: $name, \nUmur: $age"
        data.text = text
    }

}