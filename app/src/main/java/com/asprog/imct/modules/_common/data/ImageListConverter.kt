package com.asprog.imct.modules._common.data

import androidx.room.TypeConverter
import java.util.stream.Collectors


class ImageListConverter {
    @TypeConverter
    fun fromImages(images: List<String?>): String {
        return images.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toImages(data: String): List<String?> {
        return data.split(",").map { it }
    }
}