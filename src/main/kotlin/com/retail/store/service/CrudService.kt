package com.retail.store.service

interface CrudService<T> {

    fun getAll(): List<T>

    fun create(t: T): T

    fun update(t: T): T

    fun delete(name: String)

    fun getByName(name: String): T

}