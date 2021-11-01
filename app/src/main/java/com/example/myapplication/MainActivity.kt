package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textV:TextView
    private lateinit var textView:TextView
    private var portrait:Int = 0
    private var landscape:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textV = findViewById(R.id.textView3)
        textView = findViewById(R.id.textView)
        textView.text = "onCreate()"


        if (savedInstanceState != null){
            portrait = savedInstanceState.getInt("landscape")
            landscape = savedInstanceState.getInt("landscape")
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            landscape++
            textV.text = "Landscape  " + landscape
        } else {
            portrait
            textV.text = "Portrait  " + portrait
        }

        var nextPageButton = findViewById<Button>(R.id.button1)
        nextPageButton.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)

        }

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("portrait", portrait)
        outState.putInt("landscape", landscape)
    }





    override fun onStart() {
        super.onStart()
// responsible for delaying the onStart method for 2s
        val handler = Handler()
        handler.postDelayed({
            // do something after 1000ms

//            val textView = findViewById<TextView>(R.id.textView)
            textView.text = "onStart()"
        }, 2000)

    }

    override fun onResume() {
        super.onResume()

// responsible for delaying the onResume method for extra 2s, making 4s
        val handler = Handler()
        handler.postDelayed({
            // do something after 1000ms
//             val textView = findViewById<TextView>(R.id.textView)
            textView.text = "onResume()"

        }, 4000)

    }


    override fun onRestart() {
        super.onRestart()
       Toast.makeText(applicationContext, "onRestart Called", Toast.LENGTH_LONG).show()
        textView.text = "onRestart()"
    }



    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "onPause Called", Toast.LENGTH_LONG).show()
//        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "onPause()"
    }



    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "onStop Called", Toast.LENGTH_LONG).show()
//        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "onStop()"
    }

    override fun onDestroy() {
        super.onDestroy()
         Toast.makeText(applicationContext, "onDestroy Called", Toast.LENGTH_LONG).show()
//        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "onDestroy()"
    }






}