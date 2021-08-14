package com.example.phonestorage

const val DATA_CLASS_STRING_TYPE_INIT = "-"
const val DATA_CLASS_BYTE_TYPE_INIT = (-1).toByte()
const val DATA_CLASS_SHORT_TYPE_INIT = (-1).toShort()
const val DATA_CLASS_FLOAT_TYPE_INIT = -1f

const val DISPLAY_IF_PROPERTY_IS_INVALID = "-"
const val DISPLAY_GB = "GB"
const val DISPLAY_INCHES = "\'\'"

fun isValid(property: Number): Boolean {
    return property.toShort() >= 0
}