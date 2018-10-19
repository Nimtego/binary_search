package kotlinsrc
interface SearchK<T : Number> {
    fun sort(set: MutableList<T>): List<T>
    fun itemExists(item: T): Boolean
    fun sort(): List<T>
    fun putItem(item: T)
    fun binary(number: T): Int
}