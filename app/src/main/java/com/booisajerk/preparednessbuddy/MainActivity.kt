package com.booisajerk.preparednessbuddy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.carousel_view.*
import kotlinx.android.synthetic.main.course_scroll_view.*


class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //TODO do something
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_chat -> {
                //TODO do something
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_alert -> {
                //TODO do something
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_profile -> {
                //TODO do something
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    //TODO add real images here
    var sampleImages =
        intArrayOf(R.drawable.ic_chat_bubble_black_24dp, R.drawable.ic_mood_black_24dp)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        scroll_button_one.setOnClickListener {
            //TODO for testing - remove
            startActivity(Intent(this, FormInputActivity::class.java))
            Log.d("Parker", "Open intent")
        }

        // Carousel View
        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener(imageListener)
    }

    var imageListener: ImageListener = ImageListener { position, imageView ->
        imageView.setImageResource(sampleImages[position])
    }
}
