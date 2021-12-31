package com.retail.store.service

import com.retail.store.model.Item
import com.retail.store.model.ItemType
import com.retail.store.model.UserType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
    class RetailDiscountTest {

    @Autowired
    lateinit var retailStoreDiscountsService: RetailStoreDiscountService

    val item = Item("ABC", BigDecimal(5000), ItemType.NON_GROCERY)
    val itemNoDiscount = Item("ABC", BigDecimal(50), ItemType.NON_GROCERY)
    val groceryItem = Item("ABC", BigDecimal(500), ItemType.GROCERY)


    @Test
    fun `return discount to store user`() {
        val discount = retailStoreDiscountsService.discount(UserType.STORE, item)
        assertEquals(BigDecimal(3500), discount)
    }

    @Test
    fun `return discount to affiliate`() {
        val discount = retailStoreDiscountsService.discount(UserType.AFFILIATE, item)
        assertEquals(BigDecimal(4500), discount)
    }

    @Test
    fun `return discount to old customer`() {
        val discount = retailStoreDiscountsService.discount(UserType.REGULAR, item)
        assertEquals(BigDecimal(4750), discount)
    }

    @Test
    fun `return discount on more than hundred bill for normal customer`() {
        val discount = retailStoreDiscountsService.discount(UserType.NORMAL, item)
        assertEquals(BigDecimal(4755), discount)
    }

    @Test
    fun `return no discount on less than hundred bill for normal user`() {
        val discount = retailStoreDiscountsService.discount(UserType.NORMAL, itemNoDiscount)
        assertEquals(BigDecimal(50), discount)
    }

    @Test
    fun `return no discount on for grocery bill`() {
        val discount = retailStoreDiscountsService.discount(UserType.NORMAL, groceryItem)
        assertEquals(BigDecimal(500), discount)
    }
}