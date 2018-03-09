package util

import schema.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Inicia a conexão com o banco e cria as tabelas necessárias.
 *
 * @param databaseName nome do banco de dados
 * @param url endereço jdbc do banco
 * @param driver driver a ser usado pelo jdbc
 */
fun setupDatabase(
    databaseName: String,
    url: String = "jdbc:postgresql://localhost",
    driver: String = "org.postgresql.Driver",
    user: String = "root",
    password: String = "root"
) {
    // Inicia a conexão
    Database.connect("$url/$databaseName", driver, user, password)

    // Cria o schemas para cada entidade
    transaction {

        SchemaUtils.create(
            ProductsTable,
            CustomersTable,
            OrdersTable,
            OrdersProductsTable,
            AddressesTable
        )
    }
}