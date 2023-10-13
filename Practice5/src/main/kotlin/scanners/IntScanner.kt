package scanners

import exceptions.ValidationException
import validation.EntityValidatorInterface

class IntScanner(intValidation: EntityValidatorInterface<Int>) : ScannerInterface<Int> {
    private val _intValidation = intValidation

    override fun scanEntity() : Int {
        val id = readlnOrNull()?.toIntOrNull()

        if (_intValidation.validate(id))
            return id!!

        throw ValidationException("number is null")

    }
}