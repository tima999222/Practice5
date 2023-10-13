package validation

class IntValidator : EntityValidatorInterface<Int> {
    override fun validate(entity: Int?): Boolean {
        return entity.isPropertyValid { it != null }
    }
}