package com.test.myapplication.data

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
    var urls : Urls,
    var links : Links,
    var categories : List<String>,
    var likes : Int,
    var likedByUser : Boolean,
    var currentUserCollections : List<String>,
    var sponsorship : Sponsorship,
    var user : User
)
