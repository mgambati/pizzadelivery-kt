package Entity

import Schema.AddressesTable
import Schema.CustomersTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Customer(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Customer>(CustomersTable)

    var name by CustomersTable.name
    var phone by CustomersTable.phone

    val addresses by Address referrersOn AddressesTable.customerId
}
