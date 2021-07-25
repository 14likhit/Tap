package com.test.myapplication.sampledata

import com.test.myapplication.data.*
import com.test.myapplication.data.schema.*

fun getTask2ImageSchemaList(): List<Task2ImageSchema> {
    return listOf(
        getTask2ImageSchema(),
        getTask2ImageSchema(),
        getTask2ImageSchema(),
        getTask2ImageSchema()
    )
}

private fun getTask2ImageSchema(): Task2ImageSchema {
    return Task2ImageSchema(
        "kiuwyBng-ao", "2021-07-22T14:03:40-04:00", "2021-07-25T04:48:01-04:00",
        "2021-07-25T04:48:01-04:00", 4000, 6000, "#a6a6a6", "LJFYPxxuE29FW?jZMxWV~qNHaxRi",
        null, "white and brown wooden chairs and table", getImageUrlSchema(), getLinksSchema(),
        emptyList(), 10, false, emptyList(), getSponsorshipSchema(), getUserSchema()
    )
}

private fun getImageUrlSchema(): UrlsSchema {
    return UrlsSchema(
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1",
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?crop=entropy&cs=srgb&fm=jpg&ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1&q=85",
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1&q=80&w=1080",
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1&q=80&w=400",
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1&q=80&w=200"
    )
}

private fun getLinksSchema(): LinksSchema {
    return LinksSchema(
        "https://api.unsplash.com/photos/kiuwyBng-ao",
        "https://unsplash.com/photos/kiuwyBng-ao",
        "https://unsplash.com/photos/kiuwyBng-ao/download",
        "https://api.unsplash.com/photos/kiuwyBng-ao/download?ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ"
    )
}

private fun getSponsorshipSchema(): SponsorshipSchema? {
    return null
}

private fun getUserSchema(): UserSchema {
    return UserSchema(
        "zYw2OJ152h8", "2021-07-25T04:58:45-04:00", "heftiba",
        "Toa Heftiba", "Toa", "Heftiba", "toaheftiba",
        "http://heftiba.co.uk/",
        "ᴘʀᴏᴅᴜᴄᴛ | ꜰᴏᴏᴅ | ʟɪꜰᴇꜱᴛʏʟᴇ ᴘʜᴏᴛᴏɢʀᴀᴘʜᴇʀ • ᴀ ꜰᴀɴ ᴏꜰ ᴏᴅᴅ ᴛʜɪɴɢꜱ ᴀɴᴅ ɢᴏᴏᴅ ʜᴜᴍᴏᴜʀ.",
        "UK", "heftiba.co.uk",
        39, 2455, 2619, true, forHire = true
    )
}

fun getTask2ImageList(): ArrayList<Task2Image> {
    return arrayListOf(
        getTask2Image(),
        getTask2Image(),
        getTask2Image(),
        getTask2Image()
    )
}

private fun getTask2Image(): Task2Image {
    return Task2Image(
        "kiuwyBng-ao", "2021-07-22T14:03:40-04:00", "2021-07-25T04:48:01-04:00",
        "2021-07-25T04:48:01-04:00", 4000, 6000, "#a6a6a6", "LJFYPxxuE29FW?jZMxWV~qNHaxRi",
        "", "white and brown wooden chairs and table", getImageUrl(), getLinks(),
        emptyList(), 10, false, emptyList(), getSponsorship(), getUser()
    )
}

private fun getImageUrl(): Urls {
    return Urls(
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1",
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?crop=entropy&cs=srgb&fm=jpg&ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1&q=85",
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1&q=80&w=1080",
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1&q=80&w=400",
        "https://images.unsplash.com/photo-1626976999757-275f947ba76b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ&ixlib=rb-1.2.1&q=80&w=200"
    )
}

private fun getLinks(): Links {
    return Links(
        "https://api.unsplash.com/photos/kiuwyBng-ao",
        "https://unsplash.com/photos/kiuwyBng-ao",
        "https://unsplash.com/photos/kiuwyBng-ao/download",
        "https://api.unsplash.com/photos/kiuwyBng-ao/download?ixid=MnwyNDkwNjh8MHwxfGFsbHwyfHx8fHx8Mnx8MTYyNzIwMzY0MQ"
    )
}

private fun getSponsorship(): Sponsorship {
    return Sponsorship(
        emptyList(),
        "",
        ""
    )
}

private fun getUser(): User {
    return User(
        "zYw2OJ152h8", "2021-07-25T04:58:45-04:00", "heftiba",
        "Toa Heftiba", "Toa", "Heftiba", "toaheftiba",
        "http://heftiba.co.uk/",
        "ᴘʀᴏᴅᴜᴄᴛ | ꜰᴏᴏᴅ | ʟɪꜰᴇꜱᴛʏʟᴇ ᴘʜᴏᴛᴏɢʀᴀᴘʜᴇʀ • ᴀ ꜰᴀɴ ᴏꜰ ᴏᴅᴅ ᴛʜɪɴɢꜱ ᴀɴᴅ ɢᴏᴏᴅ ʜᴜᴍᴏᴜʀ.",
        "UK", "heftiba.co.uk",
        39, 2455, 2619, true, forHire = true
    )
}



