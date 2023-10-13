package scanners

import data.ClubMember
import data.factories.ClubMemberFactoryInterface
import exceptions.ValidationException
import validation.isPropertyValid

class ClubMemberScanner(clubMemberFactory: ClubMemberFactoryInterface) : ScannerInterface<ClubMember> {
    private val _clubMemberFactory = clubMemberFactory

    override fun scanEntity()  : ClubMember {
        print("Enter id: ")
        val clubMemberId = readln().toInt()
        print("Enter surname: ")
        val surname = readln()
        print("Enter name: ")
        val name = readln()
        print("Enter patronymic: ")
        val patronymic = readln()
        print("Enter bicycle type: ")
        val bicycleType = readln()
        print("Enter experience: ")
        val experience = readln().toDouble()

        return _clubMemberFactory.createClubMember(clubMemberId,
            surname,
            name,
            patronymic,
            bicycleType,
            experience)
    }
}
