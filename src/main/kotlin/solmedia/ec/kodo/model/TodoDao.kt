package solmedia.ec.kodo.model

import org.springframework.stereotype.Component

@Component
class TodoDao : Dao<Todo> {

    val todoList: MutableList<Todo?> = mutableListOf(
        Todo("""
            Type a "to do", change its priority by clicking
            on the number shown above, notes will be automatically
            sorted by their priority. If the number is lower,
            higher is your priority.
        """, 5)
    )

    override fun getAll(): Collection<Todo> {
        return todoList.filterNotNull().sortedBy { it.priority }
    }

    override fun save(t: Todo) {
        todoList.add(t)
    }

    override fun update(oldTodo: Todo, newTodo: Todo) {
        val item = todoList.indexOf(oldTodo)
        todoList[item] = newTodo
    }

    override fun delete(t: Todo) {
        todoList.remove(t)
    }
}