package validation

fun <T> T.isPropertyValid(valid: (T) -> Boolean) : Boolean {
    return valid(this)
}
