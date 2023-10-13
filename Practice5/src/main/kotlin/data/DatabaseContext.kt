package data

class DatabaseContext() : DataBaseContextInterface {
    var clubMembers = mutableListOf<ClubMember>()
}