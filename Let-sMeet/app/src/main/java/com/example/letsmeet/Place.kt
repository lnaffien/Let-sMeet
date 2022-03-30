package com.example.letsmeet

data class Place (val accessForWheelchair : Int?,
                  val images : String?,
                  val description : String,
                  val accessfordeaf : Int,
                  val types : String,
                  val accessforblind : Int,
                  val accessforelder : Int,
                  val address : String,
                  val access : String?,
                  val name : String,
                  val friendlyurl : String?,
                  val accessfordeficient : Int,
                  val serviceandactivities : String?,
                  val point_geo : ArrayList<Float>)
