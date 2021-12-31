package com.retail.store.service

import com.retail.store.model.Item
import com.retail.store.model.UserType
import java.math.BigDecimal

interface RetailStoreDiscountService {

    fun discount(userType: UserType, item: Item): BigDecimal

}