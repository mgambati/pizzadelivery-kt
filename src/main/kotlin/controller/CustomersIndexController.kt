package controller

import entity.Customer
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import org.jetbrains.exposed.sql.transactions.transaction
import util.ViewUtils
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

class CustomersIndexController : Initializable {
    @FXML
    private lateinit var table: TableView<Customer>

    @FXML
    private lateinit var nameColumn: TableColumn<Customer, String>

    @FXML
    private lateinit var phoneColumn: TableColumn<Customer, String>


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        nameColumn.cellValueFactory = PropertyValueFactory("name")
        phoneColumn.cellValueFactory = PropertyValueFactory("phone")

        table.items = findAllCustomers()
    }

    private fun findAllCustomers(): ObservableList<Customer> {

        val customers: MutableCollection<Customer> = ArrayList()
        transaction {
            Customer.all().toCollection(customers)
        }

        return FXCollections.observableArrayList<Customer>(customers)
    }

    fun onNewCustomer() {
        ViewUtils.loadAndSwitchView("customers_new")
    }

    fun onDeleteCustomer() {
        val customer = table.selectionModel.selectedItem

        if (customer != null) {
            table.items.remove(customer)
            transaction {
                customer.delete()
            }
        }
    }

    fun onEditCustomer() {
        val customer = table.selectionModel.selectedItem

        ViewUtils.loadAndSwitchView<
            CustomersEditController,
            Customer>("customers_edit", customer)
    }

}