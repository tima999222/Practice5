package data

data class ClubMember(
    var clubMemberId: Int,
    var surname: String,
    var name: String,
    var patronymic: String,
    var bicycleType: String,
    var experience: Double
) {
}