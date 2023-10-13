package validation

interface EntityValidatorInterface<T> {
    fun validate(entity: T?) : Boolean
}