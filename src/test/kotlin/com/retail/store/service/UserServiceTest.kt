package com.retail.store.service

import com.retail.store.model.User
import com.retail.store.model.UserType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class UserServiceTest {

    @Autowired
    lateinit var crudService: CrudService<User>

    val user = User("Arjun", LocalDateTime.now(), UserType.REGULAR)
    val user2 = User("Karan", LocalDateTime.now(), UserType.STORE)

    @BeforeEach
    fun setUp() {
        crudService.getAll().forEach { crudService.delete(it.name) }
    }

    @Test
    fun `create user`() {
        val userData = crudService.create(user)
        Assertions.assertEquals(user, userData)
    }

    @Test
    fun `get user by name`() {
        crudService.create(user)
        val getData = crudService.getByName("Arjun")
        Assertions.assertEquals(user, getData)
    }

    @Test
    fun `get all users`() {
        crudService.create(user)
        crudService.create(user2)
        val getData = crudService.getAll()
        Assertions.assertEquals(2, getData.size)
    }

    @Test
    fun `update user`() {
        crudService.create(user)
        val updateUser = User("Arjun", LocalDateTime.now(), UserType.NORMAL)
        val updatedData = crudService.update(updateUser)
        Assertions.assertEquals(updateUser, updatedData)
    }

    @Test
    fun `delete user`() {
        crudService.create(user)
        val userName = "Arjun"
        crudService.delete(userName)
        assertThrows<IllegalArgumentException> { crudService.getByName(userName) }
    }
}