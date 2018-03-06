package Repository

import Entity.Customer

class CustomerRepository : CrudRepository<Customer, Int>() {
    override fun getDomainClass(): Class<Customer> = Customer::class.java
}