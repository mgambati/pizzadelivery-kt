package Entity

import Schema.OrdersProductsTable
import Schema.ProductsTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Product(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Product>(ProductsTable)

    var name by ProductsTable.name
    var stock by ProductsTable.stock
    var value by ProductsTable.value

    val orders by Order via OrdersProductsTable
}