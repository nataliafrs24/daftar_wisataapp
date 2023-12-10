package com.example.aplikasiandroidsederhana

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiandroidsederhana.adapter.PartAdapter
import com.example.aplikasiandroidsederhana.`interface`.RecyclerViewClickListener
import com.example.aplikasiandroidsederhana.model.PCPartsModel

class MainActivity : AppCompatActivity(), RecyclerViewClickListener{
    private val list=ArrayList<PCPartsModel>()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        list.addAll(getListPCParts())

        val partAdapter=PartAdapter(list)
        val recyclerView: RecyclerView = findViewById(R.id.rv_pcparts)

        val apptitle = findViewById<TextView>(R.id.tvTitle)
        apptitle.text = "Beranda"

        val ivprofile = findViewById<ImageView>(R.id.imgProfile)
        ivprofile.visibility = View.VISIBLE
        ivprofile.setOnClickListener {
            val intent=Intent(this, MyProfile::class.java)
            startActivity(intent)
        }

        partAdapter.listener = this

        recyclerView.apply {
            this.adapter = partAdapter
            this.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    @SuppressLint("Recycle")
    private fun getListPCParts(): ArrayList<PCPartsModel>{
        val dataName=resources.getStringArray(R.array.data_name)
        val dataDescription=resources.getStringArray(R.array.data_description)
        val dataPhoto=resources.obtainTypedArray(R.array.data_photo)
        val listModelPCParts=ArrayList<PCPartsModel>()
        for (i in dataName.indices){
            val mpcppart= PCPartsModel(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listModelPCParts.add(mpcppart)
        }
        return listModelPCParts
    }

    override fun onItemClicked(view: View, data: PCPartsModel) {
        val intent=Intent(this, DetailsOfPart::class.java)
        intent.putExtra(DetailsOfPart.EXTRA_NAME, data.name)
        intent.putExtra(DetailsOfPart.EXTRA_DESCRIPTION, data.description)
        intent.putExtra(DetailsOfPart.EXTRA_PHOTO, data.photo)
        startActivity(intent)
    }
}