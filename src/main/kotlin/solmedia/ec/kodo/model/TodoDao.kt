package solmedia.ec.kodo.model

import org.springframework.stereotype.Component

@Component
class TodoDao : Dao<Todo> {

    val todoList: MutableList<Todo?> = mutableListOf(
        Todo(
            """
            Type a "to do", change its priority by clicking
            on the number shown above, notes will be automatically
            sorted by their priority. If the number is lower,
            higher is your priority.
        """, 5
        )
    )

    override fun getAll() = todoList.filterNotNull().sortedBy { it.priority }

    override fun save(entity: Todo) = todoList.add(entity)

    override fun update(oldEntity: Todo, newEntity: Todo) {
        val item = todoList.indexOf(oldEntity)
        todoList[item] = newEntity
    }

    override fun delete(entity: Todo) = todoList.remove(entity)
}