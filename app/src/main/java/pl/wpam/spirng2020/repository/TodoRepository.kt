package pl.wpam.spirng2020.repository

import pl.wpam.spirng2020.MainActivity
import pl.wpam.spirng2020.room.TodoDao
import pl.wpam.spirng2020.room.TodoEntity
import java.util.*

data class Todo (
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    var done: Boolean = false
) {
    constructor(todoEntity: TodoEntity): this(id = todoEntity.id!!, title = todoEntity.title!!, done = todoEntity.done)
}

object TodoRepository {

    private var toDosList  = mutableListOf<Todo>()
    private val todoDao: TodoDao = MainActivity.appDatabase!!.TodoDao()

    fun add(title: String) {
        todoDao.insertAll(TodoEntity(Todo(title = title)))
    }

    fun fetchTodo(): List<Todo> = todoDao.find(false)!!.map { Todo(it!!) }

    fun fetchDone(): List<Todo> = todoDao.find(true)!!.map { Todo(it!!) }

    fun markAsDone(todo: Todo) {
        todoDao.updateTodos(TodoEntity(todo.copy(done = true)))
    }
}