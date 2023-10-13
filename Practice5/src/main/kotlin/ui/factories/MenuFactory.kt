package ui.factories

import ui.Button
import ui.Menu

class MenuFactory {
    fun createMenu(buttonsList: List<Button>): Menu {
        return Menu(buttonsList)
    }
}