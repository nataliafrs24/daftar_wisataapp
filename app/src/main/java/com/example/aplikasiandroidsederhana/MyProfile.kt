package com.example.aplikasiandroidsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        supportActionBar?.hide()

        val ivprofilebutton = findViewById<ImageView>(R.id.imgProfile)
        ivprofilebutton.visibility = ImageView.GONE

    }
}