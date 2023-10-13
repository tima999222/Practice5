package ui

class Menu(private var _buttons: List<Button>) {
    var buttons: List<Button>
        get() = _buttons
        private set(value) {
            _buttons = value
        }

    fun pickButton(id: Int) {
        if (!buttons.any { it.buttonId == id })
            return
        buttons[id - 1].action()
    }
}