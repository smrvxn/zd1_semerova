package com.example.zd1_semerova

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var settings: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.editText)
        password = findViewById(R.id.editText2)
        settings = getSharedPreferences("PREF_FILMS", MODE_PRIVATE)

        if(settings.contains("LOGIN") && settings.contains("PASS"))
        {
            var log = settings.getString("LOGIN", "NONE")
            var pass = settings.getString("PASS", "NONE")
            login.setText(log)
            password.setText(pass)
        }
    }


    fun onClick(view: View)
    {
        if(login.text.isNotEmpty() || password.text.isNotEmpty())
        {
            var editPref = settings.edit()
            editPref.putString("LOGIN",login.text.toString())
            editPref.putString("PASS", password.text.toString())
            editPref.apply()
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(intent)
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("error")
                .setMessage("Заполните все поля!")
                .setPositiveButton("ok",null)
                .create()
                .show()
        }
    }
}