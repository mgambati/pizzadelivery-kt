package Entity

import javax.persistence.*

@Entity
@Table(name = "Address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int = 0,
    var number: String = "",
    var street: String = "",
    var district: String = "",
    var city: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null
)