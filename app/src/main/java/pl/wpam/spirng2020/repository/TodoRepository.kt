package pl.wpam.spirng2020.repository

import java.util.*

data class Todo (
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    var done: Boolean = false
)

object TodoRepository {

    private var toDosList  = mutableListOf<Todo>()

    fun add(title: String) : List<Todo> = toDosList.apply { add(Todo(title = title)) }

    fun fetchAll(): List<Todo> = toDosList

    fun fetchTodo(): List<Todo> = toDosList.filter { !it.done }

    fun fetchDone(): List<Todo> = toDosList.filter { it.done }

    fun markAsDone(todo: Todo) {
        toDosList
            .find { it.id == todo.id }
            ?.done = true
    }
}