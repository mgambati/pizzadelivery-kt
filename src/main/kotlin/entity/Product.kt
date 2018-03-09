package entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import schema.OrdersProductsTable
import schema.ProductsTable

class Product(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Product>(ProductsTable)

    var name by ProductsTable.name
    var stock by ProductsTable.stock
    var value by ProductsTable.value

    val orders by Order via OrdersProductsTable
}