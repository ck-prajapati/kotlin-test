package com.retail.store.service.discount

import com.retail.store.model.Item
import com.retail.store.service.DiscountService
import com.retail.store.utils.Utils
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class HundredBillDiscountService : DiscountService {

    override fun calculateDiscount(item: Item): BigDecimal {
        val percentage = Utils.PERCENTAGE
        val eligibleDiscount = Utils.DISCOUNT_5
        val notDiscountable = Utils.NON_DISCOUNTABLE
        val itemPrice = item.price
        return if (itemPrice >= BigDecimal(100)) {
            val itemDiscountablePrice =
                (itemPrice.subtract(notDiscountable)).multiply(eligibleDiscount).divide(percentage)
            (itemPrice).subtract(itemDiscountablePrice)
        } else {
            itemPrice
        }
    }
}