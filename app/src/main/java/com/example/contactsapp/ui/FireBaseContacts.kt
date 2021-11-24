package com.example.contactsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.contactsapp.PhoneContacts
import com.example.contactsapp.R

class FireBaseContacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_base_contacts)

        val btn = findViewById<Button>(R.id.btn_default_phone_contacts)
        btn.setOnClickListener {
            Intent(this, PhoneContacts::class.java).also {
                startActivity(it)
            }
        }
    }
}