package interfaces

abstract class CrudService<T> {
    private var uid = 0
    var elements = mutableListOf<T>()

    fun getUid(): Int {
        return ++uid
    }

    fun clear() {
        elements = mutableListOf()
        uid = 0
    }

    abstract fun add(elem: T): T
    abstract fun edit(elem: T): Boolean
    abstract fun delete(id: Int): Boolean
    abstract fun get(): Array<T>
    abstract fun getById(id: Int): T?
}