package com.booisajerk.preparednessbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_family.*

class HouseholdList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)


        buttonAddFam.setOnClickListener { view ->
            val activityIntent = Intent(this, FamilyMemberInputActivity::class.java)
            startActivity(activityIntent)
        }
    }

}
