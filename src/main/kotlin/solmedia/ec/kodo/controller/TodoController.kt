package solmedia.ec.kodo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import solmedia.ec.kodo.model.Todo
import solmedia.ec.kodo.service.TodoService

@Scope(value = "session")
@Component(value = "todoController")
class TodoController {

    @Autowired
    lateinit var todoService: TodoService

    var todoNew = Todo()

    fun getAllTodo() = todoService.getAll()

    fun saveTodo() {
        //validations u others actions
        todoService.save(todoNew)
        todoNew = Todo()
    }

    private fun updateTodo(oldTodo: Todo, newTodo: Todo) = todoService.update(oldTodo, newTodo)

    fun deleteTodo(todo: Todo) = todoService.delete(todo)

    fun changePriority(todo: Todo) {
        val priority = if (todo.priority == 10) 1 else todo.priority + 1
        val copyTodo = todo.copy(priority = priority)
        updateTodo(todo, copyTodo)
    }

}