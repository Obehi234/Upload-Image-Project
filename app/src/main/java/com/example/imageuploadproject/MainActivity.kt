package com.example.imageuploadproject

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var image_view: ImageView
    lateinit var btnChange: Button
    lateinit var btnUpload: Button

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            image_view.setImageURI(uri)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private fun setup() {
        image_view = findViewById(R.id.image_view)
        btnChange = findViewById(R.id.btnChange)
        btnUpload = findViewById(R.id.btnUpload)

        btnChange.setOnClickListener { contract.launch("image/*") }
        btnUpload.setOnClickListener { upload() }
    }

    private fun upload() {
        TODO("Not yet implemented")
    }
}