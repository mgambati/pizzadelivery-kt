package util

import controller.InitializeByData
import controller.MainController
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import java.net.URL

object ViewUtils {
    fun loadAndSwitchView(viewName: String) {
        val resourceUrl: URL? = javaClass.getResource("/views/$viewName.fxml")
        val view: Node = FXMLLoader.load(resourceUrl)
        MainController.switchView(view)
    }

    fun <C : InitializeByData<D>, D> loadAndSwitchView(viewName: String, data: D) {
        val resourceUrl: URL? = javaClass.getResource("/views/$viewName.fxml")
        val loader = FXMLLoader(resourceUrl)
        val view: Node = loader.load()
        val controller: C = loader.getController()
        controller.onDataReceive(data)
        MainController.switchView(view)
    }
}