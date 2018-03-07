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
    companion object {
        val rootView = BorderPane()
        fun switchView(view: Node) {
            rootView.center = view
        }
    }
    override fun start(primaryStage: Stage?) {
        val menuUrl: URL = javaClass.getResource("/components/menu.fxml")
        val menu: AnchorPane = FXMLLoader.load(menuUrl)

        // Carrega tela de boas vindas
        val welcomeViewUrl: URL = javaClass.getResource("/views/welcome.fxml")
        val welcomeView: AnchorPane = FXMLLoader.load(welcomeViewUrl)

        // Menu fica a esquerda e view do centro é conteúdo
        rootView.left = menu
        rootView.center = welcomeView

        val scene = Scene(rootView, 1040.0, 600.0)

        primaryStage?.scene = scene
        primaryStage?.title = "Pizza Delivery"
        primaryStage?.show()
    }
}