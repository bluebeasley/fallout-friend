package com.booisajerk.preparednessbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_form_input.*

class FormInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_input)

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