package solmedia.ec.kodo.service

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import solmedia.ec.kodo.model.Dao
import solmedia.ec.kodo.model.Todo

@Scope(value = "session")
@Component(value = "todoService")
class TodoService(private val todoDao: Dao<Todo>) {

    fun getAll(): List<Todo> = todoDao.getAll().toList()

    fun save(todo: Todo) = todoDao.save(todo)

    fun update(oldTodo: Todo, newTodo: Todo) = todoDao.update(oldTodo, newTodo)

    fun delete(todo: Todo) = todoDao.delete(todo)
}