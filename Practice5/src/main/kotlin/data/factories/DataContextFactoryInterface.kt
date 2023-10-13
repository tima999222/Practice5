package data.factories

import data.DataBaseContextInterface

interface DataContextFactoryInterface<T> where  T: DataBaseContextInterface {
    fun createContext() : T
}