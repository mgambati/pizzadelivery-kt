package entity

import schema.AddressesTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Address(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Address>(AddressesTable)

    var number by AddressesTable.number
    var street by AddressesTable.street
    var district by AddressesTable.district
    var city by AddressesTable.city
    var state by AddressesTable.state

    var customer by Customer referencedOn AddressesTable.customerId
}