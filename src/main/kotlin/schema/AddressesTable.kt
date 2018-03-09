package schema

import org.jetbrains.exposed.dao.IntIdTable

object AddressesTable : IntIdTable() {
    val number = integer("number")
    val street = varchar("street", 255)
    val district = varchar("district", 255)
    val city = varchar("city", 255)
    val state = varchar("state", 2)

    val customerId = reference("customer_id", CustomersTable)
}