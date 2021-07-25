package com.test.myapplication.data

import com.test.myapplication.data.schema.LinksSchema
import com.test.myapplication.data.schema.SponsorshipSchema
import com.test.myapplication.data.schema.UrlsSchema
import com.test.myapplication.data.schema.UserSchema

data class Task2Image(
    var id : String,
    var createdAt : String,
    var updatedAt : String,
    var promotedAt : String,
    var width : Int,
    var height : Int,
    var color : String,
    var blurHash : String,
    var description : String,
    var altDescription : String,
    var urls : UrlsSchema,
    var links : LinksSchema,
    var categories : List<String>,
    var likes : Int,
    var likedByUser : Boolean,
    var currentUserCollections : List<String>,
    var sponsorship : SponsorshipSchema,
    var user : UserSchema
)
