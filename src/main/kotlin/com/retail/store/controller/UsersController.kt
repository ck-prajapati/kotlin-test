package com.retail.store.controller

import com.retail.store.model.User
import com.retail.store.service.CrudService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UsersController(private val userService: CrudService<User>) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity(userService.getAll(), HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(userService.create(user), HttpStatus.OK)
    }

    @PutMapping
    fun updateUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(userService.update(user), HttpStatus.OK)
    }

    @DeleteMapping("/name/{name}")
    fun deleteUser(@PathVariable name: String): ResponseEntity<Void> {
        userService.delete(name)
        return ResponseEntity(HttpStatus.OK)
    }
}