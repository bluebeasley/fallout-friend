package com.booisajerk.preparednessbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_household_list.*

class HouseholdList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_household_list)


        buttonAddFam.setOnClickListener { view ->
            val activityIntent = Intent(this, FormInputActivity::class.java)
            startActivity(activityIntent)
        }
    }

}
