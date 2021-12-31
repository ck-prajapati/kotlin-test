package com.retail.store.service.discount

import com.retail.store.model.Item
import com.retail.store.service.DiscountService
import com.retail.store.utils.Utils
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class OldCustomerDiscountService : DiscountService {

    override fun calculateDiscount(item: Item): BigDecimal {
        val percentage = Utils.PERCENTAGE
        val eligibleDiscount = Utils.DISCOUNT_5
        val itemPrice = item.price
        val itemDiscountablePrice = itemPrice.multiply(eligibleDiscount).divide(percentage)
        return itemPrice.subtract(itemDiscountablePrice)
    }
}