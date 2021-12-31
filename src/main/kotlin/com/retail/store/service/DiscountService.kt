package com.retail.store.service

import com.retail.store.model.Item
import java.math.BigDecimal

interface DiscountService {

    fun calculateDiscount(item: Item): BigDecimal
}