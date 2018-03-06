package Entity

import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer(

    // Chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int = 0,

    // Nome
    var name: String = "",

    // Telefone: 65 90000-0000
    var phone: String = "",

    // Um cliente pode ter vários endereços
    @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    var addresses: MutableList<Address> = mutableListOf()
) {
    fun addAddress(address: Address) {
        addresses.add(address)
        address.customer = this
    }

    fun addAddress(addresses: Iterable<Address>) {
        for (address in addresses) {
            this.addresses.add(address)
            address.customer = this
        }
    }
}