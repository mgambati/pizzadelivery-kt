package Entity

import Schema.OrdersProductsTable
import Schema.OrdersTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Order(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Order>(OrdersTable)

    var value by OrdersTable.value
    var discount by OrdersTable.discount
    var annotations by OrdersTable.annotations
    var createdAt by OrdersTable.createdAt
    var deliveredAt by OrdersTable.deliveredAt

    var products by Product via OrdersProductsTable
    var customer by Customer referencedOn OrdersTable.customerId
}