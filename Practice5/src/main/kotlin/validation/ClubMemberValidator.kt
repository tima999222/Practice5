package validation

import data.ClubMember

class ClubMemberValidator : EntityValidatorInterface<ClubMember> {
    override fun validate(entity: ClubMember?): Boolean {
        if (entity == null)
            return false

        return entity.clubMemberId.isPropertyValid { it >= 0 }
                && entity.surname.isPropertyValid { it.isNotEmpty() }
                && entity.name.isPropertyValid { it.isNotEmpty() }
                && entity.patronymic.isPropertyValid { it.isNotEmpty() }
                && entity.bicycleType.isPropertyValid { it.isNotEmpty() }
                && entity.experience.isPropertyValid { it >= 0 }
    }
}