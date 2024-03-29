package com.booisajerk.preparednessbuddy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.booisajerk.preparednessbuddy.ui.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.carousel_view.*
import kotlinx.android.synthetic.main.course_scroll_view.*
import kotlinx.android.synthetic.main.progress_view.*


class MainActivity : AppCompatActivity() {

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
                startActivity(Intent(this, LoginActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    //TODO add real images here
    private var sampleImages =
        intArrayOf(R.drawable.shop)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        progress_button.setOnClickListener {
            startActivity(Intent(this, AccountSetupActivity::class.java))
        }

        scroll_button_one.setOnClickListener {
            //TODO for testing - remove
        }

        // Carousel View
        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener(imageListener)
    }

    var imageListener: ImageListener = ImageListener { position, imageView ->
        imageView.setImageResource(sampleImages[position])
    }
}
