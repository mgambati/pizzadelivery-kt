package schema

import org.jetbrains.exposed.dao.IntIdTable

object CustomersTable : IntIdTable() {
    val name = varchar("name", 255)
    val phone = varchar("phone", 13) // Formato: XX 9XXXX-XXXX
}