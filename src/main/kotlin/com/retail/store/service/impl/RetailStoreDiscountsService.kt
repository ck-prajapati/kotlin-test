package com.retail.store.service.impl

import com.retail.store.model.Item
import com.retail.store.model.ItemType.GROCERY
import com.retail.store.model.ItemType.NON_GROCERY
import com.retail.store.model.UserType
import com.retail.store.model.UserType.*
import com.retail.store.service.RetailStoreDiscountService
import com.retail.store.service.discount.AffiliateDiscountService
import com.retail.store.service.discount.HundredBillDiscountService
import com.retail.store.service.discount.OldCustomerDiscountService
import com.retail.store.service.discount.StoreEmployeeDiscountService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class RetailStoreDiscountsService(
    private val affiliateDiscountService: AffiliateDiscountService,
    private val hundredBillDiscountService: HundredBillDiscountService,
    private val oldCustomerDiscountService: OldCustomerDiscountService,
    private val storeEmployeeDiscountService: StoreEmployeeDiscountService
) : RetailStoreDiscountService {

    override fun discount(userType: UserType, item: Item): BigDecimal {
        return when (item.type) {
            GROCERY -> item.price
            NON_GROCERY -> when (userType) {
                STORE -> storeEmployeeDiscountService.calculateDiscount(item)
                AFFILIATE -> affiliateDiscountService.calculateDiscount(item)
                REGULAR -> oldCustomerDiscountService.calculateDiscount(item)
                NORMAL -> hundredBillDiscountService.calculateDiscount(item)
            }
        }
    }

}