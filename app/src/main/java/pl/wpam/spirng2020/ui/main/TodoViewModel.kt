package pl.wpam.spirng2020.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.wpam.spirng2020.repository.Todo
import pl.wpam.spirng2020.repository.TodoRepository
import java.util.*

class TodoViewModel : ViewModel() {

    private val todoRepository: TodoRepository = TodoRepository

    private val _toDos = MutableLiveData<List<Todo>>()
    val toDos: LiveData<List<Todo>>
        get() = _toDos

    fun addToDo() {
        _toDos.value = todoRepository.add(UUID.randomUUID().toString())
    }

    fun onResume() {
        refreshTodos()
    }

    fun done(todo: Todo) {
        todoRepository.markAsDone(todo)
        refreshTodos()
    }

    private fun refreshTodos() {
        _toDos.value = todoRepository.fetchTodo()
    }
}
