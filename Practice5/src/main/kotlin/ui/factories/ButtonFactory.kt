package ui.factories

import ui.Button

class ButtonFactory() {
    fun CreateButton(id: Int, caption: String, action: () -> Unit) : Button {
        return Button(id, caption, action)
    }
}