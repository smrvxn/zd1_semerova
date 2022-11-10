package com.example.zd1_semerova

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.log
import android.content.Intent
import android.content.SharedPreferences
import android.view.View




class MainActivity2 : AppCompatActivity() {

    lateinit var spinner: Spinner
    lateinit var adapter: ArrayAdapter<String>

    lateinit var hello: TextView
    lateinit var text: TextView
    lateinit var settings: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        hello = findViewById(R.id.textView3)
        text = findViewById(R.id.text)
        spinner = findViewById(R.id.spin)

        settings = getSharedPreferences("PREF_FILMS", MODE_PRIVATE)
        val log = settings.getString("LOGIN", "NONE")
        hello.setText(log).toString()

        ArrayAdapter.createFromResource(
            this,
            R.array.films,
            android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter
          //  text.text = adapter.getItem([position]).toString()


        }

    }

    fun onClick(view: View)
    {
        text.text = spinner.adapter.toString()
    }



}