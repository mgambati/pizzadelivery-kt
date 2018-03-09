import controller.MainController
import util.setupDatabase
import javafx.application.Application
import java.net.URL

class PizzaDelivery {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Iniciando conexão com banco.")
            setupDatabase("pizzadelivery", user = "postgres", password = "secret")
            println("Conexão iniciada.")
            Application.launch(MainController::class.java, *args)
        }
    }

    fun getResource(path: String) : URL {
        return PizzaDelivery::class.java.getResource(path)
    }
}