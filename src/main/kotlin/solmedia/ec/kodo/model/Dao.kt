package solmedia.ec.kodo.model

interface Dao<T> {
    fun getAll(): Collection<T>
    fun save(t: T)
    fun update(t: T, t2: T)
    fun delete(t: T)
}