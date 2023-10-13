package data.factories

import data.ClubMember
import exceptions.ValidationException
import validation.EntityValidatorInterface

class ClubMemberFactory(validator: EntityValidatorInterface<ClubMember>) : ClubMemberFactoryInterface {
    private val clubMemberValidator = validator

    override fun createClubMember(id: Int,
                                  surname: String,
                                  name: String, patronymic: String,
                                  bicycleType: String,
                                  exp: Double) : ClubMember {
        val clubMember = ClubMember(id, surname, name, patronymic, bicycleType, exp)
        if (!clubMemberValidator.validate(clubMember))
            throw ValidationException("Club member didn't pass validation")

        return clubMember
    }
}