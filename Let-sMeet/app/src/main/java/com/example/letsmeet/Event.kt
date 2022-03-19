package com.example.letsmeet

import java.util.*
import kotlin.collections.ArrayList

class Event
{
    var place : ArrayList<Place>
    var start : Date ?
    var end : Date ?

    constructor(place: ArrayList<Place>,
                start: Date ?,
                end: Date ?)
    {
        this.place = place
        this.start = start
        this.end = end
    }

}