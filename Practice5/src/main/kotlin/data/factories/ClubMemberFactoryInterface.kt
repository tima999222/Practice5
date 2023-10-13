package data.factories

import data.ClubMember

interface ClubMemberFactoryInterface {
    fun createClubMember(id: Int,
                         surname: String,
                         name: String, patronymic: String,
                         bicycleType: String,
                         exp: Double) : ClubMember
}