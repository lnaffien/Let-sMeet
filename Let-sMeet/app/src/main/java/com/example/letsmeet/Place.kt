package com.example.letsmeet

data class Place (val types : String,
                  val name : String,
                  val address : String ?,
                  val access : String ?,
                  val friendlyURL : String ?,
                  val description : String ?,
                  val serviceAndActivities : String?,
                  val accessForDeaf : Boolean ?,
                  val accessForElder : Boolean ?,
                  val accessForDeficient : Boolean ?,
                  val accessForWheelchair : Boolean ?,
                  val accessForBlind : Boolean ?)
