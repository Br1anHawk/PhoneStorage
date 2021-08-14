package com.example.phonestorage

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "smartphones")
data class SmartPhone(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "vendor")
    var vendor: String = DATA_CLASS_STRING_TYPE_INIT,

    @ColumnInfo(name = "model")
    var model: String = DATA_CLASS_STRING_TYPE_INIT,

    @ColumnInfo(name = "os")
    var os: String = DATA_CLASS_STRING_TYPE_INIT,

    @ColumnInfo(name = "ram")
    var ram: Byte = DATA_CLASS_BYTE_TYPE_INIT,

    @ColumnInfo(name = "flash")
    var flash: Short = DATA_CLASS_SHORT_TYPE_INIT,

    @ColumnInfo(name = "screen")
    var screen: Float = DATA_CLASS_FLOAT_TYPE_INIT,

    @ColumnInfo(name = "display")
    var display: String = DATA_CLASS_STRING_TYPE_INIT,

    @ColumnInfo(name = "camera")
    var camera: Short = DATA_CLASS_SHORT_TYPE_INIT,
): Parcelable