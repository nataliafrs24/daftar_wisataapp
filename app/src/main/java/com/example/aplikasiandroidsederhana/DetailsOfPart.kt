package com.example.aplikasiandroidsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class DetailsOfPart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_of_part)
        supportActionBar?.hide()

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        val tvjudul: TextView = findViewById(R.id.tv_item_name)
        val tvdeskripsi: TextView = findViewById(R.id.tv_item_description)
        val ivgambar: ImageView = findViewById(R.id.img_item_photo)

        tvjudul.text = name
        tvdeskripsi.text = description
        ivgambar.setImageResource(photo)

        val title = findViewById<TextView>(R.id.tvTitle)
        title.text = name

        val ivprofile = findViewById<ImageView>(R.id.imgProfile)
        ivprofile.visibility = View.GONE

    }

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
    }
}