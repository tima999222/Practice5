package scanners

import exceptions.ValidationException
import validation.EntityValidatorInterface
import validation.isPropertyValid

class StringScanner(stringValidator: EntityValidatorInterface<String>) : ScannerInterface<String> {
    private val _stringValidator = stringValidator

    override fun scanEntity(): String {
        val str = readlnOrNull()

        if (_stringValidator.validate(str))
            return str!!


        throw ValidationException("string is null or empty")
    }

}