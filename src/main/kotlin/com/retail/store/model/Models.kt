package com.retail.store.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class User(val name: String, val subscriptionDate: LocalDateTime, val userType: UserType)

data class Item(val name: String, val price: BigDecimal, val type: ItemType)

enum class UserType {
    STORE,
    AFFILIATE,
    REGULAR, //OLD Customer
    NORMAL
}

enum class ItemType {
    GROCERY,
    NON_GROCERY
}