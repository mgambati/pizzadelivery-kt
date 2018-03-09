package controller

import data.StagingAddress
import entity.Address
import entity.Customer
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Alert
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.PropertyValueFactory
import org.jetbrains.exposed.sql.transactions.transaction
import util.ViewUtils
import java.net.URL
import java.util.*

class CustomersNewController : Initializable {
    // Fields para cliente
    @FXML
    private lateinit var nameField: TextField
    @FXML
    private lateinit var phoneField: TextField

    // Fields para endereço
    @FXML
    private lateinit var numberField: TextField
    @FXML
    private lateinit var streetField: TextField
    @FXML
    private lateinit var districtField: TextField
    @FXML
    private lateinit var cityField: TextField
    @FXML
    private lateinit var stateField: TextField

    // Tabela de endereços
    @FXML
    private lateinit var table: TableView<StagingAddress>
    @FXML
    private lateinit var numberColumn: TableColumn<StagingAddress, Int>
    @FXML
    private lateinit var streetColumn: TableColumn<StagingAddress, String>
    @FXML
    private lateinit var districtColumn: TableColumn<StagingAddress, String>

    private val addressesStaging = FXCollections.observableArrayList<StagingAddress>(ArrayList())

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        numberColumn.cellValueFactory = PropertyValueFactory("number")
        streetColumn.cellValueFactory = PropertyValueFactory("street")
        districtColumn.cellValueFactory = PropertyValueFactory("district")

        table.items = addressesStaging
    }

    fun onAddressSave() {
        val address = StagingAddress(
            numberField.text.toInt(),
            streetField.text,
            districtField.text,
            cityField.text,
            stateField.text
        )

        addressesStaging.add(address)
    }

    fun onSave() {
        try {
            transaction {
                val newCustomer = Customer.new {
                    name = nameField.text
                    phone = phoneField.text
                }

                for (ad in addressesStaging) {
                    Address.new {
                        number = ad.number
                        street = ad.street
                        district = ad.district
                        city = ad.city
                        state = ad.state.slice(0 .. 1)
                        customer = newCustomer
                    }
                }
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