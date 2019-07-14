package com.booisajerk.preparednessbuddy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import kotlinx.android.synthetic.main.content_date_picker.*
import java.util.*

class DatePicker : AppCompatActivity() {

    private lateinit var calendar:Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_date_picker)

        // Initialize a new calendar instance
        calendar = Calendar.getInstance()

        // Get the Calendar current year, month and day
        val thisYear = calendar.get(Calendar.YEAR)
        val thisMonth = calendar.get(Calendar.MONTH)
        val thisDay = calendar.get(Calendar.DAY_OF_MONTH)

        // Initialize the date picker widget with system current date
        date_picker.init(
            thisYear,
            thisMonth,
            thisDay
        )

        { _, year, monthOfYear, dayOfMonth ->
            //TODO add something here?
//            button_done.text = "Date Changed : ${formatDate(year,monthOfYear,dayOfMonth)}"
        }

        // Set a click listener for done button
        button_done.setOnClickListener{
           // button_done.text = "Yay!"
            // Get the date picker widget selected date
            val selectedDate = formatDate(date_picker.year,date_picker.month,date_picker.dayOfMonth)
            //TODO: close date picker and show date in FormInput


            val intent = Intent(this, FamilyMemberInputActivity::class.java)
            intent.putExtra("DateExtra", "$selectedDate")
            startActivity(intent)

            Log.d("test", "$selectedDate")
        }
    }

    // Custom method to format date
    private fun formatDate(year:Int, month:Int, day:Int):String{
        // Create a Date variable/object with user chosen date
        calendar.set(year, month, day, 0, 0, 0)
        val chosenDate = calendar.time

        // Format the date picker selected date
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)
    }

}