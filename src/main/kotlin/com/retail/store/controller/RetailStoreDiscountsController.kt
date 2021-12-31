package com.retail.store.controller

import com.retail.store.model.Item
import com.retail.store.model.User
import com.retail.store.service.CrudService
import com.retail.store.service.RetailStoreDiscountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/api/discount")
class RetailStoreDiscountsController(
    val retailStoreDiscountsService: RetailStoreDiscountService,
    val userService: CrudService<User>,
    val itemService: CrudService<Item>
) {

    @GetMapping("/{userName}/{itemName}")
    fun getDiscountByUserType(
        @PathVariable userName: String,
        @PathVariable itemName: String
    ): ResponseEntity<BigDecimal> {
        val userByName = this.userService.getByName(userName)
        val itemByName = this.itemService.getByName(itemName)
        return ResponseEntity(retailStoreDiscountsService.discount(userByName.userType, itemByName), HttpStatus.OK)
    }
}