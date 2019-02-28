package solmedia.ec.kodo.model

interface Dao<T> {
    fun getAll(): Collection<T>
    fun save(entity: T): Boolean
    fun update(oldEntity: T, newEntity: T)
    fun delete(entity: T): Boolean
}