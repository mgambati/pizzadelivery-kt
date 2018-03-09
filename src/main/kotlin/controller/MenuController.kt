package controller

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.AnchorPane
import util.ViewUtils

class MenuController {
    @FXML
    lateinit var buttonProducts: Button

    @FXML
    lateinit var buttonCustomers: Button

    @FXML
    lateinit var buttonOrders: Button

    @FXML
    fun switchToProducts() {
        val label = Label("Produtos")
        MainController.switchView(label)
    }

    @FXML
    fun switchToCustomers() {
        ViewUtils.loadAndSwitchView("customers_index")
    }

    @FXML
    fun switchToOrders() {
        println("Menu: Pedidos clicado")
    }
}