import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.dev29.tictactoe.App

fun main() = application {
    Window(
        title = "TicTacToe",
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
