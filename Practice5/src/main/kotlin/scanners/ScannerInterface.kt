package scanners

interface ScannerInterface<T> {
    fun scanEntity() : T
}