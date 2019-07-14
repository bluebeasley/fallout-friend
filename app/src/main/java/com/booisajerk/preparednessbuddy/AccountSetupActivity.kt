package com.booisajerk.preparednessbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account_setup.*

class AccountSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_setup)

        household_task.setOnClickListener {
            startActivity(Intent(this, HouseholdList::class.java))
        }
    }
}
