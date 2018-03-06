package Entity

import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int,
    var name: String,
    var phone: String
)