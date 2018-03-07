import Controllers.MainController
import javafx.application.Application
import java.net.URL

class PizzaDelivery {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Oi!")
            Application.launch(MainController::class.java, *args)
        }
    }

    fun getResource(path: String) : URL {
        return PizzaDelivery::class.java.getResource(path)
    }
}