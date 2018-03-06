package Entity

import javax.persistence.*

@Entity
@Table(name = "Address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int,
    var number: String,
    var street: String,
    var district: String,
    var city: String
)