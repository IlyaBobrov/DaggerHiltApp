package com.baseapp.base_ui_kit.forms

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class FieldStatus { ERROR, DEFAULT, INCORRECT }

fun FieldStatus.boolean(): Boolean {
    return this != FieldStatus.DEFAULT
}

interface FieldsClassInterface

interface FieldInterface {
    val _value: String
    val _fieldStatus: FieldStatus
    fun copy(value: String = _value, fieldStatus: FieldStatus = _fieldStatus): FieldInterface
}

@Parcelize
class DefaultFields : Parcelable, FieldsClassInterface {

    @Parcelize
    class Empty : Parcelable, FieldInterface {
        override val _value: String = ""
        override val _fieldStatus: FieldStatus = FieldStatus.DEFAULT
        override fun copy(value: String, fieldStatus: FieldStatus): FieldInterface {
            return Empty()
        }
    }

    @Parcelize
    class Email(
        val value: String = "",
        val fieldStatus: FieldStatus = FieldStatus.DEFAULT
    ) : Parcelable, FieldInterface {
        override val _value: String = value
        override val _fieldStatus: FieldStatus = fieldStatus
        override fun copy(value: String, fieldStatus: FieldStatus): FieldInterface {
            return Email(value = value, fieldStatus = fieldStatus)
        }
    }

    @Parcelize
    class Surname(
        val value: String = "",
        val fieldStatus: FieldStatus = FieldStatus.DEFAULT
    ) : Parcelable, FieldInterface {
        override val _value: String = value
        override val _fieldStatus: FieldStatus = fieldStatus
        override fun copy(value: String, fieldStatus: FieldStatus): FieldInterface {
            return Surname(value = value, fieldStatus = fieldStatus)
        }
    }

    @Parcelize
    class Name(
        val value: String = "",
        val fieldStatus: FieldStatus = FieldStatus.DEFAULT
    ) :
        Parcelable, FieldInterface {
        override val _value: String = value
        override val _fieldStatus: FieldStatus = fieldStatus
        override fun copy(value: String, fieldStatus: FieldStatus): FieldInterface {
            return Name(value = value, fieldStatus = fieldStatus)
        }
    }

    @Parcelize
    class Patronymic(
        val value: String = "",
        val fieldStatus: FieldStatus = FieldStatus.DEFAULT
    ) : Parcelable, FieldInterface {
        override val _value: String = value
        override val _fieldStatus: FieldStatus = fieldStatus
        override fun copy(value: String, fieldStatus: FieldStatus): FieldInterface {
            return Patronymic(value = value, fieldStatus = fieldStatus)
        }
    }

    @Parcelize
    class Phone(
        val value: String = "",
        val fieldStatus: FieldStatus = FieldStatus.DEFAULT
    ) : Parcelable, FieldInterface {
        override val _value: String = value
        override val _fieldStatus: FieldStatus = fieldStatus
        override fun copy(value: String, validState: FieldStatus): FieldInterface {
            return Phone(value = value, fieldStatus = fieldStatus)
        }
    }
}