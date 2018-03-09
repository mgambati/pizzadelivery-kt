package controller

import entity.Customer
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Alert
import javafx.scene.control.TextField
import org.jetbrains.exposed.sql.transactions.transaction
import util.ViewUtils

class CustomersEditController : InitializeByData<Customer>(){
    @FXML
    private lateinit var nameField: TextField

    @FXML
    private lateinit var phoneField: TextField

    private var customer: Customer? = null;

    override fun onDataReceive (customer: Customer) {
        this.customer = customer
        nameField.text = customer.name
        phoneField.text = customer.phone
    }

    fun onSave() {
        try {
            transaction {
                customer?.name = nameField.text
                customer?.phone = phoneField.text
            }

            ViewUtils.loadAndSwitchView("customers_index")
        } catch (e: Exception) {
            val alert = Alert(Alert.AlertType.ERROR)
            alert.title = "Cliente não salvo"
            alert.headerText = "Verifique o formulário."
            alert.show()
        }

    }

}