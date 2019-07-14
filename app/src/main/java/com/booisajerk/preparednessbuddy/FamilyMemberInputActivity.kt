package com.booisajerk.preparednessbuddy

import android.content.Context
import android.content.SharedPreferences;
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form_input.*

class FamilyMemberInputActivity : AppCompatActivity() {

    companion object {
        private val SHARED_PREF_NAME = "username"
        private val KEY_NAME = "key_name"
        private val KEY_DOB = "key_dateOfBirth"
        private val KEY_RELATIONSHIP = "key_relationship"
        private val KEY_MEDICAL = "key_medical"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_input)

        val sp = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()

        var intent = intent
        textBirthday.text = intent.getStringExtra("DateExtra")
        var birthday: String? = textBirthday.text as String

        editor.putString(KEY_DOB, birthday)
        editor.apply()

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

        var relationship: String? = spinnerRelationship.toString()
        editor.putString(KEY_RELATIONSHIP, relationship)
        editor.apply()


        val medicalSelection = ArrayAdapter<MedicalConditions>(
            this,
            android.R.layout.simple_spinner_item,
            FormDataManager.medicals.values.toList()
        )
        medicalSelection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerMedical.adapter = medicalSelection

        var medical: String? = spinnerMedical.toString()
        editor.putString(KEY_MEDICAL, medical)
        editor.apply()
    }
}