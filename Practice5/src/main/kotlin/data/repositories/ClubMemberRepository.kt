package data.repositories

import exceptions.NotFoundClubMemberException
import data.ClubMember
import data.DatabaseContext
import data.factories.DatabaseContextFactory

class ClubMemberRepository(databaseContextFactory: DatabaseContextFactory) : ClubMemberRepositoryInterface{
    private val _context: DatabaseContext

    init {
        _context = databaseContextFactory.createContext()
    }

    override fun addClubMember(item: ClubMember) {
        _context.clubMembers.add(item)
    }

    override fun deleteClubMember(item: ClubMember) {
        _context.clubMembers.remove(item)
    }

    override fun getClubMembers() : List<ClubMember> {
        return _context.clubMembers
    }

    override fun getClubMemberById(id: Int) : ClubMember {
        val item = _context.clubMembers.find { it.clubMemberId == id }
        if (item != null) return item

        throw NotFoundClubMemberException("Can't find club member by id")
    }

    override fun sortClubMembers(arg: Comparator<ClubMember>): List<ClubMember> {
        return _context.clubMembers.sortedWith(arg)
    }

    override fun findClubMembers(arg: (ClubMember) -> Boolean): List<ClubMember> {
        return _context.clubMembers.filter(arg)
    }
}