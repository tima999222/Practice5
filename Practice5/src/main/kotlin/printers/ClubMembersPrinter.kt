package printers

import data.ClubMember

class ClubMembersPrinter : ClubMembersPrinterInterface {
    override fun printClubMembers(clubMembers: List<ClubMember>) {
        for (cm in clubMembers) {
            println("${cm.clubMemberId} ${cm.surname} ${cm.name} ${cm.patronymic} ${cm.bicycleType} ${cm.experience}")
        }
    }

    override fun printClubMember(clubMember: ClubMember) {
        println("${clubMember.clubMemberId} ${clubMember.surname} ${clubMember.name} ${clubMember.patronymic} ${clubMember.bicycleType} ${clubMember.experience}")
    }
}