package com.booisajerk.preparednessbuddy


data class RelationshipLevel (val relationshipType: String) {
    override fun toString(): String {
        return relationshipType
    }
}


data class MedicalConditions (val medicalType: String) {
    override fun toString(): String {
        return medicalType
    }
}