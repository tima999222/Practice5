import data.ClubMember
import data.factories.ClubMemberFactory
import data.factories.DatabaseContextFactory
import data.repositories.ClubMemberRepository
import printers.ClubMembersPrinter
import printers.MenuPrinter
import scanners.ClubMemberScanner
import scanners.IntScanner
import scanners.StringScanner
import ui.Button
import ui.factories.ButtonFactory
import ui.factories.MenuFactory
import validation.ClubMemberValidator
import validation.IntValidator
import validation.StringValidator

private val rep = ClubMemberRepository(DatabaseContextFactory())
private val validator = ClubMemberValidator()
private val factory = ClubMemberFactory(validator)
private val scanner = ClubMemberScanner(factory)
private val intValidator = IntValidator()
private val intScanner = IntScanner(intValidator)
private val strValidator = StringValidator()
private val strScanner = StringScanner(strValidator)

fun initMenu() {
    val menuFactory = MenuFactory()
    val menu = menuFactory.createMenu(initButtons())
    val menuPrinter = MenuPrinter(menu)
    while (true) {
        menuPrinter.drawMenu()
        var input: Int
        try {
            input = intScanner.scanEntity()
            menu.pickButton(input)
        }
        catch(ex: Exception){
            println(ex.message)
        }
    }
}

fun initDbWithData() {
    rep.addClubMember(ClubMember(1, "a", "a", "a", "AAA-304", 2.0))
    rep.addClubMember(ClubMember(2, "B", "b", "b", "AAA-305", 2.0))
}

fun initButtons(): List<Button> {
    val buttonsFactory = ButtonFactory()
    val showClubMembersButton = buttonsFactory
        .CreateButton(1, "Show all club members") {
            val result = rep.getClubMembers()
            val printer = ClubMembersPrinter()
            printer.printClubMembers(result)
        }

    val deleteClubMemberByIdButton = buttonsFactory
        .CreateButton(2, "Delete club member by Id") {
            print("Enter club member id: ")
            try {
                val id = intScanner.scanEntity()
                val clubMember = rep.getClubMemberById(id)
                rep.deleteClubMember(clubMember)
            }
            catch(ex: Exception) {
                println(ex.message)
            }
        }

    val addClubMemberButton = buttonsFactory
        .CreateButton(3, "Add club member") {
            try {
                val clubMember = scanner.scanEntity()
                rep.addClubMember(clubMember)
            }
            catch(exception: Exception) {
                println(exception.message)
            }
        }

    val sortClubMembersBySurnameButton = buttonsFactory
        .CreateButton(4, "Sort by Surname") {
            val result = rep.sortClubMembers(compareBy(ClubMember::surname))
            val printer = ClubMembersPrinter()
            printer.printClubMembers(result)
        }

    val sortClubMembersByExperienceButton = buttonsFactory
        .CreateButton(5, "Sort by experience") {
            val result = rep.sortClubMembers(compareBy(ClubMember::experience))
            val printer = ClubMembersPrinter()
            printer.printClubMembers(result)
        }

    val findClubMember = buttonsFactory
        .CreateButton(6, "Find club member by full name") {
            try{
                val splitedFullName = strScanner.scanEntity().split(" ")
                val result = rep.findClubMembers {
                    splitedFullName[0] == it.surname
                            && splitedFullName[1] == it.name
                            && splitedFullName[2] == it.patronymic
                }
                val printer = ClubMembersPrinter()
                printer.printClubMembers(result)
            }
            catch(ex: Exception) {
                println(ex.message)
            }


        }

    return listOf(
        showClubMembersButton,
        deleteClubMemberByIdButton,
        addClubMemberButton,
        sortClubMembersBySurnameButton,
        sortClubMembersByExperienceButton,
        findClubMember
    )
}
