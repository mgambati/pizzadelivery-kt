import Entity.Address
import Entity.Customer
import Repository.CustomerRepository
import util.HibernateUtil
import util.runInTransaction

class PizzaDelivery {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val customerRepository = CustomerRepository()
            val customer = Customer(name = "Name", phone = "231")
            val address = Address(
                street = "Dr. Euricles",
                district = "Gunabara",
                number = "231",
                city = "Cuiabá"
            )

            customer.addAddress(address)
            customerRepository.save(customer)
            println("Oi!")

            runInTransaction {
                println("Oi!")
                val found = customerRepository.findById(1)
                println("Nº de endereços: " +found!!.addresses.size)
                found!!.addresses.forEach { value -> println(value.street) }
            }
        }
    }
}