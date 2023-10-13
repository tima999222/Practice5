package printers

import ui.Menu

class MenuPrinter (private var menu: Menu) : MenuPrinterInterface {
    override fun drawMenu() {
        println("================================")
        for (button in menu.buttons) {
            println("${button.buttonId}. ${button.caption}")
        }
        println("================================")
        print("press number to interact with db: ")
    }
}