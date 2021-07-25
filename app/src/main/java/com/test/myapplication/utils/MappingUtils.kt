package com.test.myapplication.utils

import com.test.myapplication.data.*
import com.test.myapplication.data.schema.*

fun mapTask2ImageSchemaToTask2Image(task2ImageSchemaList: List<Task2ImageSchema>?): ArrayList<Task2Image> {
    val task2ImageList = ArrayList<Task2Image>()
    if (task2ImageSchemaList.isNullOrEmpty()) {
        return task2ImageList
    } else {
        for (task2ImageSchema in task2ImageSchemaList) {
            task2ImageList.add(
                Task2Image(
                    task2ImageSchema.id ?: "",
                    task2ImageSchema.createdAt ?: "",
                    task2ImageSchema.updatedAt ?: "",
                    task2ImageSchema.promotedAt ?: "",
                    task2ImageSchema.width ?: 0,
                    task2ImageSchema.height ?: 0,
                    task2ImageSchema.color ?: "",
                    task2ImageSchema.blurHash ?: "",
                    task2ImageSchema.description ?: "",
                    task2ImageSchema.altDescription ?: "",
                    getImageUrls(task2ImageSchema.urls),
                    getLinks(task2ImageSchema.links),
                    task2ImageSchema.categories ?: emptyList(),
                    task2ImageSchema.likes ?: 0,
                    task2ImageSchema.likedByUser ?: false,
                    task2ImageSchema.currentUserCollections ?: emptyList(),
                     getSponsorship(task2ImageSchema.sponsorship),
                    getUser(task2ImageSchema.user)
                )
            )
        }
        return task2ImageList
    }
}

private fun getImageUrls(imageUrls: UrlsSchema?): Urls {
    return Urls(
        imageUrls?.raw ?: "",
        imageUrls?.full ?: "",
        imageUrls?.regular ?: "",
        imageUrls?.small ?: "",
        imageUrls?.thumb ?: ""
    )
}

private fun getLinks(links: LinksSchema?): Links {
    return Links(
        links?.self ?: "",
        links?.html ?: "",
        links?.download ?: "",
        links?.downloadLocation ?: ""
    )
}

private fun getSponsorship(sponsorshipSchema: SponsorshipSchema?): Sponsorship {
    return Sponsorship(
        sponsorshipSchema?.impressionUrls ?: emptyList(),
        sponsorshipSchema?.tagline ?: "",
        sponsorshipSchema?.taglineUrl ?: ""
    )
}

private fun getUser(userSchema: UserSchema?): User {
    return User(
        userSchema?.id ?: "",
        userSchema?.updatedAt ?: "",
        userSchema?.username ?: "",
        userSchema?.name ?: "",
        userSchema?.firstName ?: "",
        userSchema?.lastName ?: "",
        userSchema?.twitterUsername ?: "",
        userSchema?.portfolioUrl ?: "",
        userSchema?.bio ?: "",
        userSchema?.location ?: "",
        userSchema?.instagramUsername ?: "",
        userSchema?.totalCollections ?: 0,
        userSchema?.totalLikes ?: 0,
        userSchema?.totalPhotos ?: 0,
        userSchema?.acceptedTos ?: false,
        userSchema?.forHire ?: false
    )
}