package Schema

import org.jetbrains.exposed.dao.IntIdTable

object OrdersTable : IntIdTable() {
    val value = decimal("value", 7, 3)
    val discount = decimal("discount", 7, 3)
    val annotations = text("annotations")
    val createdAt = datetime("created_at")
    val deliveredAt = datetime("delivered_at").nullable()
    val customerId = OrdersTable.reference("customer_id", CustomersTable)
}