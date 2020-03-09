package com.example.firstkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val button: Button = findViewById(R.id.button)
        // val button =findViewById<Button>(R.id.button)
        // button =findViewById(R.id.button) as Button

        button.setOnClickListener {
            showToast("OK")
        }


//        btnSend.setOnClickListener {
//            val message = etMessage.text.toString()
//            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }


        btnSend.setOnClickListener {
            val message = etMessage.text.toString()
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            val bundle = Bundle()
            bundle.putString("message", message)
            intent.putExtras(bundle)
            startActivityForResult(intent, 0)
        }

        btnShare.setOnClickListener{
            val message = etMessage.text.toString()
            val intent=Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type="text/plain"

            startActivity(Intent.createChooser(intent,"Share to : "))

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            val message = data?.getStringExtra("message")
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

    }
}
