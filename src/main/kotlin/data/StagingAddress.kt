package data

/**
 * Classe apenas para guardar dados temporários de um endereço
 */
data class StagingAddress(
    val number: Int,
    val street: String,
    val district: String,
    val city: String,
    val state: String
)