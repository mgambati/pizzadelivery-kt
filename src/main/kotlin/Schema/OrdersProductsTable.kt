package Schema

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object OrdersProductsTable : Table(name = "orders_products") {
    val orderId = reference("order_id", OrdersTable, ReferenceOption.CASCADE)
    val productId = reference("product_id", ProductsTable, ReferenceOption.CASCADE)

    init {
        index(true, orderId, productId)
    }
}