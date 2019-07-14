package com.booisajerk.preparednessbuddy

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form_input.*

class FamilyMemberInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_input)

        var intent = intent
        textBirthday.text = intent.getStringExtra("DateExtra")


        textBirthday.setOnClickListener { view ->
            val activityIntent = Intent(this, DatePicker::class.java)
            startActivity(activityIntent)
        }

        val relationshipSelection = ArrayAdapter<RelationshipLevel>(
            this,
            android.R.layout.simple_spinner_item,
            FormDataManager.relationships.values.toList()
        )
        relationshipSelection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerRelationship.adapter = relationshipSelection

        val medicalSelection = ArrayAdapter<MedicalConditions>(
            this,
            android.R.layout.simple_spinner_item,
            FormDataManager.medicals.values.toList()
        )
        medicalSelection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerMedical.adapter = medicalSelection

    }
}