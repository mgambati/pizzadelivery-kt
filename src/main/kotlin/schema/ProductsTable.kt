package schema

import org.jetbrains.exposed.dao.IntIdTable

object ProductsTable : IntIdTable() {
    val name = varchar("name", 255)
    val value = decimal("value", 7, 3)
    val stock = integer("stock")
}
