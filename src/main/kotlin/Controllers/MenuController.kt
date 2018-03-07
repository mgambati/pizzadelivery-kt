package Controllers

import javafx.fxml.FXML
import javafx.scene.control.Button

class MenuController {
    @FXML
    lateinit var buttonProducts: Button

    @FXML
    lateinit var buttonCustomers: Button

    @FXML
    lateinit var buttonOrders: Button

    @FXML
    fun switchToProducts() {
        println("Menu: Produtos clicado")
    }

    @FXML
    fun switchToCustomers() {
        println("Menu: Clientes clicado")
    }

    @FXML
    fun switchToOrders() {
        println("Menu: Pedidos clicado")
    }
}