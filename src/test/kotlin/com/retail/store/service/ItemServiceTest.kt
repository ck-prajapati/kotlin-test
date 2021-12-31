package com.retail.store.service

import com.retail.store.model.Item
import com.retail.store.model.ItemType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
class ItemServiceTest {

    @Autowired
    lateinit var crudService: CrudService<Item>

    val item = Item("Smartphone", BigDecimal(5000), ItemType.NON_GROCERY)
    val item2 = Item("Laptop", BigDecimal(10000), ItemType.NON_GROCERY)
    val updateItem = Item("Smartphone", BigDecimal(5000), ItemType.NON_GROCERY)

    @BeforeEach
    fun setUp() {
        crudService.getAll().forEach { crudService.delete(it.name) }
    }

    @Test
    fun `create item`() {
        val itemData = crudService.create(item)
        Assertions.assertEquals(item, itemData)
    }

    @Test
    fun `get Item by name`() {
        crudService.create(item)
        val itemData = crudService.getByName("Smartphone")
        Assertions.assertEquals(item, itemData)
    }

    @Test
    fun `get all items`() {
        crudService.create(item)
        crudService.create(item2)
        val itemData = crudService.getAll()
        Assertions.assertEquals(2, itemData.size)
    }

    @Test
    fun `update Item`() {
        crudService.create(item)
        val updatedData = crudService.update(updateItem)
        Assertions.assertEquals(updateItem, updatedData)
    }

    @Test
    fun `delete Item`() {
        crudService.create(item)
        val itemName = "Smartphone"
        crudService.delete(itemName)
        assertThrows<IllegalArgumentException> { crudService.getByName(itemName) }
    }
}