package validation

class StringValidator : EntityValidatorInterface<String> {
    override fun validate(entity: String?): Boolean {
        if (entity == null) {
            return false
        }

        return entity.isNotBlank() && entity.isNotEmpty()
    }
}