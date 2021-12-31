package com.retail.store.service.impl

import com.retail.store.model.User
import com.retail.store.service.CrudService
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class UserService : CrudService<User> {

    override fun getAll(): List<User> {
        return USER_CACHE.values.toList()
    }

    override fun create(t: User): User {
        if (USER_CACHE[t.name] == null) {
            USER_CACHE[t.name] = t
        }
        return t
    }

    override fun update(t: User): User {
        USER_CACHE[t.name] ?: throw IllegalArgumentException("User Not found")
        USER_CACHE.remove(t.name)
        USER_CACHE[t.name] = t
        return t
    }

    override fun delete(name: String) {
        USER_CACHE[name] ?: throw IllegalArgumentException("User Not found")
        USER_CACHE.remove(name)
    }

    override fun getByName(name: String): User =
        USER_CACHE[name] ?: throw IllegalArgumentException("User Not found")

    companion object {
        val USER_CACHE = ConcurrentHashMap<String, User>()
    }


}