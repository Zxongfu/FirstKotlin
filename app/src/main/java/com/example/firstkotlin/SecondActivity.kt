package com.example.firstkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val message:String
        val bundle = this.intent.extras
        message = bundle?.get("message").toString()
        tvMessage.text = message



        back.setOnClickListener {
            val intent = Intent()
            intent.putExtra("message", message)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}