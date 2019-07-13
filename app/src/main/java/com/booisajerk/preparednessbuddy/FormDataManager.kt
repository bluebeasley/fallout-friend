package com.booisajerk.preparednessbuddy

object FormDataManager {
    val relationships = HashMap<String, RelationshipLevel>()
    val medicals = HashMap<String, MedicalConditions>()

    init {
        initializeRelationships()
        initializeMedicals()
    }

    private fun initializeRelationships() {
        var relationship = RelationshipLevel("Spouse")
        relationships.set(relationship.relationshipType, relationship)

        relationship = RelationshipLevel("Child")
        relationships.set(relationship.relationshipType, relationship)

        relationship = RelationshipLevel("Grandparent")
        relationships.set(relationship.relationshipType, relationship)
    }

    private fun initializeMedicals() {
        var medical = MedicalConditions("Diabetic")
        medicals.set(medical.medicalType, medical)

        medical = MedicalConditions("Other medical stuff")
        medicals.set(medical.medicalType, medical)

        medical = MedicalConditions("Dialysis")
        medicals.set(medical.medicalType, medical)
    }


}