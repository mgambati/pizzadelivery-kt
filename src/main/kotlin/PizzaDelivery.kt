import controller.MainController
import javafx.application.Application
import util.setupDatabase

/**
 * Algoritimos 3
 * Alunos: Matheus Gambati e Gabriel Gutierrez
 * Repositorio: https://github.com/mgambati/pizzadelivery-kt
 */
class PizzaDelivery {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Iniciando conexão com banco.")

            // Basta colocar qual banco e as credenciais usar
            setupDatabase("pizzadelivery", user = "postgres", password = "secret")
            println("Conexão iniciada.")

            // Instancia MainController
            Application.launch(MainController::class.java, *args)
        }
    }
}