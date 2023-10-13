package printers

import data.ClubMember

interface ClubMembersPrinterInterface {
    fun printClubMembers(clubMembers: List<ClubMember>)

    fun printClubMember(clubMember: ClubMember)
}