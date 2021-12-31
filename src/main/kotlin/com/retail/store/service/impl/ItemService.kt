package com.retail.store.service.impl

import com.retail.store.model.Item
import com.retail.store.service.CrudService
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class ItemService : CrudService<Item> {

    override fun getAll(): List<Item> {
        return ITEM_CACHE.values.toList()
    }

    override fun create(t: Item): Item {
        if (ITEM_CACHE[t.name] == null) {
            ITEM_CACHE[t.name] = t
        }
        return t
    }

    override fun update(t: Item): Item {
        ITEM_CACHE[t.name] ?: throw IllegalArgumentException("Item Not found")
        ITEM_CACHE.remove(t.name)
        ITEM_CACHE[t.name] = t
        return t
    }

    override fun delete(name: String) {
        ITEM_CACHE[name] ?: throw IllegalArgumentException("Item Not found")
        ITEM_CACHE.remove(name)
    }

    override fun getByName(name: String): Item =
        ITEM_CACHE[name] ?: throw IllegalArgumentException("Item Not found")

    companion object {
        val ITEM_CACHE = ConcurrentHashMap<String, Item>()
    }

}