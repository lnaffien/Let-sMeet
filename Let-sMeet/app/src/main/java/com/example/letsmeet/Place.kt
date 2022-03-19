package com.example.letsmeet

class Place
{
    var name : String
    var type : String
    var address : String ?
    var access : String ?
    var url : String ?
    var description : String

    constructor(name: String,
                type: String,
                address: String ?,
                access: String ?,
                url: String ?,
                description: String)
    {
        this.name = name
        this.type = type
        this.address = address
        this.access = access
        this.url = url
        this.description = description
    }





}