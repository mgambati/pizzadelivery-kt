package Controllers

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import java.net.URL

class MainController : Application() {
    val rootView = BorderPane()
    override fun start(primaryStage: Stage?) {
        val menuUrl: URL = javaClass.classLoader.getResource("components/menu.fxml")
        val menu: AnchorPane = FXMLLoader.load(menuUrl)

//        // Carrega tela de boas vindas
//        val welcomeViewUrl: URL = javaClass.classLoader.getResource("views/welcome_view.fxml")
//        val welcomeView: AnchorPane = FXMLLoader.load(welcomeViewUrl)

        // Menu fica a esquerda e view do centro é conteúdo
        rootView.left = menu
//        rootView.center = welcomeView

        val scene = Scene(rootView, 1040.0, 600.0)

        primaryStage?.scene = scene
        primaryStage?.title = "Pizza Delivery"
        primaryStage?.show()
    }

    fun switchView(view: Node) {
        rootView.center = view
    }
}