package com.retail.store.controller

import com.retail.store.model.Item
import com.retail.store.service.CrudService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/items")
class ItemsController(private val itemService: CrudService<Item>) {

    @GetMapping
    fun getAllItems(): ResponseEntity<List<Item>> {
        return ResponseEntity(itemService.getAll(), HttpStatus.OK)
    }

    @PostMapping
    fun createItem(@RequestBody item: Item): ResponseEntity<Item> {
        return ResponseEntity(itemService.create(item), HttpStatus.OK)
    }

    @PutMapping
    fun updateItem(@RequestBody item: Item): ResponseEntity<Item> {
        return ResponseEntity(itemService.update(item), HttpStatus.OK)
    }

    @DeleteMapping("/name/{name}")
    fun deleteItem(@PathVariable name: String): ResponseEntity<Void> {
        itemService.delete(name)
        return ResponseEntity(HttpStatus.OK)
    }
}