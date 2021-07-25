package com.test.myapplication.data

data class User(
    var id: String,
    var updatedAt: String,
    var username: String,
    var name: String,
    var firstName: String,
    var lastName: String,
    var twitterUsername: String,
    var portfolioUrl: String,
    var bio: String,
    var location: String,
    var instagramUsername: String,
    var totalCollections: Int,
    var totalLikes: Int,
    var totalPhotos: Int,
    var acceptedTos: Boolean,
    var forHire: Boolean

)
