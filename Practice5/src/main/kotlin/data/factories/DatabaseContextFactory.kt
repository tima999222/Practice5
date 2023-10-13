package data.factories

import data.DatabaseContext

class DatabaseContextFactory : DataContextFactoryInterface<DatabaseContext> {
    private var _context: DatabaseContext? = null

    override fun createContext() : DatabaseContext {
        if (_context == null) {
            _context = DatabaseContext()
        }

        return _context as DatabaseContext
    }
}