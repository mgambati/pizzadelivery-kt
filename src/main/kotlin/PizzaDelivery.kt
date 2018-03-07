import Entity.Address
import Entity.Customer
import Entity.Order
import Entity.Product
import Util.setupDatabase
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import java.math.BigDecimal

class PizzaDelivery {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("oi!")
            setupDatabase("pizzadelivery", user = "postgres", password = "secret")

            transaction {
                val ciclano = Customer.new {
                    name = "Ciclano"
                    phone = "65 99362-3434"
                }
                val end1 = Address.new {
                    number = 232
                    street = "Rua Dr. Euricles"
                    district = "Jardim Guanabara"
                    city = "Cuiabá"
                    state = "MT"
                    customer = ciclano
                }

                val pizza = Product.new {
                    name = "Pizza de calabresa"
                    stock = 100
                    value = BigDecimal.valueOf(12.3)
                }

                val order = Order.new {
                    value = BigDecimal.valueOf(23)
                    discount = BigDecimal.valueOf(0)
                    annotations = ""
                    customer = ciclano
                    createdAt = DateTime.now()
                    deliveredAt = null
                }

                order.products = SizedCollection(listOf(pizza))
            }
        }
    }
}