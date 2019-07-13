package com.booisajerk.preparednessbuddy

import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_date_picker.*
import java.text.DateFormat
import java.util.*


class DatePicker : AppCompatActivity() {

    private lateinit var calendar:Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_date_picker)

        // Initialize a new calendar instance
        calendar = Calendar.getInstance()

        // Get the Calendar current year, month and day of month
        val thisYear = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Initialize the date picker widget with system current date
        date_picker.init(
            thisYear,
            month,
            day
        ) { _, year, monthOfYear, dayOfMonth ->
            // Display the date picker selected date on text view
            text_view.text = "Date Changed : ${formatDate(year,monthOfYear,dayOfMonth)}"
        }


        // Set a click listener for set date button widget
        button_set.setOnClickListener{
            // Update the date picker data by a random date
            val year = randomInRange(2000,2025)
            val month = randomInRange(0,11)
            val day = randomInRange(0,27)

            // Update the date picker with random date
            date_picker.updateDate(
                year, // Year
                month, // The month which is starting from zero.
                day // Day of month
            )

            // Toast the new date
            Toast.makeText(
                applicationContext,
                "Set Date : ${formatDate(year,month,day)}",
                Toast.LENGTH_SHORT).show()

        }


        // Set a click listener for get date button widget
        button_get.setOnClickListener{
            // Get the date picker widget selected date
            val selectedDate = formatDate(date_picker.year,date_picker.month,date_picker.dayOfMonth)
            // Display the date picker selected formatted date
            text_view.text = "Selected Date : $selectedDate"
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


    // Custom method to get a random number from the provided range
    private fun randomInRange(min:Int, max:Int):Int{
        // Define a new Random class
        val r = Random()

        // Get the next random number within range
        // Including both minimum and maximum number
        return r.nextInt((max - min) + 1) + min;
    }
}