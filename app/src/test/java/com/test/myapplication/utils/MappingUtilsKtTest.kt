package com.test.myapplication.utils

import com.test.myapplication.sampledata.getTask2ImageList
import com.test.myapplication.sampledata.getTask2ImageSchemaList
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MappingUtilsKtTest {

    @Test
    fun mapTask2ImageSchemaToTask2Image_task2ImageSchemaList_task2ImageListReturned() {
        val task2ImageList = mapTask2ImageSchemaToTask2Image(getTask2ImageSchemaList())
        assertThat(task2ImageList, `is`(getTask2ImageList()))
    }

    @Test
    fun mapTask2ImageSchemaToTask2Image_task2ImageSchemaEmptyList_emptyListReturned() {
        val task2ImageList = mapTask2ImageSchemaToTask2Image(emptyList())
        assertThat(task2ImageList, `is`(arrayListOf()))
    }

    @Test
    fun mapTask2ImageSchemaToTask2Image_null_emptyListReturned() {
        val task2ImageList = mapTask2ImageSchemaToTask2Image(null)
        assertThat(task2ImageList, `is`(arrayListOf()))
    }

}