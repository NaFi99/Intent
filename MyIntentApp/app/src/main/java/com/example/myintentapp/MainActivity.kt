package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

/*
Intent adalah mekanisme untuk melakukan sebuah action
dan komunikasi antar komponen aplikasi
misal activity, services, dan broadcast receiver.
 */

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Mendefinisikan Tombol Dari Activity
        val btnAct : Button = findViewById(R.id.btn_move)
        btnAct.setOnClickListener(this)

        val btnMove : Button = findViewById(R.id.btn_move_data)
        btnMove.setOnClickListener(this)

        val dialNum : Button = findViewById(R.id.dial_num)
        dialNum.setOnClickListener(this)
    }

    //Memberikan fungsi klik dan action pada tombol
    override fun onClick(v: View?){
        when (v?.id){
            R.id.btn_move -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            //Memanggil konstanta (moveWithData)
            //putExtra untuk mengirim data bersamaan dengan intent
            R.id.btn_move_data -> {
                val moveWithData = Intent(this@MainActivity, MoveDataActivity::class.java)
                moveWithData.putExtra(MoveDataActivity.EXTRA_NAME, "The Fikriansyah")
                moveWithData.putExtra(MoveDataActivity.EXTRA_AGE, 21)
                startActivity(moveWithData)
            }
            R.id.dial_num ->{
                val phoneNumber = "081252262664"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)

            }
        }
    }
}